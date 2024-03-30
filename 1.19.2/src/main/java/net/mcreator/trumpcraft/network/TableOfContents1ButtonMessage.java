
package net.mcreator.trumpcraft.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.trumpcraft.world.inventory.TableOfContents1Menu;
import net.mcreator.trumpcraft.procedures.OpenHexPledgeProcedure;
import net.mcreator.trumpcraft.procedures.OpenFakeIntroProcedure;
import net.mcreator.trumpcraft.procedures.Gotopage1Procedure;
import net.mcreator.trumpcraft.procedures.GotoWallMariaPart2Procedure;
import net.mcreator.trumpcraft.procedures.GotoPage2Procedure;
import net.mcreator.trumpcraft.TrumpcraftMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TableOfContents1ButtonMessage {
	private final int buttonID, x, y, z;

	public TableOfContents1ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public TableOfContents1ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(TableOfContents1ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(TableOfContents1ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = TableOfContents1Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenFakeIntroProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			Gotopage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			GotoPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			GotoWallMariaPart2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenHexPledgeProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TrumpcraftMod.addNetworkMessage(TableOfContents1ButtonMessage.class, TableOfContents1ButtonMessage::buffer, TableOfContents1ButtonMessage::new, TableOfContents1ButtonMessage::handler);
	}
}
