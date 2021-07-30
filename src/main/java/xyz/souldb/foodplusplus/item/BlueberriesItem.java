
package xyz.souldb.foodplusplus.item;

import xyz.souldb.foodplusplus.FoodplusplusModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

@FoodplusplusModElements.ModElement.Tag
public class BlueberriesItem extends FoodplusplusModElements.ModElement {
	@ObjectHolder("foodplusplus:blueberries")
	public static final Item block = null;
	public BlueberriesItem(FoodplusplusModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(6).saturation(0.5f).build()));
			setRegistryName("blueberries");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 24;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
