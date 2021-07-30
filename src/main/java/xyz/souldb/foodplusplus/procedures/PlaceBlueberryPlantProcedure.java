package xyz.souldb.foodplusplus.procedures;

import xyz.souldb.foodplusplus.block.BlueGrow1Block;
import xyz.souldb.foodplusplus.FoodplusplusMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

public class PlaceBlueberryPlantProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FoodplusplusMod.LOGGER.warn("Failed to load dependency x for procedure PlaceBlueberryPlant!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FoodplusplusMod.LOGGER.warn("Failed to load dependency y for procedure PlaceBlueberryPlant!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FoodplusplusMod.LOGGER.warn("Failed to load dependency z for procedure PlaceBlueberryPlant!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FoodplusplusMod.LOGGER.warn("Failed to load dependency world for procedure PlaceBlueberryPlant!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.BEDROCK))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BlueGrow1Block.block.getDefaultState(), 3);
		} else if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.END_PORTAL))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BlueGrow1Block.block.getDefaultState(), 3);
		} else if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.END_PORTAL))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BlueGrow1Block.block.getDefaultState(), 3);
		} else if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.BARRIER))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BlueGrow1Block.block.getDefaultState(), 3);
		} else if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.END_PORTAL_FRAME))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BlueGrow1Block.block.getDefaultState(), 3);
		}
	}
}
