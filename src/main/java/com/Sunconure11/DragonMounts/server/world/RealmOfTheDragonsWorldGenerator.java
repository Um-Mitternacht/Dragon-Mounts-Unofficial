package com.Sunconure11.DragonMounts.server.world;

import com.Sunconure11.DragonMounts.util.Utils;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;


public class RealmOfTheDragonsWorldGenerator implements IWorldGenerator {
	//@formatter:off

	StructureDragonNests dragonNest = new StructureDragonNests();
	StructureDragonNestNether dragonNestNether = new StructureDragonNestNether();

	//@formatter:on
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, net.minecraft.world.gen.IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimension()) {
			case -1: //Nether
				this.generateNestAtNether(world, random, chunkX, chunkZ);
				break;
			case 0: //OverWorld (Earth)
				this.generateNestAtSurface(world, random, chunkX, chunkZ);
				this.generateNestUnderground(world, random, chunkX, chunkZ);
				break;
			case 1: //End
				break;
		}
	}


	public void generateNestAtSurface(World world, Random random, int chunkX, int chunkZ) {
		int x = chunkX * 16 + random.nextInt(16);
		int z = chunkZ * 16 + random.nextInt(16);
		int xy = x >> 4;
		int zy = z >> 4;
		int height = world.getChunkFromChunkCoords(xy, zy).getHeight(new BlockPos(x & 15, 0, z & 15));
		int y = height - 1;

		if (world.getBiomeForCoordsBody(new BlockPos(x, y, z)).getBiomeClass().equals(BiomeHills.class)
				|| world.getBiomeForCoordsBody(new BlockPos(x, y, z)).getBiomeClass().equals(BiomeStoneBeach.class)) {
			if ((random.nextInt(120) + 1) <= 1) {
				boolean place = true;

				for (int Y = 0; Y < 3; Y++) {
					for (int Z = 0; Z < 7; Z++) {
						for (int X = 0; X < 7; X++) {
							if (world.getBlockState(new BlockPos(X + x, Y + y + 1, Z + z)).getBlock() != Blocks.AIR) {
								place = false;
							}
						}
					}
				}

				if (place) {
					dragonNest.generate(world, new BlockPos(x, y, z), random);
				}
			}
		}
	}

	public void generateNestUnderground(World world, Random random, int chunkX, int chunkZ) {
		int x = chunkX * 16 + random.nextInt(16);
		int z = chunkZ * 16 + random.nextInt(16);
		int xy = x >> 4;
		int zy = z >> 4;
		int y = random.nextInt(64);

		if (world.getBiomeForCoordsBody(new BlockPos(x, y, z)).getBiomeClass().equals(BiomePlains.class)
				|| world.getBiomeForCoordsBody(new BlockPos(x, y, z)).getBiomeClass().equals(BiomeDesert.class)
				|| world.getBiomeForCoordsBody(new BlockPos(x, y, z)).getBiomeClass().equals(BiomeForest.class)
				|| world.getBiomeForCoordsBody(new BlockPos(x, y, z)).getBiomeClass().equals(BiomeJungle.class)
				|| world.getBiomeForCoordsBody(new BlockPos(x, y, z)).getBiomeClass().equals(BiomeRiver.class)
				|| world.getBiomeForCoordsBody(new BlockPos(x, y, z)).getBiomeClass().equals(BiomeMesa.class)
				|| world.getBiomeForCoordsBody(new BlockPos(x, y, z)).getBiomeClass().equals(BiomeSwamp.class)) {
			if ((random.nextInt(120) + 1) <= 1) {
				boolean place = true;

				for (int Y = 0; Y < 1; Y++) {
					for (int Z = 0; Z < 1; Z++) {
						for (int X = 0; X < 1; X++) {
							if (world.getBlockState(new BlockPos(X + x, Y + y + 1, Z + z)).getBlock() != Blocks.AIR) {
								place = false;
							}
						}
					}
				}

				if (place) {
					dragonNest.generate(world, new BlockPos(x, y, z), random);
					Utils.getLogger().info("Nest here at: " + dragonNest.generate(world, new BlockPos(x, y, z), random));
				}
			}
		}
	}

	public void generateNestAtNether(World world, Random random, int chunkX, int chunkZ) {
		int x = chunkX * 16 + random.nextInt(16);
		int z = chunkZ * 16 + random.nextInt(16);
		int xy = x >> 4;
		int zy = z >> 4;
		int height = world.getChunkFromChunkCoords(xy, zy).getHeight(new BlockPos(x & 15, 0, z & 15));
		int y = height - 1;
		BlockPos pos = new BlockPos(chunkX, y, chunkZ);

		if (world.getBiomeForCoordsBody(new BlockPos(x, y, z)).getBiomeClass().equals(BiomeHell.class)) {
			if ((random.nextInt(120) + 1) <= 1) {
				boolean place = true;

				for (int Y = 0; Y < 3; Y++) {
					for (int Z = 0; Z < 7; Z++) {
						for (int X = 0; X < 7; X++) {
							if (world.getBlockState(new BlockPos(X + x, Y + y + 1, Z + z)).getBlock() != Blocks.AIR) {
								place = false;
							}
						}
					}
				}

				if (place = true) {
					dragonNestNether.generate(world, random, new BlockPos(x, y, z));
				}
			}
		}
	}

}