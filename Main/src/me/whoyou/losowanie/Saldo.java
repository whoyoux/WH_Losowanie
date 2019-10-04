package me.whoyou.losowanie;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Saldo implements CommandExecutor {

    public static Api api;
    private String color_Title_Green = "§2";
    private String color_Title_Gold = "§6";


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (command.getName().equalsIgnoreCase("saldo")) {
                Player p = (Player) sender;

                if (args.length == 0) {
                    Integer currentMoney = api.getPlayerCoins(p);

                    if (currentMoney != null) {
                        api.sendTitle(p, color_Title_Green +"Twoje saldo to: §e" + currentMoney.toString(), "", 40, 20, 20);
                        return true;
                    } else {
                        api.sendTitle(p, "§cWystąpił błąd!", "§cPrzepraszamy za utrudnienia!", 40, 20, 20);
                        return true;
                    }
                } else if (args.length == 1) {

                    if (!p.hasPermission("wh_ruletka.admin.saldo")) {
                        p.sendMessage(ChatColor.RED + "Nie masz do tej komendy dostępu!");
                        return true;
                    }

                    String playerName = args[0];

                    if (api.isPlayer(playerName)) {
                        Player player = api.getPlayer(playerName);
                        Integer playerMoney = api.getPlayerCoins(player);

                        if (playerMoney != null) {
                            p.sendMessage(ChatColor.GRAY + "Saldo " + playerName + " to: " + ChatColor.YELLOW + playerMoney.toString());
                            return true;
                        } else {
                            p.sendMessage(ChatColor.RED + "Wystąpił błąd! Przepraszamy za utrudnienia!");
                            return true;
                        }

                    } else {
                        p.sendMessage(ChatColor.RED + "Nie znaleziono takiego gracza!");
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
