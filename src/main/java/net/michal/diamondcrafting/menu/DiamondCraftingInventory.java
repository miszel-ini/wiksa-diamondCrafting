package net.michal.diamondcrafting.menu;

import net.michal.diamondcrafting.WiksaDiamondCrafting;
import net.michal.diamondcrafting.helpers.ChatHelper;
import net.michal.diamondcrafting.helpers.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class DiamondCraftingInventory implements Listener {

    static WiksaDiamondCrafting instance = WiksaDiamondCrafting.getInstance();

    public static Inventory diamondCraftingInventory = Bukkit.createInventory(
            null,
            instance.getConfig().getInt("inventory.size"),
            ChatHelper.fixChatColor(instance.getConfig().getString("inventory.name"))
    );

    public static InventoryView showDiamondCraftingInventory(Player player) {
        ItemBuilder on_craft = new ItemBuilder(Material.matchMaterial(instance.getConfig().getString("inventory.on-craft.material")), (short) instance.getConfig().getInt("inventory.on-craft.data"));
        ItemBuilder off_craft = new ItemBuilder(Material.matchMaterial(instance.getConfig().getString("inventory.off-craft.material")), (short) instance.getConfig().getInt("inventory.off-craft.data"));

        on_craft.setTitle(ChatHelper.fixChatColor(instance.getConfig().getString("inventory.on-craft.name")));
        off_craft.setTitle(ChatHelper.fixChatColor(instance.getConfig().getString("inventory.off-craft.name")));

        diamondCraftingInventory.setItem(instance.getConfig().getInt("inventory.on-craft.slot"), on_craft.build());
        diamondCraftingInventory.setItem(instance.getConfig().getInt("inventory.off-craft.slot"), off_craft.build());

        return player.openInventory(diamondCraftingInventory);
    }
}
