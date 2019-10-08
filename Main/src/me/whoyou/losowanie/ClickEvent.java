package me.whoyou.losowanie;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClickEvent implements Listener {

    public static Api api;

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if(e.getView().getTitle() != "Sklep") return;

        if (!(e.getClickedInventory() == e.getView().getTopInventory())) return;

        e.setCancelled(true);

        if (e.getCurrentItem() == null) return;

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + api.getString("elytra"))) {
            ItemStack elytra = new ItemStack(Material.ELYTRA);
            ItemMeta elytra_meta = elytra.getItemMeta();
            elytra_meta.setDisplayName(ChatColor.GOLD + "");
            elytra.setItemMeta(elytra_meta);

            Buy(p, 99999, elytra, api.getString("elytra"), ChatColor.GOLD);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + api.getString("diamond_sword"))) {

            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);

            ItemMeta sword_meta = sword.getItemMeta();
            sword_meta.setDisplayName(ChatColor.BLUE + api.getString("diamond_sword"));
            sword_meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
            sword_meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
            sword_meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
            sword_meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            sword_meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 5, true);
            sword_meta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
            sword.setItemMeta(sword_meta);

            Buy(p, 15000, sword, api.getString("diamond_sword"), ChatColor.BLUE);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + api.getString("diamond_pickaxe"))) {

            ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);

            ItemMeta pickaxe_meta = pickaxe.getItemMeta();
            pickaxe_meta.setDisplayName(ChatColor.BLUE + api.getString("diamond_pickaxe"));
            pickaxe_meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
            pickaxe_meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
            pickaxe_meta.addEnchant(Enchantment.DURABILITY, 3, true);
            pickaxe.setItemMeta(pickaxe_meta);

            Buy(p, 15000, pickaxe, api.getString("diamond_pickaxe"), ChatColor.BLUE);

        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + api.getString("diamond_axe"))) {

            ItemStack axe = new ItemStack(Material.DIAMOND_AXE);

            ItemMeta axe_meta = axe.getItemMeta();
            axe_meta.setDisplayName(ChatColor.BLUE + api.getString("diamond_axe"));
            axe_meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
            axe_meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
            axe_meta.addEnchant(Enchantment.DURABILITY, 3, true);
            axe_meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            axe.setItemMeta(axe_meta);

            e.setCancelled(true);
            Buy(p, 15000, axe, api.getString("diamond_axe"), ChatColor.BLUE);
        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + api.getString("golden_apples"))) {
            ItemStack enchanted_golden_apple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);

            ItemMeta enchanted_golden_apple_meta = enchanted_golden_apple.getItemMeta();
            enchanted_golden_apple_meta.setDisplayName(ChatColor.GOLD + api.getString("golden_apples"));
            enchanted_golden_apple.setItemMeta(enchanted_golden_apple_meta);
            Buy(p, 9999, enchanted_golden_apple,api.getString("golden_apples"), ChatColor.GOLD);

        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + api.getString("iron_sword"))) {

            ItemStack iron_sword = new ItemStack(Material.IRON_SWORD);

            ItemMeta iron_sword_meta = iron_sword.getItemMeta();
            iron_sword_meta.setDisplayName(ChatColor.BLUE + api.getString("iron_sword"));
            iron_sword_meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 2, true);
            iron_sword_meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            iron_sword_meta.addEnchant(Enchantment.SWEEPING_EDGE, 1, true);
            iron_sword.setItemMeta(iron_sword_meta);

            Buy(p, 7500, iron_sword,api.getString("iron_sword"), ChatColor.BLUE);

        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + api.getString("iron_pickaxe"))) {

            ItemStack iron_pickaxe = new ItemStack(Material.IRON_PICKAXE);

            ItemMeta iron_pickaxe_meta = iron_pickaxe.getItemMeta();
            iron_pickaxe_meta.setDisplayName(ChatColor.BLUE + api.getString("iron_pickaxe"));
            iron_pickaxe_meta.addEnchant(Enchantment.DIG_SPEED, 2, true);
            iron_pickaxe_meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
            iron_pickaxe_meta.addEnchant(Enchantment.DURABILITY, 1, true);
            iron_pickaxe.setItemMeta(iron_pickaxe_meta);

            Buy(p, 7500, iron_pickaxe,api.getString("iron_pickaxe"), ChatColor.BLUE);

        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + api.getString("iron_axe"))) {

            ItemStack iron_axe = new ItemStack(Material.IRON_AXE);

            ItemMeta iron_axe_meta = iron_axe.getItemMeta();
            iron_axe_meta.setDisplayName(ChatColor.BLUE + api.getString("iron_axe"));
            iron_axe_meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
            iron_axe_meta.addEnchant(Enchantment.DURABILITY, 1, true);
            iron_axe_meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            iron_axe.setItemMeta(iron_axe_meta);

            Buy(p, 7500, iron_axe,api.getString("iron_axe"), ChatColor.BLUE);

        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + api.getString("porks"))) {

            ItemStack steaks = new ItemStack(Material.COOKED_PORKCHOP, 16);

            ItemMeta steaks_meta = steaks.getItemMeta();
            steaks_meta.setDisplayName(ChatColor.BLUE + api.getString("porks"));
            steaks.setItemMeta(steaks_meta);

            Buy(p, 500, steaks,api.getString("porks"), ChatColor.BLUE);

        }

    }

    public void Buy(Player p, Integer coins, ItemStack item, String name , ChatColor chatColor) {
        Integer p_coins = api.getPlayerCoins(p);
        if(p_coins >= coins) {
            api.removePlayerCoins(p,coins);
            p.sendMessage(ChatColor.GRAY + api.getString("just_buy") + " " + chatColor + name + ChatColor.GRAY + " " + api.getString("for") + ": " + ChatColor.YELLOW + coins.toString() + " " + api.getString("coins") + "!");
            p.getInventory().addItem(item);
        } else {
            p.sendMessage(ChatColor.RED + api.getString("dont_have_money"));
        }
    }

}
























