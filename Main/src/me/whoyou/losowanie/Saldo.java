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
        if (sender instanceof Player) {
            if (command.getName().equalsIgnoreCase("saldo")) {
                Player p = (Player) sender;

                if (args.length == 0) {
                    Integer currentMoney = api.getPlayerCoins(p);

                    if (currentMoney != null) {
                        api.sendTitle(p, api.getString("color_Title_Primary") +api.getString("balance") + api.getString("color_Title_Congratulation") + currentMoney.toString(), "", 40, 20, 20);
                        return true;
                    } else {
                        api.sendTitle(p, api.getString("color_red") + api.getString("error"), "", 40, 20, 20);
                        return true;
                    }
                } else if (args.length == 1) {

                    if (!p.hasPermission("wh_ruletka.admin.saldo")) {
                        p.sendMessage(ChatColor.RED + api.getString("permission"));
                        return true;
                    }

                    String playerName = args[0];

                    if (api.isPlayer(playerName)) {
                        Player player = api.getPlayer(playerName);
                        Integer playerMoney = api.getPlayerCoins(player);

                        if (playerMoney != null) {
                            p.sendMessage(ChatColor.GRAY + api.getString("balance_player") +" " + playerName + ": " + api.getString("color_Title_Congratulation") + playerMoney.toString());
                            return true;
                        } else {
                            p.sendMessage(ChatColor.RED + api.getString("error"));
                            return true;
                        }

                    } else {
                        p.sendMessage(ChatColor.RED + api.getString("not_found_player"));
                        return true;
                    }
                } else {
                    p.sendMessage(ChatColor.RED + api.getString("error_args"));
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
