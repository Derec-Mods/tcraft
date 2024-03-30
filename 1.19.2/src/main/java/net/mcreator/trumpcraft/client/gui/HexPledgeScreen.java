package net.mcreator.trumpcraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.trumpcraft.world.inventory.HexPledgeMenu;
import net.mcreator.trumpcraft.network.HexPledgeButtonMessage;
import net.mcreator.trumpcraft.TrumpcraftMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class HexPledgeScreen extends AbstractContainerScreen<HexPledgeMenu> {
	private final static HashMap<String, Object> guistate = HexPledgeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;

	public HexPledgeScreen(HexPledgeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 255;
		this.imageHeight = 240;
	}

	private static final ResourceLocation texture = new ResourceLocation("trumpcraft:textures/screens/hex_pledge.png");

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
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_pledge_to_the_hex_the_coalition"), 46, 3, -16724737);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_and_the_sixteenth_legion"), 64, 12, -16724737);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_i_swear_to_the_sixteenth_this_s"), 5, 21, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_the_leaders_of_the_16th_legion"), 5, 30, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_to_the_people"), 5, 39, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_i_shall_give_unconditional_obed"), 5, 57, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_brave_soldier_i_shall_at_all_tim"), 5, 66, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_to_give_my_life_for_this_cause"), 5, 75, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_i_declare_that_i_renounce_all_a"), 5, 93, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_fidelity_to_any_foreign_figure"), 5, 102, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_sovereignty_of_whom_or_which_i_w"), 5, 111, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_i_will_support_and_defend_the_1"), 5, 129, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_all_enemies_trump_related_or_fo"), 5, 138, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_i_will_bear_arms_on_behalf_of_t"), 5, 156, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_perform_service_in_the_armed_for"), 5, 165, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_i_will_perform_work_of_organizat"), 5, 174, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_i_take_this_responsibility_free"), 5, 192, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_mental_reservation_or_purpose_of"), 5, 201, -16737844);
		this.font.draw(poseStack, Component.translatable("gui.trumpcraft.hex_pledge.label_glory_to_the_sixteenth"), 73, 210, -16737844);
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
		button_back = new Button(this.leftPos + 56, this.topPos + 219, 144, 20, Component.translatable("gui.trumpcraft.hex_pledge.button_back"), e -> {
			if (true) {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new HexPledgeButtonMessage(0, x, y, z));
				HexPledgeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
	}
}
