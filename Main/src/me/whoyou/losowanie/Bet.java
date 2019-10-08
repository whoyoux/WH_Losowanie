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

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(command.getName().equalsIgnoreCase("bet")) {
                Player p = (Player) sender;

                if(args.length == 2) {
                    if(api.isNumber(args[0])) {

                        if(api.getNumber(args[0]) > 0) {

                            if(args[1].equals(api.getString("red_team")) || args[1].equals(api.getString("green_team")) || args[1].equals(api.getString("black_team"))) {

                                int coins = api.getPlayerCoins(p);
                                int coins_bet = api.getNumber(args[0]);
                                if(coins_bet <= coins) {
                                    Random r = new Random();
                                    Integer game = r.nextInt(1000);
                                    api.removePlayerCoins(p, coins_bet);

                                    if(game < 525) {
                                        if(args[1].equals(api.getString("red_team"))) {

                                            api.addPlayerCoins(p,2 * coins_bet);
                                            api.refreshConfig();
                                            api.sendTitle(p,api.getString("color_Title_Congratulation") + api.getString("congratulation") +  " " + api.getString("color_Title_Primary") + api.getString("win") + api.getString("color_red") +  api.getString("red_team") + api.getString("color_blue") + " +" + 2*coins_bet, api.getString("color_Title_Primary") + api.getString("balance")+ api.getString("color_Title_Congratulation") + api.getPlayerCoins(p), 40, 20, 20);
                                            api.playEffect(p, Color.RED);

                                            return true;
                                        } else {
                                            lose(p,game, coins_bet);
                                            return true;
                                        }
                                    } else if (game < 575) {
                                        if(args[1].equals(api.getString("green_team"))) {
                                            api.addPlayerCoins(p,14 * coins_bet);
                                            api.sendTitle(p,api.getString("color_Title_Congratulation") + api.getString("congratulation") + " " + api.getString("color_Title_Primary") + api.getString("win") + api.getString("color_green") + api.getString("green_team") + api.getString("color_blue") + " +" + 14*coins_bet, api.getString("color_Title_Primary") + api.getString("balance")+ api.getString("color_Title_Congratulation") + api.getPlayerCoins(p), 40, 20, 20);
                                            api.playEffect(p, Color.GREEN);
                                            return true;
                                        } else {
                                            lose(p,game, coins_bet);
                                            return true;
                                        }
                                    } else if (game < 1000) {
                                        if(args[1].equals(api.getString("black_team"))) {
                                            api.addPlayerCoins(p,2 * coins_bet);
                                            api.sendTitle(p,api.getString("color_Title_Congratulation") + api.getString("congratulation") +  " " + api.getString("color_Title_Primary") + api.getString("win") + api.getString("color_black") + api.getString("black_team") + api.getString("color_blue") + " +" + 2*coins_bet, api.getString("color_Title_Primary") + api.getString("balance")+ api.getString("color_Title_Congratulation") + api.getPlayerCoins(p), 40, 20, 20);
                                            api.playEffect(p, Color.BLACK);
                                            return true;
                                        } else {
                                            lose(p,game, coins_bet);
                                            return true;
                                        }
                                    }
                                    return true;
                                } else {
                                    p.sendMessage(ChatColor.RED + api.getString("dont_have_money"));
                                    return true;
                                }

                            } else {
                                p.sendMessage(ChatColor.RED + api.getString("enter_team") + ChatColor.DARK_RED + api.getString("red_team") +" "+ ChatColor.GREEN + api.getString("green_team") + ChatColor.DARK_GRAY + " " + api.getString("black_team") + ChatColor.RED + ".");
                                return true;
                            }

                        } else {
                            p.sendMessage(ChatColor.RED + api.getString("more_than_0"));
                            return true;
                        }

                    } else {
                        p.sendMessage(ChatColor.RED + api.getString("less_than_ 1mln"));
                        return true;
                    }
                } else {
                    p.sendMessage(ChatColor.RED + api.getString("error_args"));
                    p.sendMessage(ChatColor.RED + api.getString("usage_bet"));
                    return true;
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + api.getString("only_player"));
            return true;
        }


        return false;
    }

    public void lose(Player p, int game, int coins_bet) {

        String win_team = "";

        if(game < 525) {
            win_team =  api.getString("color_Title_Secondary") + api.getString("win") + api.getString("color_red") + api.getString("red_team");
        } else if(game <575) {
            win_team =  api.getString("color_Title_Secondary") + api.getString("win") + api.getString("color_green") + api.getString("green_team");
        } else if(game < 1000) {
            win_team =  api.getString("color_Title_Secondary") + api.getString("win") + api.getString("color_black") + api.getString("black_team");
        }

        api.refreshConfig();
        api.sendTitle(p,api.getString("color_Title_Primary") + api.getString("lose") + ", " + win_team,api.getString("color_Title_Primary") + api.getString("balance") + api.getString("color_Title_Congratulation") + api.getPlayerCoins(p) , 40, 20, 20);
    }

}
