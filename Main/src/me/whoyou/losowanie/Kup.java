package me.whoyou.losowanie;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.ArrayList;

public class Kup implements CommandExecutor {

    public static Api api;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(command.getName().equalsIgnoreCase("kup")) {
                Player p = (Player) sender;

                if(!(args.length == 0)) {
                    p.sendMessage(ChatColor.RED + "Błędna ilość argumentów!");
                    return true;
                }

                Inventory gui = Bukkit.createInventory(p,9,"Kupno");

                ItemStack elytra = new ItemStack(Material.ELYTRA);
                ItemMeta elytra_meta = elytra.getItemMeta();
                elytra_meta.setDisplayName(ChatColor.GOLD + "ELYTRA");
                ArrayList<String> elytra_lore = new ArrayList();
                elytra_lore.add(ChatColor.GRAY + "Koszt: " + ChatColor.RED + "999999 coins");
                elytra_meta.setLore(elytra_lore);
                elytra.setItemMeta(elytra_meta);

                ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);

                ItemMeta sword_meta = sword.getItemMeta();
                sword_meta.setDisplayName(ChatColor.BLUE + "Turbo kozacki miecz");
                sword_meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
                sword_meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
                sword_meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
                sword_meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                sword_meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 5, true);
                sword_meta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
                ArrayList<String> sword_lore = new ArrayList<>();
                sword_lore.add("");
                sword_lore.add(ChatColor.GRAY + "Koszt: " + ChatColor.RED + "10000 coins");
                sword_meta.setLore(sword_lore);
                sword.setItemMeta(sword_meta);

                ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);

                ItemMeta pickaxe_meta = pickaxe.getItemMeta();
                pickaxe_meta.setDisplayName(ChatColor.BLUE + "Turbo kozacki kilof");
                pickaxe_meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
                pickaxe_meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
                pickaxe_meta.addEnchant(Enchantment.DURABILITY, 3, true);
                ArrayList<String> pickaxe_lore = new ArrayList<>();
                pickaxe_lore.add("");
                pickaxe_lore.add(ChatColor.GRAY + "Koszt: " + ChatColor.RED + "8000 coins");
                pickaxe_meta.setLore(pickaxe_lore);
                pickaxe.setItemMeta(pickaxe_meta);

                ItemStack axe = new ItemStack(Material.DIAMOND_AXE);

                ItemMeta axe_meta = pickaxe.getItemMeta();
                axe_meta.setDisplayName(ChatColor.BLUE + "Turbo kozacka siekiera");
                axe_meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
                axe_meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
                axe_meta.addEnchant(Enchantment.DURABILITY, 3, true);
                axe_meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                ArrayList<String> axe_lore = new ArrayList<>();
                axe_lore.add("");
                axe_lore.add(ChatColor.RED + "8000 coins");
                axe_meta.setLore(axe_lore);
                axe.setItemMeta(axe_meta);


                ItemStack empty_slot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);

                //gui.addItem(hydra,sword,pickaxe,axe);
                gui.setItem(0, empty_slot);
                gui.setItem(1, elytra);
                gui.setItem(2, empty_slot);
                gui.setItem(3,sword);
                gui.setItem(4, empty_slot);
                gui.setItem(5, pickaxe);
                gui.setItem(6, empty_slot);
                gui.setItem(7,axe);
                gui.setItem(8, empty_slot);

                p.openInventory(gui);

                return true;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Tylko gracze mogą uzyc tej komendy!");
            return true;
        }

        return false;
    }

}
