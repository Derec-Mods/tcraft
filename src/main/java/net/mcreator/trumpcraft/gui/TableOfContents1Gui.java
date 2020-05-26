
package net.mcreator.trumpcraft.gui;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.Minecraft;

import net.mcreator.trumpcraft.procedures.OpenHexPledgeProcedure;
import net.mcreator.trumpcraft.procedures.OpenFakeIntroProcedure;
import net.mcreator.trumpcraft.procedures.Gotopage1Procedure;
import net.mcreator.trumpcraft.procedures.GotoWallMariaPart2Procedure;
import net.mcreator.trumpcraft.procedures.GotoPage2Procedure;
import net.mcreator.trumpcraft.TrumpcraftModVariables;
import net.mcreator.trumpcraft.TrumpcraftModElements;
import net.mcreator.trumpcraft.TrumpcraftMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@TrumpcraftModElements.ModElement.Tag
public class TableOfContents1Gui extends TrumpcraftModElements.ModElement {
	public static HashMap guistate = new HashMap();
	private static ContainerType<GuiContainerMod> containerType = null;
	public TableOfContents1Gui(TrumpcraftModElements instance) {
		super(instance, 114);
		elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
				ButtonPressedMessage::handler);
		elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
				GUISlotChangedMessage::handler);
		containerType = new ContainerType<>(new GuiContainerModFactory());
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, GuiWindow::new));
	}

	@SubscribeEvent
	public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().register(containerType.setRegistryName("tableofcontents1"));
	}
	public static class GuiContainerModFactory implements IContainerFactory {
		public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
			return new GuiContainerMod(id, inv, extraData);
		}
	}

	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		private World world;
		private PlayerEntity entity;
		private int x, y, z;
		private IItemHandler internal;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		private boolean bound = false;
		public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
			super(containerType, id);
			this.entity = inv.player;
			this.world = inv.player.world;
			this.internal = new ItemStackHandler(0);
			BlockPos pos = null;
			if (extraData != null) {
				pos = extraData.readBlockPos();
				this.x = pos.getX();
				this.y = pos.getY();
				this.z = pos.getZ();
			}
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(PlayerEntity player) {
			return true;
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class GuiWindow extends ContainerScreen<GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		public GuiWindow(GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 182;
			this.ySize = 225;
		}
		private static final ResourceLocation texture = new ResourceLocation("trumpcraft:textures/tableofcontents1.png");
		@Override
		public void render(int mouseX, int mouseY, float partialTicks) {
			this.renderBackground();
			super.render(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			Minecraft.getInstance().getTextureManager().bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.blit(k, l, 0, 0, this.xSize, this.ySize);
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("trumpcraft:textures/trumpcraft.png"));
			this.blit(this.guiLeft + 21, this.guiTop + 5, 0, 0, 256, 256);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
			this.font.drawString("" + (TrumpcraftModVariables.MapVariables.get(world).Page1) + "", 73, 68, -16777216);
			this.font.drawString("" + (TrumpcraftModVariables.MapVariables.get(world).Page2) + "", 82, 95, -16777216);
			this.font.drawString("" + (TrumpcraftModVariables.MapVariables.get(world).Page3) + "", 82, 122, -16777216);
			this.font.drawString("" + (TrumpcraftModVariables.MapVariables.get(world).HexSoldierPledge) + "", 91, 149, -16777216);
			this.font.drawString("" + (TrumpcraftModVariables.MapVariables.get(world).BeforeAttack1) + "", 109, 176, -16777216);
		}

		@Override
		public void removed() {
			super.removed();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
			this.addButton(new Button(this.guiLeft + 10, this.guiTop + 32, 50, 20, "Intro", e -> {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(0, x, y, z));
				handleButtonAction(entity, 0, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 10, this.guiTop + 59, 162, 20, "Real Intro:                   ", e -> {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(1, x, y, z));
				handleButtonAction(entity, 1, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 10, this.guiTop + 86, 162, 20, "Wall Maria 1:                 ", e -> {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(2, x, y, z));
				handleButtonAction(entity, 2, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 10, this.guiTop + 113, 162, 20, "Wall Maria 2:                 ", e -> {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(3, x, y, z));
				handleButtonAction(entity, 3, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 10, this.guiTop + 140, 162, 20, "The Hex Pledge:               ", e -> {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(4, x, y, z));
				handleButtonAction(entity, 4, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 10, this.guiTop + 167, 162, 20, "Before The Fall 1:            ", e -> {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(5, x, y, z));
				handleButtonAction(entity, 5, x, y, z);
			}));
		}
	}

	public static class ButtonPressedMessage {
		int buttonID, x, y, z;
		public ButtonPressedMessage(PacketBuffer buffer) {
			this.buttonID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
		}

		public ButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.buttonID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
		}

		public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}

	public static class GUISlotChangedMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		public GUISlotChangedMessage(PacketBuffer buffer) {
			this.slotID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
			this.changeType = buffer.readInt();
			this.meta = buffer.readInt();
		}

		public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.slotID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
			buffer.writeInt(message.changeType);
			buffer.writeInt(message.meta);
		}

		public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}
	private static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				OpenFakeIntroProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 1) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				Gotopage1Procedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 2) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				GotoPage2Procedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 3) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				GotoWallMariaPart2Procedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 4) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				OpenHexPledgeProcedure.executeProcedure($_dependencies);
			}
		}
	}

	private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}
}
