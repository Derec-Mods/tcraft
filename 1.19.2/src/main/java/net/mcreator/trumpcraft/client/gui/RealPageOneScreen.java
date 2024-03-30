package net.mcreator.trumpcraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.trumpcraft.world.inventory.RealPageOneMenu;
import net.mcreator.trumpcraft.network.RealPageOneButtonMessage;
import net.mcreator.trumpcraft.TrumpcraftMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class RealPageOneScreen extends AbstractContainerScreen<RealPageOneMenu> {
	private final static HashMap<String, Object> guistate = RealPageOneMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	Button button_link_to_lorebook;

	public RealPageOneScreen(RealPageOneMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 195;
	}

	private static final ResourceLocation texture = new ResourceLocation("trumpcraft:textures/screens/real_page_one.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("trumpcraft:textures/screens/trumpskin.png"));
		this.blit(ms, this.leftPos + 136, this.topPos + 24, 0, 0, 256, 256, 256, 256);

		RenderSystem.setShaderTexture(0, new ResourceLocation("trumpcraft:textures/screens/trumpcraft.png"));
		this.blit(ms, this.leftPos + 1, this.topPos + 2, 0, 0, 256, 256, 256, 256);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.real_page_one.label_choose_a_side"), 6, 52, -16737793);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.real_page_one.label_or_kill_them_all"), 6, 70, -10092544);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_back = new Button(this.leftPos + 24, this.topPos + 169, 117, 20, Component.translatable("gui.trumpcraft.real_page_one.button_back"), e -> {
			if (true) {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new RealPageOneButtonMessage(0, x, y, z));
				RealPageOneButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_link_to_lorebook = new Button(this.leftPos + 6, this.topPos + 25, 117, 20, Component.translatable("gui.trumpcraft.real_page_one.button_link_to_lorebook"), e -> {
			if (true) {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new RealPageOneButtonMessage(1, x, y, z));
				RealPageOneButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_link_to_lorebook", button_link_to_lorebook);
		this.addRenderableWidget(button_link_to_lorebook);
	}
}
