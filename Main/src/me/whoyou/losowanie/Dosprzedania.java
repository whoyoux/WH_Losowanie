package me.whoyou.losowanie;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Dosprzedania implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (command.getName().equalsIgnoreCase("dosprzedania")) {
                Player p = (Player) sender;

                if(args.length == 0) {

                    p.sendMessage(ChatColor.GRAY + "Itemy, które można sprzedać:");
                    p.sendMessage(ChatColor.GRAY + " - " + ChatColor.BLUE + "diamenty");
                    p.sendMessage(ChatColor.GRAY + " - " + ChatColor.GREEN + "dirt");
                    p.sendMessage(ChatColor.GRAY + " - " + ChatColor.DARK_GRAY + "cobblestone");
                    p.sendMessage(ChatColor.GRAY + " - " + ChatColor.RED + "redstone");
                    p.sendMessage(ChatColor.GRAY + " - " + ChatColor.GREEN + "emeraldy");
                    return true;

                } else {
                    p.sendMessage(ChatColor.RED + "Błędna ilość argumentów!");
                    return true;
                }

            }
        } else {
            sender.sendMessage(ChatColor.RED + "Tylko gracze mogą uzyc tej komendy!");
            return true;
        }

        return false;
    }
}
