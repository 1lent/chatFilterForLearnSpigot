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
            if(message.contains(word.toLowerCase())) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "!" + ChatColor.GRAY + "] " + ChatColor.GRAY + "Your message wasnt sent as it contains the blacklisted word(s): " + word);
            }
        }
    }
}
