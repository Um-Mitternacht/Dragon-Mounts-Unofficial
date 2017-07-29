package com.TheRPGAdventurer.server.cmd;

import java.util.function.BiConsumer;

import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.server.entity.breeds.EnumDragonBreed;
import com.TheRPGAdventurer.server.entity.helper.EnumDragonLifeStage;
import com.TheRPGAdventurer.RealmOfTheDragons;
import net.minecraft.command.ICommandSender;

public class CommandDragon extends CommandBaseNested implements IDragonModifier {
    
    public CommandDragon() {
        BiConsumer<EntityTameableDragon, EnumDragonBreed> breedConsumer =
            (dragon, enumValue) -> dragon.setBreedType(enumValue);
        addCommand(new CommandDragonEnumSetter("breed", EnumDragonBreed.class, breedConsumer));
        
        BiConsumer<EntityTameableDragon, EnumDragonLifeStage> lifeStageConsumer =
            (dragon, enumValue) -> dragon.getLifeStageHelper().setLifeStage(enumValue);
        addCommand(new CommandDragonEnumSetter("stage", EnumDragonLifeStage.class, lifeStageConsumer));
        
        addCommand(new CommandDragonTame());

        if (RealmOfTheDragons.instance.getConfig().isDebug()) {
            addCommand(new CommandDragonDebug());
        }
    }

    @Override
    public String getCommandName() {
        return "dragon";
    }
    
    @Override
    public String getCommandUsage(ICommandSender sender) {
        return String.format("/%s [global]", super.getCommandUsage(sender));
    }
    
    /**
     * Return the required permission level for this command.
     */
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
}
