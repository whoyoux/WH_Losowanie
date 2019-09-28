package me.whoyou.losowanie;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.border.TitledBorder;
import java.util.ArrayList;

public class ClickEvent implements Listener {

    String name_inv = "Kupno";

    public static Api api;

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if(e.getView().getTitle() != name_inv) return;

        //e.getCurrentItem().equals(e.getView().getTopInventory().getContents());


            //if (e.getClickedInventory().equals(e.getView().getTopInventory())) {

                e.setCancelled(true);

                if (e.getCurrentItem() == null) return;

                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "ELYTRA")) {
                    ItemStack elytra = new ItemStack(Material.ELYTRA);
                    ItemMeta elytra_meta = elytra.getItemMeta();
                    elytra_meta.setDisplayName(ChatColor.ITALIC + (ChatColor.GOLD + "ELYTRA"));
                    //ArrayList<String> hydra_lore = new ArrayList();
                    //hydra_lore.add(ChatColor.GRAY + "Koszt: " + ChatColor.RED + "99999 coins");
                    //elytra_meta.setLore(hydra_lore);
                    elytra.setItemMeta(elytra_meta);

                    Buy(p, 99999, elytra, "ELYTRE", ChatColor.GOLD);
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Turbo kozacki miecz")) {

                    ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);

                    ItemMeta sword_meta = sword.getItemMeta();
                    sword_meta.setDisplayName(ChatColor.BLUE + "Turbo kozacki miecz");
                    sword_meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
                    sword_meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
                    sword_meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
                    sword_meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                    sword_meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 5, true);
                    sword_meta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
                    //ArrayList<String> sword_lore = new ArrayList<>();
                    //sword_lore.add(ChatColor.GRAY + "10000 coins");
                    //sword_meta.setLore(sword_lore);
                    sword.setItemMeta(sword_meta);

                    Buy(p, 10000, sword, "Turbo kozacki miecz", ChatColor.BLUE);
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Turbo kozacki kilof")) {

                    ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);

                    ItemMeta pickaxe_meta = pickaxe.getItemMeta();
                    pickaxe_meta.setDisplayName(ChatColor.BLUE + "Turbo kozacki kilof");
                    pickaxe_meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
                    pickaxe_meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
                    pickaxe_meta.addEnchant(Enchantment.DURABILITY, 3, true);
                    //ArrayList<String> pickaxe_lore = new ArrayList<>();
                    //pickaxe_lore.add("");
                    //pickaxe_lore.add(ChatColor.GRAY + "Koszt: " + ChatColor.RED + "8000 coins");
                    //pickaxe_meta.setLore(pickaxe_lore);
                    pickaxe.setItemMeta(pickaxe_meta);

                    Buy(p, 8000, pickaxe, "Turbo kozacki kilof", ChatColor.BLUE);

                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Turbo kozacka siekiera")) {

                    ItemStack axe = new ItemStack(Material.DIAMOND_AXE);

                    ItemMeta axe_meta = axe.getItemMeta();
                    axe_meta.setDisplayName(ChatColor.BLUE + "Turbo kozacka siekiera");
                    axe_meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
                    axe_meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
                    axe_meta.addEnchant(Enchantment.DURABILITY, 3, true);
                    axe_meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                    //ArrayList<String> axe_lore = new ArrayList<>();
                    //axe_lore.add("");
                    //axe_lore.add(ChatColor.RED + "8000 coins");
                    //axe_meta.setLore(axe_lore);
                    axe.setItemMeta(axe_meta);

                    e.setCancelled(true);
                    Buy(p, 8000, axe, "Turbo kozacka siekiera", ChatColor.BLUE);
                }

    }

    public void Buy(Player p, Integer coins, ItemStack item, String name , ChatColor chatColor) {
        Integer p_coins = api.getPlayerCoins(p);
        if(p_coins >= coins) {
            api.removePlayerCoins(p,coins);
            p.sendMessage(ChatColor.GRAY + "Kupiłeś właśnie " + chatColor + name + ChatColor.GRAY + " za: " + ChatColor.YELLOW + coins.toString() + " coinsów!");
            p.getInventory().addItem(item);
        } else {
            p.sendMessage(ChatColor.RED + "Nie masz wystarczająco dużej ilości coinsów!");
        }
    }

}
























