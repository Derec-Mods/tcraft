
package net.mcreator.trumpcraft.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.trumpcraft.TrumpcraftModVariables;
import net.mcreator.trumpcraft.TrumpcraftModElements;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@TrumpcraftModElements.ModElement.Tag
public class TestOverlay extends TrumpcraftModElements.ModElement {
	public TestOverlay(TrumpcraftModElements instance) {
		super(instance, 173);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			int x = (int) entity.getPosX();
			int y = (int) entity.getPosY();
			int z = (int) entity.getPosZ();
			if ((TrumpcraftModVariables.isscope)) {
				RenderSystem.disableDepthTest();
				RenderSystem.depthMask(false);
				RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
						GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				RenderSystem.disableAlphaTest();
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("trumpcraft:textures/battleriflescope.png"));
				Minecraft.getInstance().ingameGUI.blit(0, 0, 0, 0, 420, 250, event.getWindow().getScaledWidth(), event.getWindow().getScaledHeight());
				RenderSystem.depthMask(true);
				RenderSystem.enableDepthTest();
				RenderSystem.enableAlphaTest();
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}
}
