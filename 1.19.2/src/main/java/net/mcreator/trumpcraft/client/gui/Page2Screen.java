package net.mcreator.trumpcraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.trumpcraft.world.inventory.Page2Menu;
import net.mcreator.trumpcraft.network.Page2ButtonMessage;
import net.mcreator.trumpcraft.TrumpcraftMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class Page2Screen extends AbstractContainerScreen<Page2Menu> {
	private final static HashMap<String, Object> guistate = Page2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;

	public Page2Screen(Page2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 195;
	}

	private static final ResourceLocation texture = new ResourceLocation("trumpcraft:textures/screens/page_2.png");

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
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_wall_maria_patrol_part_1"), 18, 7, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_another_great_day_in_this_icy"), 18, 25, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_dump"), 18, 34, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_agreed_cant_wait_to_leave"), 18, 43, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_distant_gunfire"), 18, 52, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_audio_recording"), 18, 16, -10040065);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_looks_like_theyre_trying_to"), 18, 61, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_climb_up_again"), 18, 70, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_well_you_know_the_drill_lets"), 18, 79, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_wait"), 18, 88, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_what_the_hell_is_that_thing"), 18, 97, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_distant_screaming"), 18, 106, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_ah_shtbattle_stations"), 18, 115, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_i_repeat_all_units_rep"), 18, 124, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.page_2.label_explosion"), 18, 133, -16777216);
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
		button_back = new Button(this.leftPos + 18, this.topPos + 169, 162, 20, Component.translatable("gui.trumpcraft.page_2.button_back"), e -> {
			if (true) {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new Page2ButtonMessage(0, x, y, z));
				Page2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
	}
}
