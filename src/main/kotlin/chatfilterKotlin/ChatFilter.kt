package com.lent.chatfilterKotlin

import org.bukkit.plugin.java.JavaPlugin

class ChatFilter : JavaPlugin() {
    override fun onEnable() {
        saveDefaultConfig()
        server.pluginManager.registerEvents(ChatFilterEvents(this), this)
    }
}
