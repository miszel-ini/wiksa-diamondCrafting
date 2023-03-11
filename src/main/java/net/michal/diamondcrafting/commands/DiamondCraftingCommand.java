package net.michal.diamondcrafting.commands;

import net.michal.diamondcrafting.menu.DiamondCraftingInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiamondCraftingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        if(player.isOp() || player.hasPermission("diamondcrafting.command")) {
            if(args.length == 1) {
                switch(args[0]) {
                    case "manage":
                        DiamondCraftingInventory.showDiamondCraftingInventory(player);
                        break;
                }
            }
        } else {
            //todo: send message if player hasnt permission of command
        }

        return false;
    }
}
