package me.whoyou.losowanie;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ustawsaldo implements CommandExecutor {

    public static Api api;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(command.getName().equalsIgnoreCase("ustawsaldo")) {
                Player p = (Player) sender;

                if(args.length == 2) {
                    if(p.hasPermission("wh_ruletka.admin.setcoins")) {

                        if(api.isPlayer(args[1])) {

                            if(api.isNumber(args[0]) && api.getNumber(args[0]) <= 1000000) {
                                int coinsToAdd = api.getNumber(args[0]);

                                if(coinsToAdd > 0 && coinsToAdd <= 1000000) {

                                    Player player = api.getPlayer(args[1]);

                                    if(player != null) {
                                        api.setPlayerCoins(player,coinsToAdd);
                                        p.sendMessage(ChatColor.GRAY + api.getString("amout") + ": " + ChatColor.YELLOW + coinsToAdd + ChatColor.GRAY + " " + api.getString("set") + ": " + ChatColor.YELLOW + player.getName() + ChatColor.GRAY + ".");
                                        return true;
                                    } else {
                                        p.sendMessage(ChatColor.RED + api.getString("not_found_player"));
                                        return true;
                                    }


                                } else {
                                    p.sendMessage(ChatColor.RED + api.getString("more_than_0"));
                                    return true;
                                }

                            } else {
                                p.sendMessage(ChatColor.RED + api.getString("amout_more_1mln"));
                                return true;
                            }

                        } else {
                            p.sendMessage(ChatColor.RED + api.getString("not_found_player"));
                            return true;
                        }

                    } else {
                        p.sendMessage(ChatColor.RED + api.getString("permission"));
                        return true;
                    }

                } else {
                    p.sendMessage(ChatColor.RED + api.getString("error_args"));
                    p.sendMessage(ChatColor.RED + api.getString("usage_setcoins"));
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
