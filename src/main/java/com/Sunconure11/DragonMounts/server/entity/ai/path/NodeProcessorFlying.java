/*
** 2016 March 13
**
** The author disclaims copyright to this source code. In place of
** a legal notice, here is a blessing:
**    May you do good and not evil.
**    May you find forgiveness for yourself and forgive others.
**    May you share freely, never taking more than you give.
 */
package com.Sunconure11.DragonMounts.server.entity.ai.path;

import com.Sunconure11.DragonMounts.util.math.MathX;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.pathfinding.SwimNodeProcessor;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

/**
 * Based on SwimNodeProcessor but for air blocks.
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class NodeProcessorFlying extends SwimNodeProcessor {

	/**
	 * Returns PathPoint for given coordinates
	 */
	@Override
	public PathPoint getPathPointToCoords(double x, double y, double target) {
		return openPoint(
				MathX.floor_double(x - (entity.width / 2.0)),
				MathX.floor_double(y + 0.5),
				MathX.floor_double(target - (entity.width / 2.0))
		);
	}

	@Override
	public int findPathOptions(PathPoint[] pathOptions, PathPoint currentPoint, PathPoint targetPoint, float maxDistance) {
		int i = 0;

		for (EnumFacing facing : EnumFacing.values()) {
			PathPoint point = getSafePoint(entity,
					currentPoint.x + facing.getFrontOffsetX(),
					currentPoint.y + facing.getFrontOffsetY(),
					currentPoint.z + facing.getFrontOffsetZ()
			);

			if (point != null && !point.visited && point.distanceTo(targetPoint) < maxDistance) {
				pathOptions[i++] = point;
			}
		}

		return i;
	}

	/**
	 * Returns a point that the entity can safely move to
	 */
	private PathPoint getSafePoint(Entity entityIn, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);

		entitySizeX = MathX.floor_float(entityIn.width + 1);
		entitySizeY = MathX.floor_float(entityIn.height + 1);
		entitySizeZ = MathX.floor_float(entityIn.width + 1);

		for (int ix = 0; ix < entitySizeX; ++ix) {
			for (int iy = 0; iy < entitySizeY; ++iy) {
				for (int iz = 0; iz < entitySizeZ; ++iz) {
					IBlockState blockState = blockaccess.getBlockState(pos.add(ix, iy, iz));
					if (blockState.getMaterial() != Material.AIR) {
						return null;
					}
				}
			}
		}

		return openPoint(x, y, z);
	}
}
