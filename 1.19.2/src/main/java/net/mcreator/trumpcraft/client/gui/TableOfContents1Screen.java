package net.mcreator.trumpcraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.trumpcraft.world.inventory.TableOfContents1Menu;
import net.mcreator.trumpcraft.network.TableOfContents1ButtonMessage;
import net.mcreator.trumpcraft.TrumpcraftMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class TableOfContents1Screen extends AbstractContainerScreen<TableOfContents1Menu> {
	private final static HashMap<String, Object> guistate = TableOfContents1Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_intro;
	Button button_real_intro;
	Button button_wall_maria_1;
	Button button_wall_maria_2;
	Button button_the_hex_pledge;
	Button button_before_the_fall_1;

	public TableOfContents1Screen(TableOfContents1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 182;
		this.imageHeight = 225;
	}

	private static final ResourceLocation texture = new ResourceLocation("trumpcraft:textures/screens/table_of_contents_1.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("trumpcraft:textures/screens/trumpcraft.png"));
		this.blit(ms, this.leftPos + 20, this.topPos + 4, 0, 0, 256, 256, 256, 256);

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
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.table_of_contents_1.label_varpage1"), 72, 67, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.table_of_contents_1.label_varpage2"), 81, 94, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.table_of_contents_1.label_varpage3"), 81, 121, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.table_of_contents_1.label_varhexsoldierpledge"), 90, 148, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.table_of_contents_1.label_varbeforeattack1"), 108, 175, -16777216);
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
		button_intro = new Button(this.leftPos + 9, this.topPos + 31, 50, 20, Component.translatable("gui.trumpcraft.table_of_contents_1.button_intro"), e -> {
			if (true) {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new TableOfContents1ButtonMessage(0, x, y, z));
				TableOfContents1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_intro", button_intro);
		this.addRenderableWidget(button_intro);
		button_real_intro = new Button(this.leftPos + 9, this.topPos + 58, 162, 20, Component.translatable("gui.trumpcraft.table_of_contents_1.button_real_intro"), e -> {
			if (true) {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new TableOfContents1ButtonMessage(1, x, y, z));
				TableOfContents1ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_real_intro", button_real_intro);
		this.addRenderableWidget(button_real_intro);
		button_wall_maria_1 = new Button(this.leftPos + 9, this.topPos + 85, 162, 20, Component.translatable("gui.trumpcraft.table_of_contents_1.button_wall_maria_1"), e -> {
			if (true) {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new TableOfContents1ButtonMessage(2, x, y, z));
				TableOfContents1ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_wall_maria_1", button_wall_maria_1);
		this.addRenderableWidget(button_wall_maria_1);
		button_wall_maria_2 = new Button(this.leftPos + 9, this.topPos + 112, 162, 20, Component.translatable("gui.trumpcraft.table_of_contents_1.button_wall_maria_2"), e -> {
			if (true) {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new TableOfContents1ButtonMessage(3, x, y, z));
				TableOfContents1ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_wall_maria_2", button_wall_maria_2);
		this.addRenderableWidget(button_wall_maria_2);
		button_the_hex_pledge = new Button(this.leftPos + 9, this.topPos + 139, 162, 20, Component.translatable("gui.trumpcraft.table_of_contents_1.button_the_hex_pledge"), e -> {
			if (true) {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new TableOfContents1ButtonMessage(4, x, y, z));
				TableOfContents1ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_the_hex_pledge", button_the_hex_pledge);
		this.addRenderableWidget(button_the_hex_pledge);
		button_before_the_fall_1 = new Button(this.leftPos + 9, this.topPos + 166, 162, 20, Component.translatable("gui.trumpcraft.table_of_contents_1.button_before_the_fall_1"), e -> {
		});
		guistate.put("button:button_before_the_fall_1", button_before_the_fall_1);
		this.addRenderableWidget(button_before_the_fall_1);
	}
}
