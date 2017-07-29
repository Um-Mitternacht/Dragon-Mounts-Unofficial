package com.TheRPGAdventurer.server.entity.helper;

import java.util.UUID;
import net.minecraft.entity.ai.attributes.AttributeModifier;

public class DragonScaleModifier extends AttributeModifier {
    
    public static final UUID ID = UUID.fromString("856d4ba4-9ffe-4a52-8606-890bb9be538b");

    public DragonScaleModifier(double amount) {
        super(ID, "Dragon size modifier", amount, 1);
        setSaved(false);
    }
}
