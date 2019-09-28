package me.whoyou.losowanie;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Setcoins implements CommandExecutor {

    public static Api api;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(command.getName().equalsIgnoreCase("setcoins")) {
                Player p = (Player) sender;

                if(args.length == 2) {
                    if(p.hasPermission("wh_ruletka.setcoins")) {

                        if(api.isPlayer(args[1])) {

                            if(api.isNumber(args[0]) && api.getNumber(args[0]) <= 1000000) {
                                int coinsToAdd = api.getNumber(args[0]);

                                if(coinsToAdd > 0 && coinsToAdd <= 1000000) {

                                    Player player = api.getPlayer(args[1]);

                                    if(player != null) {
                                        api.setPlayerCoins(player,coinsToAdd);
                                        p.sendMessage(ChatColor.GRAY + "Kwota: " + ChatColor.YELLOW + coinsToAdd + ChatColor.GRAY + " została ustawiona graczu: " + ChatColor.YELLOW + player.getName() + ChatColor.GRAY + ".");
                                        return true;
                                    } else {
                                        p.sendMessage(ChatColor.RED + "Nie znaleziono gracza!");
                                        return true;
                                    }


                                } else {
                                    p.sendMessage(ChatColor.RED + "Kwota do ustawienia musi być dodatnia!");
                                    return true;
                                }

                            } else {
                                p.sendMessage(ChatColor.RED + "Kwota do ustawienia musi być liczbą i być miejsza niż 1mln!");
                                return true;
                            }

                        } else {
                            p.sendMessage(ChatColor.RED + "Nie ma takiego gracza!");
                            return true;
                        }

                    } else {
                        p.sendMessage(ChatColor.RED + "Nie masz do tej komendy dostępu!");
                        return true;
                    }

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
