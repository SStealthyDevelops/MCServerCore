package me.satvikmathur.mcserver;

import me.satvikmathur.mcserver.commands.NameItemCommand;
import me.satvikmathur.mcserver.commands.NicknameCommand;
import me.satvikmathur.mcserver.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        if (!initializeCommands()) {
            Bukkit.getConsoleSender().sendMessage(Color.cc("&c&c[CORE] Error loading commands."));
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Color.cc("&c&c[CORE] Disabling plugin."));
    }

    private boolean initializeCommands() {
        try {
            getCommand("nickname").setExecutor(new NicknameCommand());
            getCommand("nameitem").setExecutor(new NameItemCommand());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
