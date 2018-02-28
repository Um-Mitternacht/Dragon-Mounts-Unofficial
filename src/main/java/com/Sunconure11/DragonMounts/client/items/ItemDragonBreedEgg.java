package com.Sunconure11.DragonMounts.client.items;


import com.Sunconure11.DragonMounts.client.blocks.BlockDragonBreedEgg;
import com.Sunconure11.DragonMounts.server.entity.breeds.EnumDragonBreed;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class ItemDragonBreedEgg extends ItemBlock {

	public static ItemDragonBreedEgg DRAGON_BREED_EGG;
	public static final Item[] ITEM_EGG = {
			DRAGON_BREED_EGG = new ItemDragonBreedEgg()
	};

	public ItemDragonBreedEgg() {
		super(BlockDragonBreedEgg.DRAGON_BREED_EGG);
		setMaxDamage(0);
		setRegistryName("dragon_egg");
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int metadata) {
		return metadata;
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		EnumDragonBreed type = EnumDragonBreed.META_MAPPING.inverse().get(stack.getMetadata());
		String breedName = I18n.translateToLocal("entity.DragonMounts.RealmOfTheDragon." + type.getName() + ".name");
		return I18n.translateToLocalFormatted("item.dragonEgg.name", breedName);
	}
}
