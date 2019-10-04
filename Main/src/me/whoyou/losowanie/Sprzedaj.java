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

                            p.sendMessage(ChatColor.GRAY + "Sprzedano " + ChatColor.BLUE + api.item_name_polish(amount, "diament", "diamenty") + ChatColor.GRAY + " za " + ChatColor.YELLOW + price);
                            p.getInventory().removeItem(item);
                            api.addPlayerCoins(p,price);
                            return true;
                        } else if(item_mat == Material.COBBLESTONE) {
                            int price = amount * 1;

                            p.sendMessage(ChatColor.GRAY + "Sprzedano " + ChatColor.DARK_GRAY + api.item_name_polish(amount, "cobblestone", "cobblestony") + ChatColor.GRAY + " za " + ChatColor.YELLOW + price);
                            p.getInventory().removeItem(item);
                            api.addPlayerCoins(p,price);
                            return true;
                        } else if(item_mat == Material.DIRT) {
                            int price = amount * 1;

                            p.sendMessage(ChatColor.GRAY + "Sprzedano " + ChatColor.GREEN + api.item_name_polish(amount, "dirt", "dirt") + ChatColor.GRAY + " za " + ChatColor.YELLOW + price);
                            p.getInventory().removeItem(item);
                            api.addPlayerCoins(p,price);
                            return true;
                        } else if(item_mat == Material.REDSTONE) {
                            int price = amount * 2;

                            p.sendMessage(ChatColor.GRAY + "Sprzedano " + ChatColor.DARK_RED + api.item_name_polish(amount, "redstone", "redstony") + ChatColor.GRAY + " za " + ChatColor.YELLOW + price);
                            p.getInventory().removeItem(item);
                            api.addPlayerCoins(p,price);
                            return true;
                        } else if(item_mat == Material.EMERALD) {
                            int price = amount * 7;

                            p.sendMessage(ChatColor.GRAY + "Sprzedano " + ChatColor.GREEN + api.item_name_polish(amount, "emerald", "emeraldy") + ChatColor.GRAY + " za " + ChatColor.YELLOW + price);
                            p.getInventory().removeItem(item);
                            api.addPlayerCoins(p,price);
                            return true;
                        }

                        p.sendMessage(ChatColor.GRAY + "Tego nie da się jeszcze sprzedać!");
                        return true;
                    } else {
                        p.sendMessage(ChatColor.RED + "Nie masz itemu w ręce!");
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
