package com.TheRPGAdventurer.server.cmd;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

@FunctionalInterface
public interface ICommandProcessor {
    
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException;
}
