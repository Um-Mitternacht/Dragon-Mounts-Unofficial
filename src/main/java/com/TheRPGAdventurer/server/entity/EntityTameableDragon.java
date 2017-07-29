package com.TheRPGAdventurer.server.entity;

import static net.minecraft.entity.SharedMonsterAttributes.ATTACK_DAMAGE;
import static net.minecraft.entity.SharedMonsterAttributes.FOLLOW_RANGE;
import static net.minecraft.entity.SharedMonsterAttributes.MOVEMENT_SPEED;

import java.util.BitSet;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.TheRPGAdventurer.RealmOfTheDragonsLootTables;
import com.TheRPGAdventurer.client.blocks.BlockDragonBreedEgg;
import com.TheRPGAdventurer.client.init.ModItems;
import com.TheRPGAdventurer.client.init.ModTools;
import com.TheRPGAdventurer.client.model.DragonModel;
import com.TheRPGAdventurer.client.model.anim.DragonAnimator;
import com.TheRPGAdventurer.server.entity.ai.path.PathNavigateFlying;
import com.TheRPGAdventurer.server.entity.breeds.DragonBreed;
import com.TheRPGAdventurer.server.entity.breeds.EnumDragonBreed;
import com.TheRPGAdventurer.server.entity.helper.DragonBodyHelper;
import com.TheRPGAdventurer.server.entity.helper.DragonBrain;
import com.TheRPGAdventurer.server.entity.helper.DragonBreedHelper;
import com.TheRPGAdventurer.server.entity.helper.DragonHelper;
import com.TheRPGAdventurer.server.entity.helper.DragonInteractHelper;
import com.TheRPGAdventurer.server.entity.helper.DragonLifeStageHelper;
import com.TheRPGAdventurer.server.entity.helper.DragonMoveHelper;
import com.TheRPGAdventurer.server.entity.helper.DragonParticleHelper;
import com.TheRPGAdventurer.server.entity.helper.DragonReproductionHelper;
import com.TheRPGAdventurer.server.entity.helper.DragonSoundManager;
import com.TheRPGAdventurer.server.entity.helper.EnumDragonLifeStage;
import com.TheRPGAdventurer.server.util.ItemUtils;
import com.google.common.base.Optional;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.SkeletonType;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeHills;
import net.minecraft.world.biome.BiomeSnow;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Main Dragon Class.
 */
public class EntityTameableDragon extends EntityTameable implements IShearable {
    
    private static final Logger L = LogManager.getLogger();
    
    
    public static final IAttribute MOVEMENT_SPEED_AIR = new RangedAttribute(null,
        "generic.movementSpeedAir", 1.5, 0.0, Double.MAX_VALUE)
            .setDescription("Movement Speed Air")
            .setShouldWatch(true);
   
    // base attributes
    public static final double BASE_SPEED_GROUND = 0.3;
    public static final double BASE_ARMOR = 10.0D;
    public static final double BASE_SPEED_AIR = 0.4;
    public static final double BASE_DAMAGE = 10; 
    public static final double BASE_HEALTH = 60;
    public static final double BASE_RESISTANCE = 10; 
    public static final float BASE_WIDTH = 2.5f;
    public static final float BASE_HEIGHT = 2.5f;
    public static final double BASE_FOLLOW_RANGE = 26;
    public static final double BASE_FOLLOW_RANGE_FLYING = BASE_FOLLOW_RANGE * 2;
    public static final int HOME_RADIUS = 64;
    public static final double ALTITUDE_FLYING_THRESHOLD = 2;
    
    // data value IDs
    private static final DataParameter<Boolean> DATA_FLYING =
            EntityDataManager.<Boolean>createKey(EntityTameableDragon.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> DATA_SADDLED =
            EntityDataManager.<Boolean>createKey(EntityTameableDragon.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Optional<UUID>> DATA_BREEDER =
            EntityDataManager.<Optional<UUID>>createKey(EntityTameableDragon.class, DataSerializers.OPTIONAL_UNIQUE_ID);
    private static final DataParameter<String> DATA_BREED = 
    		EntityDataManager.<String>createKey(EntityTameableDragon.class, DataSerializers.STRING);
    private static final DataParameter<Integer> DATA_REPRO_COUNT =
            EntityDataManager.<Integer>createKey(EntityTameableDragon.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> DATA_TICKS_SINCE_CREATION =
            EntityDataManager.<Integer>createKey(EntityTameableDragon.class, DataSerializers.VARINT);
    public static final DataParameter<Byte> SHEAR = 
    		EntityDataManager.<Byte>createKey(EntityTameableDragon.class, DataSerializers.BYTE);
    
    // data NBT IDs
    private static final String NBT_SADDLED = "Saddle";

    private static String NBT_FLYING = "Flying";
    private static String NBT_CAN_FLY = "CanFly";
    
    private boolean boosting;
    private int boostTime;
    private int totalBoostTime;
    
    private double airSpeedHorizonal = 1.5;
    private double airSpeedVertical = 0;
    private float yawAdd;
    private int yawSpeed = 30;
    private int inAirTicks;
    public Random rand;
    private DragonModel model;
    
    // server/client delegates
    private final Map<Class, DragonHelper> helpers = new HashMap<>();
    
    // client-only delegates
    private final DragonBodyHelper bodyHelper = new DragonBodyHelper(this);
    
    // server-only flags
    private BitSet controlFlags;
    
    private DragonAnimator animator;
    
    public EntityTameableDragon(World world) {
        super(world);
        
        // set hitbox size
        setSize(BASE_WIDTH, BASE_HEIGHT);
        
        // enables walking over blocks
        stepHeight = 1;
        
        // create entity delegates
        addHelper(new DragonBreedHelper(this, DATA_BREED));
        addHelper(new DragonLifeStageHelper(this, DATA_TICKS_SINCE_CREATION));
        addHelper(new DragonReproductionHelper(this, DATA_BREEDER, DATA_REPRO_COUNT));
        addHelper(new DragonSoundManager(this));
        addHelper(new DragonInteractHelper(this));
        
        if (isClient()) {
            addHelper(new DragonParticleHelper(this));
            addHelper(new DragonAnimator(this));
        } else {
            addHelper(new DragonBrain(this));
        }
        
        moveHelper = new DragonMoveHelper(this);
        aiSit = new EntityAISit(this);
        
        // init helpers
        helpers.values().forEach(DragonHelper::applyEntityAttributes);
    }
    
    @Override
    protected float updateDistance(float p_110146_1_, float p_110146_2_) {
        // required to fixate body while sitting. also slows down rotation while
        // standing.
        bodyHelper.updateRenderAngles();
        return p_110146_2_;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
       
        dataManager.register(DATA_FLYING, false);
        dataManager.register(DATA_SADDLED, false);
        dataManager.register(SHEAR, Byte.valueOf((byte)0));
        
        animator = new DragonAnimator(this);
    }    

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
               
        getAttributeMap().registerAttribute(ATTACK_DAMAGE);
        getAttributeMap().registerAttribute(MOVEMENT_SPEED_AIR);
        getEntityAttribute(MOVEMENT_SPEED).setBaseValue(BASE_SPEED_GROUND);
        getEntityAttribute(MOVEMENT_SPEED_AIR).setBaseValue(BASE_SPEED_AIR);
        getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(BASE_ARMOR);        
        getEntityAttribute(ATTACK_DAMAGE).setBaseValue(BASE_DAMAGE);
        getEntityAttribute(FOLLOW_RANGE).setBaseValue(BASE_FOLLOW_RANGE);
        getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(BASE_RESISTANCE);
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(BASE_HEALTH);

    }
     
    /**
     * Returns the entity's health relative to the maximum health.
     * 
     * @return health normalized between 0 and 1
     */
    public double getHealthRelative() {
        return getHealth() / (double) getMaxHealth();
    }

    /**
     * Returns true if the dragon is saddled.
     */
    public boolean isSaddled() {
        return dataManager.get(DATA_SADDLED);
    }

    /**
     * Set or remove the saddle of the dragon.
     */
    public void setSaddled(boolean saddled) {
        L.trace("setSaddled({})", saddled);
        dataManager.set(DATA_SADDLED, saddled);
    }
        
    public boolean canFly() {
        // eggs and hatchlings can't fly
        return !isEgg() && !isHatchling();
    }
    
    /**
     * Returns true if the entity is flying.
     */
    public boolean isFlying() {
        return dataManager.get(DATA_FLYING);
    }
    
    /**
     * Set the flying flag of the entity.
     */
    public void setFlying(boolean flying) {
        L.trace("setFlying({})", flying);
        dataManager.set(DATA_FLYING, flying);
    }
    
    /**
     * Returns the distance to the ground while the entity is flying.
     */
    public double getAltitude() {
        BlockPos groundPos = worldObj.getHeight(getPosition());
        return posY - groundPos.getY();
    
    }
    
    
    /**
     * Causes this entity to lift off if it can fly.
     */
    public void liftOff() {
        L.trace("liftOff");
        if (canFly()) {
            jump();
        }
    }
  
    @Override
    protected float getJumpUpwardsMotion() {
        // stronger jumps for easier lift-offs
        return canFly() ? 1 : super.getJumpUpwardsMotion();
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    @Override
    public void fall(float distance, float damageMultiplier) {
        // ignore fall damage if the entity can fly
        if (!canFly()) {
            super.fall(distance, damageMultiplier);
        }
    }
    
     /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        nbt.setBoolean(NBT_SADDLED, isSaddled());
        
        helpers.values().forEach(helper -> helper.writeToNBT(nbt));
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        setSaddled(nbt.getBoolean(NBT_SADDLED));
        
        helpers.values().forEach(helper -> helper.readFromNBT(nbt));
    }
    
    @Override
    public void onLivingUpdate() {
        helpers.values().forEach(DragonHelper::onLivingUpdate);
        
        if (isServer()) {
            // set home position near owner when tamed
            if (isTamed()) {
                Entity owner = getOwner();
                if (owner != null) {
                    setHomePosAndDistance(owner.getPosition(), HOME_RADIUS);
                }
            }
            
            if (this.getHealth() < this.getMaxHealth() && this.ticksExisted % 77 == 0) {
                this.heal(1.0F);
            }

            // update flying state based on the distance to the ground
            boolean flying = canFly() && getAltitude() > ALTITUDE_FLYING_THRESHOLD;
            if (flying != isFlying()) {
                // notify client
                setFlying(flying);
                
                // clear tasks (needs to be done before switching the navigator!)
                getBrain().clearTasks();
                
                // update AI follow range (needs to be updated before creating 
                // new PathNavigate!)
                getEntityAttribute(FOLLOW_RANGE).setBaseValue(
                        flying ? BASE_FOLLOW_RANGE_FLYING : BASE_FOLLOW_RANGE);
                
                // update pathfinding method
                if (flying) {
                    navigator = new PathNavigateFlying(this, worldObj);
                } else {
                    navigator = new PathNavigateGround(this, worldObj);
                }
                
                // tasks need to be updated after switching modes
                getBrain().updateAITasks();
            }
            
        }
        
        super.onLivingUpdate();
    }
    
    /**
     * returns the pitch of the dragon's body
     *
     * @return
     */
    public float getModelPitch() {
        return animator.getModelPitch();
    }
    
    @Override
    public void moveEntityWithHeading(float strafe, float forward) {
        // disable method while flying, the movement is done entirely by
        // moveEntity() and this one just makes the dragon to fall slowly when
        // hovering
        if (!isFlying()) {
            super.moveEntityWithHeading(strafe, forward);
        }
    }
    
    /**
     * Handles entity death timer, experience orb and particle creation
     */
    @Override
    protected void onDeathUpdate() {
        helpers.values().forEach(DragonHelper::onDeathUpdate);
        
        // unmount any riding entities
        removePassengers();
                
        // freeze at place
        motionX = motionY = motionZ = 0;
        rotationYaw = prevRotationYaw;
        rotationYawHead = prevRotationYawHead;
        
        if (isEgg()) {
            setDead();
        } else {
            // actually delete entity after the time is up
            if (deathTime >= getMaxDeathTime()) {
                setDead();
            }
        }
        
        deathTime++;
    }
    
    @Override
    public void setDead() {
        helpers.values().forEach(DragonHelper::onDeath);
        super.setDead();
    }
    
    public boolean canBeLeashedTo(EntityPlayer player) {
        return true;
    }

    @Override
    public String getName() {
        // return custom name if set
        if (hasCustomName()) {
            return getCustomNameTag();
        }
        
        // return default breed name otherwise
        String entName = EntityList.getEntityString(this);
        String breedName = getBreedType().getName().toLowerCase();
        return I18n.translateToLocal("entity." + entName + "." + breedName + ".name");
    }
    
    /**
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    protected SoundEvent getAmbientSound() {
         return getSoundManager().getLivingSound();
    }
    
    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected SoundEvent getHurtSound() {
        return getSoundManager().getHurtSound();
    }
    
    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected SoundEvent getDeathSound() {
        return getSoundManager().getDeathSound();
    }
    
    /**
     * Plays living's sound at its position
     */
    @Override
    public void playLivingSound() {
        getSoundManager().playLivingSound();
    }
    
    @Override
    public void playSound(SoundEvent soundIn, float volume, float pitch) {
        getSoundManager().playSound(soundIn, volume, pitch);
    }
    
    /**
     * Plays step sound at given x, y, z for the entity
     */
    @Override
    protected void playStepSound(BlockPos entityPos, Block block) {
        getSoundManager().playStepSound(entityPos, block);
    }
    
    /**
     * Returns the volume for the sounds this mob makes.
     */
    @Override
    protected float getSoundVolume() {
        // note: unused, managed in playSound()
        return 1;
    }
    
    /**
     * Gets the pitch of living sounds in living entities.
     */
    @Override
    protected float getSoundPitch() {
        // note: unused, managed in playSound()
        return 1;
    }
    
    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    @Override
    public int getTalkInterval() {
        return getSoundManager().getTalkInterval();
    }
    
    /**
     * Get this Entity's EnumCreatureAttribute
     */
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return getBreed().getCreatureAttribute();
    }
    
    
    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand, ItemStack item) {
        // don't interact with eggs!
        if (isEgg()) {
            return false;
        }
        
        // inherited interaction
        if (super.processInteract(player, hand, item)) {
            return true;
        }
        
        return getInteractHelper().interact(player, item);
    }
    
    public void tamedFor(EntityPlayer player, boolean successful) {       
        if (successful) {
            setTamed(true);
            navigator.clearPathEntity();  // replacement for setPathToEntity(null);
            setAttackTarget(null);
            setOwnerId(player.getUniqueID());
            playTameEffect(true);
            worldObj.setEntityState(this, (byte) 7);
        } else {
            playTameEffect(false);
            worldObj.setEntityState(this, (byte) 6);
        }
    }
    
    public boolean isTamedFor(EntityPlayer player) {
        return isTamed() && isOwner(player);
    }    
    
    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    @Override
    public boolean isBreedingItem(ItemStack item) {
        return getBreed().getBreedingItem() == item.getItem();
    }
    
    /**
     * Returns the height of the eyes. Used for looking at other entities.
     */
    @Override
    public float getEyeHeight() {
        float eyeHeight = 0.90F;

        if (isSitting()) {
            eyeHeight *= 0.8f;
        }

        return eyeHeight;
    }
    
    /**
     * Returns the Y offset from the entity's position for any entity riding this one.
     */
    @Override
    public double getMountedYOffset() {
        return (isSitting() ? 1.7f : 2.4f) * getScale();
    }
    
    /**
     * Returns render size modifier
     */
    @Override
    public float getRenderSizeModifier() {
        return getScale();
    }
    
    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    @Override
    public boolean canBePushed() {
        return super.canBePushed() && isEgg();
    }
    
    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    @Override
    protected boolean canDespawn() {
        return false;
    }
    
    /**
     * returns true if this entity is by a ladder, false otherwise
     */
    @Override
    public boolean isOnLadder() {
        // this better doesn't happen...
        return false;
    }

    protected ResourceLocation getLootTable() {
    	
            switch (this.getBreedType()) {
            case JADE:
                return RealmOfTheDragonsLootTables.ENTITIES_DRAGON_JADE;
            case GARNET:
                return RealmOfTheDragonsLootTables.ENTITIES_DRAGON_GARNET;
            case RUBY:
                return RealmOfTheDragonsLootTables.ENTITIES_DRAGON_RUBY;
            case SAPPHIRE:
                return RealmOfTheDragonsLootTables.ENTITIES_DRAGON_SAPPHIRE;
            case AMETHYST:
                return RealmOfTheDragonsLootTables.ENTITIES_DRAGON_AMETHYST;
			default:
				break;
            
            }
            
		return null;
			
    }       

	public boolean attackEntityAsMob(Entity entityIn) {
        boolean attacked = entityIn.attackEntityFrom(
            DamageSource.causeMobDamage(this),
            (float) getEntityAttribute(ATTACK_DAMAGE).getAttributeValue()
        );

        if (attacked) {
            applyEnchantments(this, entityIn);
        }
        
        return attacked;
    }
    
    @Override
    public void swingArm(EnumHand hand) {
        // play eating sound
        playSound(getSoundManager().getAttackSound(), 1, 0.7f);

        // play attack animation
        if (worldObj instanceof WorldServer) {
            ((WorldServer) worldObj).getEntityTracker().sendToAllTrackingEntity(
                    this, new SPacketAnimation(this, 0));
        }
    }
    
    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource src, float par2) {
        if (isInvulnerableTo(src)) {
            return false;
        }
        
        // don't just sit there!
        aiSit.setSitting(false);
        
        return super.attackEntityFrom(src, par2);
    }
    
    /**
     * Return whether this entity should be rendered as on fire.
     */
    @Override
    public boolean canRenderOnFire() {
        return super.canRenderOnFire() && !getBreed().isImmuneToDamage(DamageSource.inFire);
    }
    
    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    @Override
    public boolean canMateWith(EntityAnimal mate) {
        return getReproductionHelper().canMateWith(mate);
    }
    
    /**
     * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
     */
    @Override
    public EntityAgeable createChild(EntityAgeable mate) {
        return getReproductionHelper().createChild(mate);
    }
            
    private void addHelper(DragonHelper helper) {
        L.trace("addHelper({})", helper.getClass().getName());
        helpers.put(helper.getClass(), helper);
    }
    
    private <T extends DragonHelper> T getHelper(Class<T> clazz) {
        return (T) helpers.get(clazz);
    }

    public DragonBreedHelper getBreedHelper() {
        return getHelper(DragonBreedHelper.class);
    }
    
    public DragonLifeStageHelper getLifeStageHelper() {
        return getHelper(DragonLifeStageHelper.class);
    }
    
    public EnumDragonLifeStage getDragonLifeStage() {
    	return getLifeStageHelper().getLifeStage();
    }
    
    public DragonReproductionHelper getReproductionHelper() {
        return getHelper(DragonReproductionHelper.class);
    }
    
    public void setControlFlags(BitSet flags) {
        BitSet controlFlags = flags;
    }
    
    public BitSet getControlFlags() {
        return controlFlags;
    }
    
    @Override
    public void updatePassenger(Entity passenger) {
    	  if (this.isPassenger(passenger)) {
          double px = posX;
          double py = posY + getMountedYOffset() + passenger.getYOffset();
          double pz = posZ;
          
          // dragon position is the middle of the model and the saddle is on
          // the shoulders, so move player forwards on Z axis relative to the
          // dragon's rotation to fix that
          Vec3d pos = new Vec3d(0, 0, 0.8 * getScale());
          pos = pos.rotateYaw((float) Math.toRadians(-renderYawOffset)); // oops
          px += pos.xCoord;
          py += pos.yCoord;
          pz += pos.zCoord;
                  
          passenger.setPosition(px, py, pz);
          
          // fix rider rotation
          if (passenger instanceof EntityLiving) {
              EntityLiving rider = ((EntityLiving) passenger);
              rider.prevRotationPitch = rider.rotationPitch;
              rider.prevRotationYaw = rider.rotationYaw;
              rider.renderYawOffset = renderYawOffset;
          }
       }
    }
        
    public DragonParticleHelper getParticleHelper() {
        return getHelper(DragonParticleHelper.class);
    }
    
    public DragonAnimator getAnimator() {
        return getHelper(DragonAnimator.class);
    }
    
    public DragonSoundManager getSoundManager() {
        return getHelper(DragonSoundManager.class);
    }
    
    public DragonBrain getBrain() {
        return getHelper(DragonBrain.class);
    }
    
    public DragonInteractHelper getInteractHelper() {
        return getHelper(DragonInteractHelper.class);

    }
    
    /**
     * Returns the breed for this dragon.
     * 
     * @return breed
     */
    public EnumDragonBreed getBreedType() {
        return getBreedHelper().getBreedType();
    }
    
    /**
     * Sets the new breed for this dragon.
     * 
     * @param type new breed
     */
    public void setBreedType(EnumDragonBreed type) {
        getBreedHelper().setBreedType(type);
    }
    
    public DragonBreed getBreed() {
        return getBreedType().getBreed();
    }
    
    
    /**
     * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
     * Pigs, Horses, and Boats are generally "steered" by the controlling passenger.
     */
    @Override
    public Entity getControllingPassenger() {
        List<Entity> list = getPassengers();
        return list.isEmpty() ? null : list.get(0);
    }
    
    @Override
    public boolean canPassengerSteer() {
        // must always return false or the vanilla movement code interferes
        // with DragonMoveHelper
        return false;
    }

    public EntityPlayer getRidingPlayer() {
        Entity entity = getControllingPassenger();
        if (entity instanceof EntityPlayer) {
            return (EntityPlayer) entity;
        } else {
            return null;
        }
    }
    
    public void setRidingPlayer(EntityPlayer player) {
        L.trace("setRidingPlayer({})", player.getName());
        player.rotationYaw = rotationYaw;
        player.rotationPitch = rotationPitch;
        player.startRiding(this);
    }

    public boolean isInvulnerableTo(DamageSource src) {
        Entity srcEnt = src.getEntity();
        if (srcEnt != null) {
            // ignore own damage
            if (srcEnt == this) {
                return true;
            }
            
            // ignore damage from riders
            if (isPassenger(srcEnt)) {
                return true;
            }
        }
        
        // don't drown as egg
        if (src.damageType.equals("drown") && isEgg()) {
            return true;
        }
        
        return getBreed().isImmuneToDamage(src);
    }
    
    public int getDeathTime() {
        return deathTime;
    }
    
    public int getMaxDeathTime() {
        return 120;
    }
    
    public void setImmuneToFire(boolean isImmuneToFire) {
        L.trace("setImmuneToFire({})", isImmuneToFire);
        this.isImmuneToFire = isImmuneToFire;
    }
    
    public void setAttackDamage(double damage) {
        L.trace("setAttackDamage({})", damage);
        getEntityAttribute(ATTACK_DAMAGE).setBaseValue(damage);
    }
    
    /**
     * Public wrapper for protected final setScale(), used by DragonLifeStageHelper.
     * 
     * @param scale 
     */
    public void setScalePublic(float scale) {
        double posXTmp = posX;
        double posYTmp = posY;
        double posZTmp = posZ;
        boolean onGroundTmp = onGround;
        
        setScale(scale);
        
        // workaround for a vanilla bug; the position is apparently not set correcty
        // after changing the entity size, causing asynchronous server/client positioning
        setPosition(posXTmp, posYTmp, posZTmp);
        
        // otherwise, setScale stops the dragon from landing while it is growing
        onGround = onGroundTmp;
    }
    
    /**
     * The age value may be negative or positive or zero. If it's negative, it get's incremented on each tick, if it's
     * positive, it get's decremented each tick. Don't confuse this with EntityLiving.getAge. With a negative value the
     * Entity is considered a child.
     */
    @Override
    public int getGrowingAge() {
        // adapter for vanilla code to enable breeding interaction
        return isAdult() ? 0 : -1;
    }
    
    /**
     * The age value may be negative or positive or zero. If it's negative, it get's incremented on each tick, if it's
     * positive, it get's decremented each tick. With a negative value the Entity is considered a child.
     */
    @Override
    public void setGrowingAge(int age) {
        // managed by DragonLifeStageHelper, so this is a no-op
    }
    
    /**
     * Sets the scale for an ageable entity according to the boolean parameter, which says if it's a child.
     */
    @Override
    public void setScaleForAge(boolean p_98054_1_) {
        // managed by DragonLifeStageHelper, so this is a no-op
    }
    
    /**
     * Returns the size multiplier for the current age.
     *
     * 
     * @return scale
     */
    public float getScale() {
        return getLifeStageHelper().getScale();
    }
    
    public boolean isEgg() {
        return getLifeStageHelper().isEgg();
    }
    
    public boolean isHatchling() {
        return getLifeStageHelper().isHatchling();
    }
    
    public boolean isJuvenile() {
        return getLifeStageHelper().isJuvenile();
    }
    
    public boolean isAdult() {
        return getLifeStageHelper().isAdult();
    }
    
    @Override
    public boolean isChild() {
        return !isAdult();
        
    }
    
    /**
     * Checks if this entity is running on a client.
     * 
     * Required since MCP's isClientWorld returns the exact opposite...
     * 
     * @return true if the entity runs on a client or false if it runs on a server
     */
    public final boolean isClient() {
        return worldObj.isRemote;
    }
    
    /**
     * Checks if this entity is running on a server.
     * 
     * @return true if the entity runs on a server or false if it runs on a client
     */
    public final boolean isServer() {
        return !worldObj.isRemote;
    }
    
    protected Item getShearDropItem() {
    	
        switch (this.getBreedType()) {
        case JADE:
            return ModItems.JadeDragonScales;
        case GARNET:
            return ModItems.GarnetDragonScales;
        case RUBY:
            return ModItems.RubyDragonScales;
        case SAPPHIRE:
            return ModItems.SapphireDragonScales;
        case AMETHYST:
            return ModItems.AmethystDragonScales;
        default: // no defaults!
        	return null;
        
        }
	}

    @Override 
    public boolean isShearable(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos) {
    	return (item != null && item.getItem() == ModTools.diamond_shears && !this.isChild());
         
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {

        java.util.List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
            ret.add(new ItemStack(this.getShearDropItem()));
        
        this.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, 1.0F, 1.0F);
        return ret;
    }
    
    
}        