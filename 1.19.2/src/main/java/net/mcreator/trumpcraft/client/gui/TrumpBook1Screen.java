package net.mcreator.trumpcraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.trumpcraft.world.inventory.TrumpBook1Menu;
import net.mcreator.trumpcraft.network.TrumpBook1ButtonMessage;
import net.mcreator.trumpcraft.TrumpcraftMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class TrumpBook1Screen extends AbstractContainerScreen<TrumpBook1Menu> {
	private final static HashMap<String, Object> guistate = TrumpBook1Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_for_your_convenience;

	public TrumpBook1Screen(TrumpBook1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 225;
	}

	private static final ResourceLocation texture = new ResourceLocation("trumpcraft:textures/screens/trump_book_1.png");

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
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_so_you_want_to_hear"), 56, 4, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_another_story_eh"), 56, 13, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_one_where_the_fate_of_pan"), 56, 22, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_oops_wrong_story"), 56, 31, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_channeling_my"), 56, 40, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_nonexistent_improv_skills"), 56, 49, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_aight_here_we_go_4th_wall_will"), -28, 58, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_oh_so_you_do_wanna_hear_a_story"), 56, 157, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_im_gonna_assume_youre"), 56, 67, -16764058);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_someone_who_got_that_joke"), 56, 76, -16764058);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_then_turn_the_page"), 39, 177, -3407872);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_theres_a_budget"), 122, 190, -3407872);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_so_since_ive_wasted"), 56, 85, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_most_of_the_page_ill_just"), 56, 94, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_introduce_myself_with_this_line"), 56, 103, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_im_the_dev_aka_your_narrator"), 56, 121, -16750900);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_i_tell_the_story"), 56, 139, -16738048);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.trump_book_1.label_im_also_bad_at_that"), 56, 148, -10092442);
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
		button_for_your_convenience = new Button(this.leftPos + 26, this.topPos + 201, 200, 20, Component.translatable("gui.trumpcraft.trump_book_1.button_for_your_convenience"), e -> {
			if (true) {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new TrumpBook1ButtonMessage(0, x, y, z));
				TrumpBook1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_for_your_convenience", button_for_your_convenience);
		this.addRenderableWidget(button_for_your_convenience);
	}
}
