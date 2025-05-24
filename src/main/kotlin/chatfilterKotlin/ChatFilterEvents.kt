package com.lent.chatfilterKotlin

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class ChatFilterEvents(private val plugin: ChatFilter) : Listener {

    @EventHandler
    fun onChat(e: AsyncPlayerChatEvent) {
        val message = e.message.lowercase()
        val bannedWords = plugin.config.getStringList("banned-words")

        for (word in bannedWords) {
            if (message.contains(word)) {
                val warn = "&7[&c!&7] &7Your message wasn't sent because it contains a blacklisted word: &c$word"
                e.isCancelled = true
                e.player.sendMessage(ChatColor.translateAlternateColorCodes('&', warn))
                return
            }
        }
    }
}
