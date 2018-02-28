/*
 ** 2014 January 31
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */

package com.Sunconure11.DragonMounts.server.handler;

import com.Sunconure11.DragonMounts.server.entity.breeds.EnumDragonBreed;
import com.Sunconure11.DragonMounts.server.entity.helper.EnumDragonLifeStage;
import com.Sunconure11.DragonMounts.DragonMounts;
import com.Sunconure11.DragonMounts.client.blocks.BlockDragonBreedEgg;
import com.Sunconure11.DragonMounts.server.entity.EntityTameableDragon;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Non-invasive dragon egg block override handler.
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class DragonEggBlockHandler {

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent evt) {
		// only handle right clicks on blocks
		// TODO: port for 1.9
//        if (evt.action != PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
//            return;
//        }

		BlockPos pos = evt.getPos();
		World world = evt.getWorld();
		IBlockState state = world.getBlockState(pos);
		Block block = world.getBlockState(pos).getBlock();

		// don't interact with vanilla egg blocks if configured
		if (DragonMounts.instance.getConfig().isDisableBlockOverride() &&
				block == Blocks.DRAGON_EGG) {
			return;
		}

		// ignore non-egg blocks
		if (block != Blocks.DRAGON_EGG && block != BlockDragonBreedEgg.DRAGON_BREED_EGG) {
			return;
		}

		// deny action
		evt.setResult(Event.Result.DENY);

		// clear dragon egg block
		world.setBlockToAir(pos);

		// create dragon egg entity on server
		if (!world.isRemote) { // this was inverted, i.e. evt.world.isRemote, but it should surely be this way
			EntityTameableDragon dragon = new EntityTameableDragon(world);
			dragon.setPosition(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
			dragon.getReproductionHelper().setBreeder(evt.getEntityPlayer());
			dragon.getLifeStageHelper().setLifeStage(EnumDragonLifeStage.EGG);

			// set breed type (custom dragon egg only, otherwise use default breed)
			if (block == BlockDragonBreedEgg.DRAGON_BREED_EGG) {
				EnumDragonBreed breed = state.getValue(BlockDragonBreedEgg.BREED);
				dragon.getBreedHelper().setBreedType(breed);
			}

			world.spawnEntity(dragon);
		}
	}
}
