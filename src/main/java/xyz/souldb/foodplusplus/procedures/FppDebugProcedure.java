package xyz.souldb.foodplusplus.procedures;

import xyz.souldb.foodplusplus.item.BlueberrySeedsItem;
import xyz.souldb.foodplusplus.item.BlueberriesItem;
import xyz.souldb.foodplusplus.block.BlueberryPlantBlock;
import xyz.souldb.foodplusplus.block.BlueGrow3Block;
import xyz.souldb.foodplusplus.block.BlueGrow2Block;
import xyz.souldb.foodplusplus.block.BlueGrow1Block;
import xyz.souldb.foodplusplus.FoodplusplusMod;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.Map;

public class FppDebugProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodplusplusMod.LOGGER.warn("Failed to load dependency entity for procedure FppDebug!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("[Food++ Debug]"), (true));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("[Food++ Debug]- Mod version: pre"), (true));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity)
					.sendStatusMessage(new StringTextComponent((("[Food++ Debug]- gamedir: ") + "" + (Minecraft.getInstance().gameDir))), (true));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(
					new StringTextComponent((("[Food++ Debug]- Item names: ") + "" + ((((new ItemStack(BlueberriesItem.block).getDisplayName()
							.getString()))
							+ ""
							+ ((((new ItemStack(BlueberryPlantBlock.block).getDisplayName().getString())) + ""
									+ ((((new ItemStack(BlueGrow3Block.block).getDisplayName().getString())) + ""
											+ ((((new ItemStack(BlueGrow2Block.block).getDisplayName().getString())) + ""
													+ (((null) + "" + ((((new ItemStack(BlueGrow1Block.block).getDisplayName().getString())) + ""
															+ ((new ItemStack(BlueberrySeedsItem.block).getDisplayName().getString())))))))))))))))),
					(true));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("[Food++ Debug]- Game versions: 1.16.4/5, 1.17 coming soon"), (true));
		}
	}
}
