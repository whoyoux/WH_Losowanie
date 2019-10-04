package me.whoyou.losowanie;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class Bet implements CommandExecutor {

    public static Api api;

    private String color_Title_Green = "§2";
    private String color_Title_Gold = "§6";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(command.getName().equalsIgnoreCase("bet")) {
                Player p = (Player) sender;

                if(args.length == 2) {
                    if(api.isNumber(args[0])) {

                        if(api.getNumber(args[0]) > 0) {

                            if(args[1].equals("czerwone") || args[1].equals("zielone") || args[1].equals("czarne")) {

                                int coins = api.getPlayerCoins(p);
                                int coins_bet = api.getNumber(args[0]);
                                if(coins_bet <= coins) {
                                    Random r = new Random();
                                    Integer game = r.nextInt(1000);
                                    api.removePlayerCoins(p, coins_bet);

                                    if(game < 525) {
                                        if(args[1].equals("czerwone")) {

                                            api.addPlayerCoins(p,2 * coins_bet);
                                            api.refreshConfig();
                                            api.sendTitle(p,"§eGratulacje" + color_Title_Green + " Wygralo §cczerwone §9+" + 2*coins_bet, color_Title_Green + "Twoje saldo to §e" + api.getPlayerCoins(p), 40, 20, 20);
                                            api.playEffect(p, Color.RED);

                                            return true;
                                        } else {
                                            lose(p,game, coins_bet);
                                            return true;
                                        }
                                    } else if (game < 575) {
                                        if(args[1].equals("zielone")) {
                                            api.addPlayerCoins(p,14 * coins_bet);
                                            api.sendTitle(p,"§eGratulacje!" + color_Title_Green + " Wygralo §azielone §9+" + 14*coins_bet, color_Title_Green + "Twoje saldo to §e" + api.getPlayerCoins(p), 40, 20, 20);
                                            api.playEffect(p, Color.GREEN);
                                            return true;
                                        } else {
                                            lose(p,game, coins_bet);
                                            return true;
                                        }
                                    } else if (game < 1000) {
                                        if(args[1].equals("czarne")) {
                                            api.addPlayerCoins(p,2 * coins_bet);
                                            api.sendTitle(p,"§eGratulacje!" + color_Title_Green + " Wygralo §8czarne §9+" + 2*coins_bet, color_Title_Green + "Twoje saldo to §e" + api.getPlayerCoins(p), 40, 20, 20);
                                            api.playEffect(p, Color.BLACK);
                                            return true;
                                        } else {
                                            lose(p,game, coins_bet);
                                            return true;
                                        }
                                    }
                                    return true;
                                } else {
                                    p.sendMessage(ChatColor.RED + "Nie masz wystarczającej ilości coinsów!");
                                    return true;
                                }

                            } else {
                                p.sendMessage(ChatColor.RED + "Musisz podać drużyne! Dostępne drużyny: " + ChatColor.DARK_RED + "czerwone " + ChatColor.GREEN + "zielone" + ChatColor.DARK_GRAY + "czarne" + ChatColor.RED + ".");
                                return true;
                            }

                        } else {
                            p.sendMessage(ChatColor.RED + "Kwota musi być dodatnia!");
                            return true;
                        }

                    } else {
                        p.sendMessage(ChatColor.RED + "Kwota musi być podana za pomocą liczby i musi być równa lub mniejsza niż 1mln!");
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

    public void lose(Player p, int game, int coins_bet) {

        String win_team = "";

        if(game < 525) {
            win_team =  color_Title_Gold + "Wygrało §cczerwone";
        } else if(game <575) {
            win_team =  color_Title_Gold + "Wygrało §azielone";
        } else if(game < 1000) {
            win_team =  color_Title_Gold + "Wygrało §8czarne";
        }

        api.refreshConfig();
        api.sendTitle(p,color_Title_Green + "Niestety przegrałeś, " + win_team,color_Title_Green + "Twoje saldo to §e" + api.getPlayerCoins(p) , 40, 20, 20);
    }

}
