package com.lent.chatFiltere;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class ChatFiltere extends JavaPlugin {
    private List<String> bannedWords;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new CfEvent(this), this);
    }

}
