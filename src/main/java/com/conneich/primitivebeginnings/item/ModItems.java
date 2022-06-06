package com.conneich.primitivebeginnings.item;

import com.conneich.primitivebeginnings.PrimitiveBeginningsMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, PrimitiveBeginningsMod.MODID
    );




    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
