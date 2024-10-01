package me.satvikmathur.mcserver.commands;

import me.satvikmathur.mcserver.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NicknameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (args.length != 1) {
                sender.sendMessage(Color.cc("&cUsage: /nick <your name> | &c&lDo not abuse. "));
                return false;
            }
            String nickname = args[0];
            player.setDisplayName(nickname);
            return true;
        }

        // Console Sender
        if (args.length != 2) {
            sender.sendMessage(Color.cc("&cUsage: /nick <player name> <your name>"));
            return false;
        }

        String targetName = args[0];
        String newNickname = args[1];
        Player targetPlayer = Bukkit.getPlayer(targetName);
        if (targetPlayer == null) {
            sender.sendMessage(Color.cc("&cPlayer not found."));
            return false;
        }
        targetPlayer.setDisplayName(newNickname);
        sender.sendMessage("&a" + targetPlayer.getName() + "'s nickname updated to " + newNickname);
        targetPlayer.sendMessage("&aYour nickname was updated to " + newNickname);
        return true;
    }
}
