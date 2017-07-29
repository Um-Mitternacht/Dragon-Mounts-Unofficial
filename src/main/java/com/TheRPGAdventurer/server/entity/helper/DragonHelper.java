package com.TheRPGAdventurer.server.entity.helper;

import java.util.Random;

import com.TheRPGAdventurer.server.entity.EntityTameableDragon;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.EntityDataManager;

public abstract class DragonHelper {

    protected final EntityTameableDragon dragon;
    protected final EntityDataManager dataWatcher;
    protected final Random rand;

    public DragonHelper(EntityTameableDragon dragon) {
        this.dragon = dragon;
        this.dataWatcher = dragon.getDataManager();
        this.rand = dragon.getRNG();
    }
    
    public void writeToNBT(NBTTagCompound nbt) {}
    public void readFromNBT(NBTTagCompound nbt) {}
    public void applyEntityAttributes() {}
    public void onLivingUpdate() {}
    public void onDeathUpdate() {}
    public void onDeath() {}
}
