package me.whoyou.losowanie;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class Bet implements CommandExecutor {

    public static Api api;

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

                                            //p.sendMessage(ChatColor.GRAY + "Wygralo" + ChatColor.RED + " czerwone");
                                            api.addPlayerCoins(p,2 * coins_bet);
                                            api.refreshConfig();
                                            //p.sendMessage(ChatColor.GRAY + "Twoje saldo to: " + ChatColor.YELLOW + api.getPlayerCoins(p) + ChatColor.BLUE + " +" + 2 * coins_bet);

                                            api.sendTitle(p,"§eGratulacje!!! §fWygralo §cczerwone §9+" + 2*coins_bet, "§fTwoje saldo to §e" + api.getPlayerCoins(p), 40, 20, 20);
                                            return true;
                                        } else {
                                            lose(p,game, coins_bet);
                                            return true;
                                        }
                                    } else if (game < 575) {
                                        if(args[1].equals("zielone")) {
                                            //p.sendMessage(ChatColor.GRAY + "Wygralo" + ChatColor.GREEN + " zielone");
                                            api.addPlayerCoins(p,14 * coins_bet);
                                            //p.sendMessage(ChatColor.GRAY + "Twoje saldo to: " + ChatColor.YELLOW + api.getPlayerCoins(p) + ChatColor.BLUE + " +" + 14 * coins_bet);
                                            api.sendTitle(p,"§eGratulacje!!! §fWygralo §azielone §9+" + 14*coins_bet, "§fTwoje saldo to §e" + api.getPlayerCoins(p), 40, 20, 20);
                                            return true;
                                        } else {
                                            //p.sendMessage(ChatColor.GRAY + "Niestety przegrałeś.");

                                            lose(p,game, coins_bet);
                                            return true;
                                        }
                                    } else if (game < 1000) {
                                        if(args[1].equals("czarne")) {
                                            //p.sendMessage(ChatColor.GRAY + "Wygralo " + ChatColor.DARK_GRAY + "czarne");
                                            api.addPlayerCoins(p,2 * coins_bet);
                                            //p.sendMessage(ChatColor.GRAY + "Twoje saldo to: " + ChatColor.YELLOW + api.getPlayerCoins(p) + ChatColor.BLUE +  " +" + 2 *coins_bet);
                                            api.sendTitle(p,"§eGratulacje!!! §fWygralo §8czarne §9+" + 2*coins_bet, "§fTwoje saldo to §e" + api.getPlayerCoins(p), 40, 20, 20);
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
            //p.sendMessage(ChatColor.GRAY + "Wygralo" + ChatColor.RED + " czerwone");
            //api.sendTitle(p,"Wygrało §cczerwone", "", 40, 20, 20);
            win_team =  "Wygrało §cczerwone";
        } else if(game <575) {
            //p.sendMessage(ChatColor.GRAY + "Wygralo" + ChatColor.GREEN + " zielone");
            //api.sendTitle(p,"Wygrało §azielone", "", 40, 20, 20);
            win_team =  "Wygrało §azielone";
        } else if(game < 1000) {
            //p.sendMessage(ChatColor.GRAY + "Wygralo " + ChatColor.DARK_GRAY + "czarne");
            //api.sendTitle(p,"Wygrało §8czarne", "", 40, 20, 20);
            win_team =  "Wygrało §8czarne";
        }

        api.refreshConfig();
        api.sendTitle(p,"Niestety przegrałeś, " + win_team,"§fTwoje saldo to §e" + api.getPlayerCoins(p) , 40, 20, 20);
    }

}
