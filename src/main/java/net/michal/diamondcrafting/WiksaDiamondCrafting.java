package net.michal.diamondcrafting;

import net.michal.diamondcrafting.commands.DiamondCraftingCommand;
import net.michal.diamondcrafting.listeners.DiamondCraftingListener;
import net.michal.diamondcrafting.menu.DiamondCraftingInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class WiksaDiamondCrafting extends JavaPlugin {

    static WiksaDiamondCrafting instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        reloadConfig();

        getCommand("d-crafting").setExecutor(new DiamondCraftingCommand());
        getServer().getPluginManager().registerEvents(new DiamondCraftingListener(), this);
    }

    public static WiksaDiamondCrafting getInstance() {
        return instance;
    }
}
