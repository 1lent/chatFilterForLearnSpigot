package com.lent.chatFiltere;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import java.util.List;

public class CfEvent implements Listener {
    private final ChatFilter plugin;
    public CfEvent(ChatFilter plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String message = e.getMessage().toLowerCase();
        List<String> bannedWords = plugin.getConfig().getStringList("banned-words");

        for(String word : bannedWords) {
            if(message.contains(word)) {
                String warn = "&7[&c!&7] &7Your message wasn't sent because it contains a blacklisted word: &c" + word;
                e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', warn));
            }
        }
    }
}
