package net.michal.diamondcrafting.commands;

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
                        //todo: open inventory with 2 blocks of wool -> 1 green "WLACZ", 2 red "WYLACZ"
                        break;
                }
            }
        } else {
            //todo: send message if player hasnt permission of command
        }

        return false;
    }
}
