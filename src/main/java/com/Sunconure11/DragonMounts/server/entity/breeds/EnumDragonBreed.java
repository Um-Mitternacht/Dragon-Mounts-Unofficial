package com.Sunconure11.DragonMounts.server.entity.breeds;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public enum EnumDragonBreed implements IStringSerializable {

	AMETHYST(0, DragonBreedAmethyst::new),
	RUBY(1, DragonBreedRuby::new),
	JADE(2, DragonBreedJade::new),
	SAPPHIRE(3, DragonBreedSapphire::new),
	GARNET(4, DragonBreedGarnet::new),
	END(5, DragonBreedEnd::new),
	NETHER(6, DragonBreedNether::new);


	// create static bimap between enums and meta data for faster and easier
	// lookups
	public static final BiMap<EnumDragonBreed, Integer> META_MAPPING =
			ImmutableBiMap.copyOf(Arrays.asList(values()).stream()
					.collect(Collectors.toMap(Function.identity(), EnumDragonBreed::getMeta)));
	public static final PropertyEnum<EnumDragonBreed> BREED = PropertyEnum.create("breed", EnumDragonBreed.class);
	private final DragonBreed breed;

	// this field is used for block metadata and is technically the same as
	// ordinal(), but it is saved separately to make sure the values stay
	// constant after adding more breeds in unexpected orders
	private final int meta;

	private EnumDragonBreed(int meta, Supplier<DragonBreed> factory) {
		this.breed = factory.get();
		this.meta = meta;
	}


	public DragonBreed getBreed() {
		return breed;
	}

	public int getMeta() {
		return meta;
	}

	@Override
	public String getName() {
		return name().toLowerCase();
	}

}

