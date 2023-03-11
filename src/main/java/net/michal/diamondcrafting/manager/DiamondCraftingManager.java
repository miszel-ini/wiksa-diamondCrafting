package net.michal.diamondcrafting.manager;

import net.michal.diamondcrafting.WiksaDiamondCrafting;

public class DiamondCraftingManager {

    static WiksaDiamondCrafting instance = WiksaDiamondCrafting.getInstance();

    public static void setStatus(boolean status) {
        instance.getConfig().set("status", status);
        instance.saveConfig();
    }

    public static boolean isStatus() {
        return instance.getConfig().getBoolean("status");
    }
}
