package me.whoyou.losowanie;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Sprzedaj implements CommandExecutor {

    public static Api api;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (command.getName().equalsIgnoreCase("sprzedaj")) {
                Player p = (Player) sender;

                if(args.length == 0) {

                    ItemStack item = p.getInventory().getItemInMainHand();

                    if(!(item.getType().equals(Material.AIR))) {
                        Material item_mat = item.getType();
                        String item_name = item.getItemMeta().hasDisplayName() ? item.getItemMeta().getDisplayName() : item.getType().name().replace("_", " ").toLowerCase();

                        // Sprawdzanie itemu!

                        int amount = item.getAmount();

                        if(item_mat == Material.DIAMOND) {
                            int price = amount * 5;

                            p.sendMessage(ChatColor.GRAY + api.getString("sell") + " " + ChatColor.BLUE + api.item_name_polish(amount, api.getString("diamond"),api.getString("diamond") + api.getString("more_1")) + ChatColor.GRAY + " za " + ChatColor.YELLOW + price);
                            p.getInventory().removeItem(item);
                            api.addPlayerCoins(p,price);
                            return true;
                        } else if(item_mat == Material.COBBLESTONE) {
                            int price = amount * 1;

                            p.sendMessage(ChatColor.GRAY + api.getString("sell") + " " + ChatColor.DARK_GRAY + api.item_name_polish(amount, api.getString("cobblestone"),api.getString("cobblestone") + api.getString("more_1")) + ChatColor.GRAY + " za " + ChatColor.YELLOW + price);
                            p.getInventory().removeItem(item);
                            api.addPlayerCoins(p,price);
                            return true;
                        } else if(item_mat == Material.DIRT) {
                            int price = amount * 1;

                            p.sendMessage(ChatColor.GRAY + api.getString("sell") + " " + ChatColor.GREEN + api.item_name_polish(amount, api.getString("dirt"),api.getString("dirt") + api.getString("more_1")) + ChatColor.GRAY + " za " + ChatColor.YELLOW + price);
                            p.getInventory().removeItem(item);
                            api.addPlayerCoins(p,price);
                            return true;
                        } else if(item_mat == Material.REDSTONE) {
                            int price = amount * 2;

                            p.sendMessage(ChatColor.GRAY + api.getString("sell") + " " + ChatColor.DARK_RED + api.item_name_polish(amount, api.getString("redstone"),api.getString("redstone") + api.getString("more_1")) + ChatColor.GRAY + " za " + ChatColor.YELLOW + price);
                            p.getInventory().removeItem(item);
                            api.addPlayerCoins(p,price);
                            return true;
                        } else if(item_mat == Material.EMERALD) {
                            int price = amount * 7;

                            p.sendMessage(ChatColor.GRAY + api.getString("sell") + " " + ChatColor.GREEN + api.item_name_polish(amount, api.getString("emerald"),api.getString("emerald") + api.getString("more_1")) + ChatColor.GRAY + " za " + ChatColor.YELLOW + price);
                            p.getInventory().removeItem(item);
                            api.addPlayerCoins(p,price);
                            return true;
                        }

                        p.sendMessage(ChatColor.GRAY + api.getString("cant_sell"));
                        return true;
                    } else {
                        p.sendMessage(ChatColor.RED + api.getString("item_hand"));
                        return true;
                    }

                } else {
                    p.sendMessage(ChatColor.RED + api.getString("error_args"));
                    p.sendMessage(ChatColor.RED + api.getString("usage_sprzedaj"));
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
