package net.michal.diamondcrafting.listeners;

import net.michal.diamondcrafting.WiksaDiamondCrafting;
import net.michal.diamondcrafting.helpers.ChatHelper;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class DiamondCraftingListener implements Listener {

    WiksaDiamondCrafting instance = WiksaDiamondCrafting.getInstance();

    @EventHandler
    public void onPlayerCraft(CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(event.getRecipe().getResult().getType().toString().startsWith("DIAMOND_")) {
            event.setCancelled(true);
            player.closeInventory();
            ChatHelper.sendChatMessage(player, instance.getConfig().getString("messages.cannot-crafting"));
        } else {
            event.setCancelled(false);
        }
    }
}
