package net.michal.diamondcrafting.helpers;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

public class ChatHelper {

    public static String fixChatColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', text)
                .replace(">>", "»");
    }

    public static void sendChatMessage(Player player, String message) {
        player.sendMessage(fixChatColor(message));
    }
}
