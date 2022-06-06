package com.conneich.primitivebeginnings.event;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class NoWoodBreaking {

    @SubscribeEvent
    public void registerEvent(PlayerEvent.BreakSpeed event)
    {
        if (event.getState() == null || event.getPlayer() == null) return;

        ItemStack heldItem = event.getPlayer().getMainHandItem();

        // NO WOOD TOOLS
        if (!(event.getState().getMaterial() == Material.WOOD ||
                event.getState().getMaterial() == Material.NETHER_WOOD)) return;

        // If the player isn't holding an axe, cancel the event
        if (!(heldItem.getItem() instanceof AxeItem))
        {
            event.setCanceled(true);
        }
    }


}
