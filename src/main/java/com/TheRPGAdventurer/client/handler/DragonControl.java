package com.TheRPGAdventurer.client.handler;

import java.util.BitSet;
import org.lwjgl.input.Keyboard;
import com.TheRPGAdventurer.server.network.DragonControlMessage;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

/**
 * Client side event handler for dragon control messages.
 */
public class DragonControl {
    
    public static final String KEY_CATEGORY = "key.categories.RealmOfTheDragon";
    public static final KeyBinding KEY_FLY_UP = new KeyBinding("key.dragon.flyUp", Keyboard.KEY_Z, KEY_CATEGORY);
    public static final KeyBinding KEY_FLY_DOWN = new KeyBinding("key.dragon.flyDown", Keyboard.KEY_X, KEY_CATEGORY);

    private final DragonControlMessage dcm = new DragonControlMessage();
    private final SimpleNetworkWrapper network;
    
    public DragonControl(SimpleNetworkWrapper network) {
        this.network = network;
        
        ClientRegistry.registerKeyBinding(KEY_FLY_UP);
        ClientRegistry.registerKeyBinding(KEY_FLY_DOWN);
    }
    
    @SubscribeEvent
    public void onTick(ClientTickEvent evt) {
        BitSet flags = dcm.getFlags();
        flags.set(0, ((KeyBinding) KEY_FLY_UP).isKeyDown());
        flags.set(1, ((KeyBinding) KEY_FLY_DOWN).isKeyDown());
        
        // send message to server if it has changed
        if (dcm.hasChanged()) {
            network.sendToServer(dcm);
        }
    }
}
