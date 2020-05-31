package net.mcreator.trumpcraft;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.LogicalSide;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.World;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class TrumpcraftModVariables {
	public static boolean isscope = false;
	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "trumpcraft_worldvars";
		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			return nbt;
		}

		public void syncData(World world) {
			this.markDirty();
			if (world.isRemote) {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new WorldSavedDataSyncMessage(1, this));
			} else {
				TrumpcraftMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(world.dimension::getType), new WorldSavedDataSyncMessage(1, this));
			}
		}
		static WorldVariables clientSide = new WorldVariables();
		public static WorldVariables get(World world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
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
		public double Snipes = 0;
		public double CitizensKilled = 0;
		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
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
			Snipes = nbt.getDouble("Snipes");
			CitizensKilled = nbt.getDouble("CitizensKilled");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
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
			nbt.putDouble("Snipes", Snipes);
			nbt.putDouble("CitizensKilled", CitizensKilled);
			return nbt;
		}

		public void syncData(World world) {
			this.markDirty();
			if (world.isRemote) {
				TrumpcraftMod.PACKET_HANDLER.sendToServer(new WorldSavedDataSyncMessage(0, this));
			} else {
				TrumpcraftMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
			}
		}
		static MapVariables clientSide = new MapVariables();
		public static MapVariables get(World world) {
			if (world instanceof ServerWorld) {
				return world.getServer().getWorld(DimensionType.OVERWORLD).getSavedData().getOrCreate(MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;
		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			if (this.type == 0)
				this.data = new MapVariables();
			else
				this.data = new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (context.getDirection().getReceptionSide().isServer())
					syncData(message, context.getDirection().getReceptionSide(), context.getSender().world);
				else
					syncData(message, context.getDirection().getReceptionSide(), Minecraft.getInstance().player.world);
			});
			context.setPacketHandled(true);
		}

		private static void syncData(WorldSavedDataSyncMessage message, LogicalSide side, World world) {
			if (side.isServer()) {
				message.data.markDirty();
				if (message.type == 0) {
					TrumpcraftMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), message);
					world.getServer().getWorld(DimensionType.OVERWORLD).getSavedData().set(message.data);
				} else {
					TrumpcraftMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(world.dimension::getType), message);
					((ServerWorld) world).getSavedData().set(message.data);
				}
			} else {
				if (message.type == 0) {
					MapVariables.clientSide = (MapVariables) message.data;
				} else {
					WorldVariables.clientSide = (WorldVariables) message.data;
				}
			}
		}
	}
}
