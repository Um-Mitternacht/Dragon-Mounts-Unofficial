package com.TheRPGAdventurer.server.cmd;

import net.minecraft.command.CommandBase;

public abstract class CommandBaseDragon extends CommandBase implements IDragonModifier  {
    
    private final String name;

    public CommandBaseDragon(String name) {
        this.name = name;
    }
    
    @Override
    public String getCommandName() {
        return name;
    }
}
