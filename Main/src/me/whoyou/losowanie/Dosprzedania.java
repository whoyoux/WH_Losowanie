package me.whoyou.losowanie;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Dosprzedania implements CommandExecutor {

    public static Api api;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (command.getName().equalsIgnoreCase("dosprzedania")) {
                Player p = (Player) sender;

                if(args.length == 0) {

                    p.sendMessage(ChatColor.GRAY + api.getString("items_to_sell"));
                    p.sendMessage(ChatColor.GRAY + " - " + ChatColor.BLUE + api.getString("diamond"));
                    p.sendMessage(ChatColor.GRAY + " - " + ChatColor.GREEN + api.getString("dirt"));
                    p.sendMessage(ChatColor.GRAY + " - " + ChatColor.DARK_GRAY + api.getString("cobblestone"));
                    p.sendMessage(ChatColor.GRAY + " - " + ChatColor.RED + api.getString("redstone"));
                    p.sendMessage(ChatColor.GRAY + " - " + ChatColor.GREEN + api.getString("emerald"));
                    return true;

                } else {
                    p.sendMessage(ChatColor.RED + api.getString("error_args"));
                    p.sendMessage(ChatColor.RED + api.getString("usage_dosprzedania"));
                    return true;
                }

            }
        } else {
            sender.sendMessage(ChatColor.RED + api.getString("only_players"));
            return true;
        }

        return false;
    }
}
