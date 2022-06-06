package com.conneich.primitivebeginnings.event;

import com.conneich.primitivebeginnings.config.ModCommonConfig;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class NoLowTierToolUse {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onHover(ItemTooltipEvent event)
    {
        Item item = event.getItemStack().getItem();
        if (!(item instanceof TieredItem)) return;

        TieredItem tiered = (TieredItem) item;

        if ((tiered.getTier() == Tiers.WOOD) && ModCommonConfig.REMOVE_WOOD_TOOLS.get())
        {
            // Add this to the bottom of the item tooltip
            event.getToolTip().add(new TextComponent("\u00A74" + "This tool isn't very durable" + "\u00A7r"));
            return;
        }

        if ((tiered.getTier() == Tiers.STONE) && ModCommonConfig.REMOVE_STONE_TOOLS.get())
        {
            event.getToolTip().add(new TextComponent("\u00A74" + "This tool isn't very durable" + "\u00A7r"));
            return;
        }
    }

    @SubscribeEvent
    public void registerEvent(PlayerEvent.BreakSpeed event)
    {
        if (event.getState() == null || event.getPlayer() == null) return;

        // Get the player's main hand equipped item
        // and check to see if it is a Tool/TieredItem
        Item heldItem = event.getPlayer().getMainHandItem().getItem();
        if (!(heldItem instanceof TieredItem)) return;

        TieredItem tiered = (TieredItem) heldItem;
        // if the item is made of wood and our config is disabling it
        boolean noWood = (tiered.getTier() == Tiers.WOOD) && ModCommonConfig.REMOVE_WOOD_TOOLS.get();
        // same for stone
        boolean noStone = (tiered.getTier() == Tiers.STONE) && ModCommonConfig.REMOVE_STONE_TOOLS.get();

        if (noStone || noWood)
            event.setCanceled(true);


    }
}
