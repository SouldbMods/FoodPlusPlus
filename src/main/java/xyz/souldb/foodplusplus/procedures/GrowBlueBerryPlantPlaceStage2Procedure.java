package xyz.souldb.foodplusplus.procedures;

import xyz.souldb.foodplusplus.block.BlueGrow3Block;
import xyz.souldb.foodplusplus.FoodplusplusMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;
import java.util.Map;

public class GrowBlueBerryPlantPlaceStage2Procedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FoodplusplusMod.LOGGER.warn("Failed to load dependency x for procedure GrowBlueBerryPlantPlaceStage2!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FoodplusplusMod.LOGGER.warn("Failed to load dependency y for procedure GrowBlueBerryPlantPlaceStage2!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FoodplusplusMod.LOGGER.warn("Failed to load dependency z for procedure GrowBlueBerryPlantPlaceStage2!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FoodplusplusMod.LOGGER.warn("Failed to load dependency world for procedure GrowBlueBerryPlantPlaceStage2!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;
			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if ((9 < (world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getLightValue()))) {
					if ((((new Random()).nextInt((int) 600 + 1)) == 69)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlueGrow3Block.block.getDefaultState(), 3);
					}
				} else {
					if ((((new Random()).nextInt((int) 600 + 1)) == 69)) {
						FoodplusplusMod.LOGGER.debug("[Food++] Light level lower than 9 on growth check");
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 20);
	}
}
