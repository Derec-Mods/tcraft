package net.mcreator.trumpcraft.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.trumpcraft.TrumpcraftMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TrumpcraftModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		TrumpcraftMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level);
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (mapdata != null)
					TrumpcraftMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					TrumpcraftMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (worlddata != null)
					TrumpcraftMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "trumpcraft_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				TrumpcraftMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "trumpcraft_mapvars";
		public double KilledTheTrump = 0;
		public double KilledTheHex = 0;
		public double TrumpSoldiersKilled = 0;
		public double HexSoldiersKilled = 0;
		public double ChaoticNeutral = 0;
		public String HasTrumpBeenKilled = " ";
		public String HasHexBeenKilled = " ";
		public double TrumpStage = 1;
		public boolean hasopenedbook = false;
		public String Page1 = "Locked";
		public String Page2 = "Locked";
		public String Page3 = "Locked";
		public boolean UnlockedPage1 = true;
		public boolean UnlockedWallMariaPatrol1 = false;
		public boolean UnlockedWallMariaPatrol2 = false;
		public boolean UnlockedHexSoldierPledge = false;
		public String HexSoldierPledge = "Locked";
		public boolean UnlockedHexBeforeAttack1 = false;
		public String BeforeAttack1 = "Locked";

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			KilledTheTrump = nbt.getDouble("KilledTheTrump");
			KilledTheHex = nbt.getDouble("KilledTheHex");
			TrumpSoldiersKilled = nbt.getDouble("TrumpSoldiersKilled");
			HexSoldiersKilled = nbt.getDouble("HexSoldiersKilled");
			ChaoticNeutral = nbt.getDouble("ChaoticNeutral");
			HasTrumpBeenKilled = nbt.getString("HasTrumpBeenKilled");
			HasHexBeenKilled = nbt.getString("HasHexBeenKilled");
			TrumpStage = nbt.getDouble("TrumpStage");
			hasopenedbook = nbt.getBoolean("hasopenedbook");
			Page1 = nbt.getString("Page1");
			Page2 = nbt.getString("Page2");
			Page3 = nbt.getString("Page3");
			UnlockedPage1 = nbt.getBoolean("UnlockedPage1");
			UnlockedWallMariaPatrol1 = nbt.getBoolean("UnlockedWallMariaPatrol1");
			UnlockedWallMariaPatrol2 = nbt.getBoolean("UnlockedWallMariaPatrol2");
			UnlockedHexSoldierPledge = nbt.getBoolean("UnlockedHexSoldierPledge");
			HexSoldierPledge = nbt.getString("HexSoldierPledge");
			UnlockedHexBeforeAttack1 = nbt.getBoolean("UnlockedHexBeforeAttack1");
			BeforeAttack1 = nbt.getString("BeforeAttack1");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("KilledTheTrump", KilledTheTrump);
			nbt.putDouble("KilledTheHex", KilledTheHex);
			nbt.putDouble("TrumpSoldiersKilled", TrumpSoldiersKilled);
			nbt.putDouble("HexSoldiersKilled", HexSoldiersKilled);
			nbt.putDouble("ChaoticNeutral", ChaoticNeutral);
			nbt.putString("HasTrumpBeenKilled", HasTrumpBeenKilled);
			nbt.putString("HasHexBeenKilled", HasHexBeenKilled);
			nbt.putDouble("TrumpStage", TrumpStage);
			nbt.putBoolean("hasopenedbook", hasopenedbook);
			nbt.putString("Page1", Page1);
			nbt.putString("Page2", Page2);
			nbt.putString("Page3", Page3);
			nbt.putBoolean("UnlockedPage1", UnlockedPage1);
			nbt.putBoolean("UnlockedWallMariaPatrol1", UnlockedWallMariaPatrol1);
			nbt.putBoolean("UnlockedWallMariaPatrol2", UnlockedWallMariaPatrol2);
			nbt.putBoolean("UnlockedHexSoldierPledge", UnlockedHexSoldierPledge);
			nbt.putString("HexSoldierPledge", HexSoldierPledge);
			nbt.putBoolean("UnlockedHexBeforeAttack1", UnlockedHexBeforeAttack1);
			nbt.putString("BeforeAttack1", BeforeAttack1);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				TrumpcraftMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
