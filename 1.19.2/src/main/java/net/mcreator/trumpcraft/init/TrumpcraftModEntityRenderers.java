
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trumpcraft.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.trumpcraft.client.renderer.VladRenderer;
import net.mcreator.trumpcraft.client.renderer.TrumpSquad3Renderer;
import net.mcreator.trumpcraft.client.renderer.TrumpSquad2Renderer;
import net.mcreator.trumpcraft.client.renderer.TrumpSquad1Renderer;
import net.mcreator.trumpcraft.client.renderer.TrumpSoldierRenderer;
import net.mcreator.trumpcraft.client.renderer.TrumpScoutRenderer;
import net.mcreator.trumpcraft.client.renderer.TrumpRenderer;
import net.mcreator.trumpcraft.client.renderer.TheTrumpRenderer;
import net.mcreator.trumpcraft.client.renderer.TheFnaticRenderer;
import net.mcreator.trumpcraft.client.renderer.ThankyourandomcitizenRenderer;
import net.mcreator.trumpcraft.client.renderer.TestSubjectRenderer;
import net.mcreator.trumpcraft.client.renderer.TestSubject4Renderer;
import net.mcreator.trumpcraft.client.renderer.TestSubject3Renderer;
import net.mcreator.trumpcraft.client.renderer.TestSubject1Renderer;
import net.mcreator.trumpcraft.client.renderer.SashaRenderer;
import net.mcreator.trumpcraft.client.renderer.LivingBombRenderer;
import net.mcreator.trumpcraft.client.renderer.EvaRenderer;
import net.mcreator.trumpcraft.client.renderer.DeathSquadGolemRenderer;
import net.mcreator.trumpcraft.client.renderer.ArmoredTrumpSoldierRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TrumpcraftModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TrumpcraftModEntities.TRUMPWANNABE.get(), TrumpRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.THE_TRUMP.get(), TheTrumpRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.EVA.get(), EvaRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.ANTI_TRUMP_TOOL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.PISTOL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.AWP.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.M_57_PILUM.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.MAGA_SHOTGUN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.TRUMP_NADE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.TRUMP_SOLDIER.get(), TrumpSoldierRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.THANKYOURANDOMCITIZEN.get(), ThankyourandomcitizenRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.LIVING_BOMB.get(), LivingBombRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.TRUMP_SQUAD_1.get(), TrumpSquad1Renderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.TRUMP_SQUAD_2.get(), TrumpSquad2Renderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.TRUMP_SQUAD_3.get(), TrumpSquad3Renderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.ARMORED_TRUMP_SOLDIER.get(), ArmoredTrumpSoldierRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.TEST_SUBJECT_1.get(), TestSubject1Renderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.TEST_SUBJECT.get(), TestSubjectRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.TEST_SUBJECT_3.get(), TestSubject3Renderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.TEST_SUBJECT_4.get(), TestSubject4Renderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.TRUMP_SCOUT.get(), TrumpScoutRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.SASHA.get(), SashaRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.THE_FNATIC.get(), TheFnaticRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.DEATH_SQUAD_GOLEM.get(), DeathSquadGolemRenderer::new);
		event.registerEntityRenderer(TrumpcraftModEntities.VLAD.get(), VladRenderer::new);
	}
}
