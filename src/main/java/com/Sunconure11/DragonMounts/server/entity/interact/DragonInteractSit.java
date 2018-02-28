/*
** 2016 April 24
**
** The author disclaims copyright to this source code. In place of
** a legal notice, here is a blessing:
**    May you do good and not evil.
**    May you find forgiveness for yourself and forgive others.
**    May you share freely, never taking more than you give.
 */
package com.Sunconure11.DragonMounts.server.entity.interact;

import com.Sunconure11.DragonMounts.server.entity.EntityTameableDragon;
import com.Sunconure11.DragonMounts.server.util.ItemUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 * @Modifier James Miller <TheRPGAdventurer.>
 */
public class DragonInteractSit extends DragonInteract {

	public DragonInteractSit(EntityTameableDragon dragon) {
		super(dragon);
	}

	@Override
	public boolean interact(EntityPlayer player, ItemStack item) {
		if (dragon.isServer() && dragon.isTamed() &&
				ItemUtils.hasEquipped(player, Items.STICK)) {
			dragon.getAISit().setSitting(!dragon.isSitting());
			dragon.getNavigator().clearPath();
			return true;
		}

		return false;
	}

}
