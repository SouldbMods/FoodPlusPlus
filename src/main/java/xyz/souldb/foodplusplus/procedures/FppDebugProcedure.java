package xyz.souldb.foodplusplus.procedures;

import xyz.souldb.foodplusplus.item.BlueberrySeedsItem;
import xyz.souldb.foodplusplus.item.BlueberriesItem;
import xyz.souldb.foodplusplus.block.BlueberryPlantBlock;
import xyz.souldb.foodplusplus.block.BlueGrow3Block;
import xyz.souldb.foodplusplus.block.BlueGrow2Block;
import xyz.souldb.foodplusplus.block.BlueGrow1Block;
import xyz.souldb.foodplusplus.FoodplusplusMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
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
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FoodplusplusMod.LOGGER.warn("Failed to load dependency world for procedure FppDebug!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("[Food++ Debug]"), (true));
		}
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
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("[Food++ Debug]- Mod version: pre"), (true));
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 20);
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
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(
							new StringTextComponent((("[Food++ Debug]- gamedir: ") + "" + (Minecraft.getInstance().gameDir))), (true));
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 20);
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
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("[Food++ Debug]- Game versions: 1.16.4/5, 1.17 coming soon"),
							(true));
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 20);
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
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(
									new StringTextComponent((("[Food++ Debug]- Item names: ") + ""
											+ ((((new ItemStack(BlueberriesItem.block).getDisplayName().getString())) + ""
													+ ((((new ItemStack(BlueberryPlantBlock.block).getDisplayName().getString())) + ""
															+ ((((new ItemStack(BlueGrow3Block.block).getDisplayName().getString())) + ""
																	+ ((((new ItemStack(BlueGrow2Block.block).getDisplayName().getString())) + ""
																			+ (((null) + ""
																					+ ((((new ItemStack(BlueGrow1Block.block).getDisplayName()
																							.getString()))
																							+ ""
																							+ ((new ItemStack(BlueberrySeedsItem.block)
																									.getDisplayName().getString())))))))))))))))),
									(true));
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 20);
	}
}
