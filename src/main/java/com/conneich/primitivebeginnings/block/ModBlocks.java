package com.conneich.primitivebeginnings.block;

import com.conneich.primitivebeginnings.PrimitiveBeginningsMod;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
            ForgeRegistries.BLOCKS, PrimitiveBeginningsMod.MODID
    );

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
