package net.michal.diamondcrafting.listeners;

import net.michal.diamondcrafting.WiksaDiamondCrafting;
import net.michal.diamondcrafting.helpers.ChatHelper;
import net.michal.diamondcrafting.manager.DiamondCraftingManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

public class DiamondCraftingListener implements Listener {

    WiksaDiamondCrafting instance = WiksaDiamondCrafting.getInstance();

    @EventHandler
    public void onPlayerCraft(CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getRecipe().getResult().getType().toString().startsWith("DIAMOND_")) {
            if (!DiamondCraftingManager.isStatus()) {
                event.setCancelled(true);
                player.closeInventory();
                ChatHelper.sendChatMessage(player, instance.getConfig().getString("messages.cannot-crafting"));
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if(event.getInventory().getName().equalsIgnoreCase(ChatHelper.fixChatColor(instance.getConfig().getString("inventory.name")))) {
             event.setCancelled(true);

            if(event.getRawSlot() == instance.getConfig().getInt("inventory.on-craft.slot")) {
                DiamondCraftingManager.setStatus(true);
                ChatHelper.sendChatMessage(player, instance.getConfig().getString("message.enable-crafting"));
            } else if (event.getRawSlot() == instance.getConfig().getInt("inventory.off-craft.slot")) {
                DiamondCraftingManager.setStatus(false);
                ChatHelper.sendChatMessage(player, instance.getConfig().getString("message.disable-crafting"));
            }
        }
    }
}
