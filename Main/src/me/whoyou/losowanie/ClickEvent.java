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

        if (!(e.getClickedInventory() == e.getView().getTopInventory())) return;

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
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Turbo kozacki diamentowy miecz")) {

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

            Buy(p, 15000, sword, "Turbo kozacki miecz", ChatColor.BLUE);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Turbo kozacki diamentowy kilof")) {

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

            Buy(p, 15000, pickaxe, "Turbo kozacki kilof", ChatColor.BLUE);

        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Turbo kozacka diamentowa siekiera")) {

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
            Buy(p, 15000, axe, "Turbo kozacka siekiera", ChatColor.BLUE);
        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Kozak jabłko")) {
            ItemStack enchanted_golden_apple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);

            ItemMeta enchanted_golden_apple_meta = enchanted_golden_apple.getItemMeta();
            enchanted_golden_apple_meta.setDisplayName(ChatColor.GOLD + "Kozak jabłko");
            enchanted_golden_apple.setItemMeta(enchanted_golden_apple_meta);
            Buy(p, 9999, enchanted_golden_apple,"Kozak jabłko", ChatColor.GOLD);

        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Turbo kozacki żelazny miecz")) {

            ItemStack iron_sword = new ItemStack(Material.IRON_SWORD);

            ItemMeta iron_sword_meta = iron_sword.getItemMeta();
            iron_sword_meta.setDisplayName(ChatColor.BLUE + "Turbo kozacki żelazny miecz");
            iron_sword_meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 2, true);
            iron_sword_meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            iron_sword_meta.addEnchant(Enchantment.SWEEPING_EDGE, 1, true);
            iron_sword.setItemMeta(iron_sword_meta);

            Buy(p, 7500, iron_sword,"Turbo kozacki żelazny miecz", ChatColor.BLUE);

        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Turbo kozacki żelazny kilof")) {

            ItemStack iron_pickaxe = new ItemStack(Material.IRON_PICKAXE);

            ItemMeta iron_pickaxe_meta = iron_pickaxe.getItemMeta();
            iron_pickaxe_meta.setDisplayName(ChatColor.BLUE + "Turbo kozacki żelazny kilof");
            iron_pickaxe_meta.addEnchant(Enchantment.DIG_SPEED, 2, true);
            iron_pickaxe_meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
            iron_pickaxe_meta.addEnchant(Enchantment.DURABILITY, 1, true);
            iron_pickaxe.setItemMeta(iron_pickaxe_meta);

            Buy(p, 7500, iron_pickaxe,"Turbo kozacki żelazny kilof", ChatColor.BLUE);

        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Turbo kozacka żelazna siekiera")) {

            ItemStack iron_axe = new ItemStack(Material.IRON_AXE);

            ItemMeta iron_axe_meta = iron_axe.getItemMeta();
            iron_axe_meta.setDisplayName(ChatColor.BLUE + "Turbo kozacka żelazna siekiera");
            iron_axe_meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
            //iron_axe_meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
            iron_axe_meta.addEnchant(Enchantment.DURABILITY, 1, true);
            iron_axe_meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            iron_axe.setItemMeta(iron_axe_meta);

            Buy(p, 7500, iron_axe,"Turbo kozacka żelazna siekiera", ChatColor.BLUE);

        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Wieprzowina")) {

            ItemStack steaks = new ItemStack(Material.COOKED_PORKCHOP, 16);

            ItemMeta steaks_meta = steaks.getItemMeta();
            steaks_meta.setDisplayName(ChatColor.BLUE + "Wieprzowina");
            steaks.setItemMeta(steaks_meta);

            Buy(p, 500, steaks,"Wieprzowina", ChatColor.BLUE);

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
























