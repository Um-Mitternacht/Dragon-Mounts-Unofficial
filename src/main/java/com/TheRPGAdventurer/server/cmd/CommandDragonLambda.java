package com.TheRPGAdventurer.server.cmd;

import java.util.Optional;
import java.util.function.Consumer;
import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandDragonLambda extends CommandBaseDragon {
    
    private final Optional<Consumer<EntityTameableDragon>> consumer;
    private final Optional<ICommandProcessor> processor;

    public CommandDragonLambda(String name, Consumer<EntityTameableDragon> consumer) {
        super(name);
        this.consumer = Optional.of(consumer);
        this.processor = Optional.empty();
    }
    
    public CommandDragonLambda(String name, ICommandProcessor processor) {
        super(name);
        this.consumer = Optional.empty();
        this.processor = Optional.of(processor);
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (processor.isPresent()) {
            processor.get().execute(server, sender, args);
        }
        
        if (consumer.isPresent()) {
            applyModifier(server, sender, consumer.get());
        }
    }
    
}
