package me.whoyou.losowanie;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Saldo implements CommandExecutor {

    public static Api api;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(command.getName().equalsIgnoreCase("saldo")) {
                Player p = (Player) sender;

                Integer currentMoney = api.getPlayerCoins(p);

                if(currentMoney != null) {
                    //p.sendMessage(ChatColor.GRAY + "Twoje saldo to: " + ChatColor.YELLOW + currentMoney.toString());
                    api.sendTitle(p,"Twoje saldo to: §e" + currentMoney.toString(), "",40,20,20);
                    return true;
                } else {
                    //p.sendMessage(ChatColor.RED + "Wystąpił błąd! Przepraszamy za utrudnienia!");
                    api.sendTitle(p,"§cWystąpił błąd!", "§cPrzepraszamy za utrudnienia!",40,20,20);
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
