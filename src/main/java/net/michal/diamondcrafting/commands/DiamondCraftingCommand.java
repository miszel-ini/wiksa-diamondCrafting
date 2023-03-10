package net.michal.diamondcrafting.commands;

import net.michal.diamondcrafting.WiksaDiamondCrafting;
import net.michal.diamondcrafting.helpers.ChatHelper;
import net.michal.diamondcrafting.menu.DiamondCraftingInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiamondCraftingCommand implements CommandExecutor {

    WiksaDiamondCrafting instance = WiksaDiamondCrafting.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        if(player.isOp() || player.hasPermission("diamondcrafting.command")) {
            if(args.length == 1) {
                switch(args[0]) {
                    case "manage":
                        DiamondCraftingInventory.showDiamondCraftingInventory(player);
                        break;

                    case "reload":
                        instance.reloadConfig();
                        ChatHelper.sendChatMessage(player, instance.getConfig().getString("messages.reload-config"));
                        break;
                }
            } else {
                ChatHelper.sendChatMessage(player, instance.getConfig().getString("messages.correct-usage"));
            }
        } else {
            ChatHelper.sendChatMessage(player, instance.getConfig().getString("messages.player-no-permission"));
        }

        return false;
    }
}
