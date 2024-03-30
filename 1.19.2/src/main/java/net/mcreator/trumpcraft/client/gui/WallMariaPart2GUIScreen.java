package net.mcreator.trumpcraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.trumpcraft.world.inventory.WallMariaPart2GUIMenu;
import net.mcreator.trumpcraft.network.WallMariaPart2GUIButtonMessage;
import net.mcreator.trumpcraft.TrumpcraftMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class WallMariaPart2GUIScreen extends AbstractContainerScreen<WallMariaPart2GUIMenu> {
	private final static HashMap<String, Object> guistate = WallMariaPart2GUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;

	public WallMariaPart2GUIScreen(WallMariaPart2GUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 195;
	}

	private static final ResourceLocation texture = new ResourceLocation("trumpcraft:textures/screens/wall_maria_part_2_gui.png");

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
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_wall_maria_patrol_part_2"), 18, 7, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_ai_log"), 18, 16, -10040065);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_new_to_the_table_this_time"), 18, 61, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_there_are_alarms_everywhere"), 18, 25, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_sector_s42_is_under_attack"), 18, 34, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_this_is_not_a_drill_all_units"), 18, 151, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_the_enemy_is_scaling_the_wall"), 18, 160, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_the_roar_of_their_bombers_tears"), 18, 70, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_interestingit_appears_that"), 18, 43, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_our_enemy_has_brought_something"), 18, 52, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_through_the_sky_this_is_not_goo"), 18, 79, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_the_walls_were_always_meant_to_b"), 18, 88, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_more_deterrents_than_actual_wall"), 18, 97, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_anyway_now_the_enemy_is_at_our"), 18, 106, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_gates_with_a_new_weapon"), 18, 115, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_a_victory_for_us_is_very_slim"), 18, 124, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_but_they_choose_to_fight_anyway"), 18, 133, -16777216);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.label_very_well_ill_cooperate"), 18, 142, -16777216);
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
		button_back = new Button(this.leftPos + 18, this.topPos + 169, 162, 20, Component.translatable("gui.trumpcraft.wall_maria_part_2_gui.button_back"), e -> {
			if (true) {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new WallMariaPart2GUIButtonMessage(0, x, y, z));
				WallMariaPart2GUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
	}
}
