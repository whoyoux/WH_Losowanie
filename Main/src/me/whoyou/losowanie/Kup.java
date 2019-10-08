package me.whoyou.losowanie;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Kup implements CommandExecutor {

    public static Api api;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(command.getName().equalsIgnoreCase("kup")) {
                Player p = (Player) sender;

                if(!(args.length == 0)) {
                    p.sendMessage(ChatColor.RED + api.getString("error_args"));
                    p.sendMessage(ChatColor.RED + api.getString("usage_kup"));
                    return true;
                }

                Inventory gui = Bukkit.createInventory(p,27, "Sklep");

                ItemStack empty_slot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);

                ItemStack elytra = new ItemStack(Material.ELYTRA);

                ItemMeta elytra_meta = elytra.getItemMeta();
                elytra_meta.setDisplayName(ChatColor.GOLD + api.getString("elytra"));
                ArrayList<String> elytra_lore = new ArrayList();
                elytra_lore.add(ChatColor.GRAY + api.getString("price") + ": " + ChatColor.RED + "999 999 coins");
                elytra_meta.setLore(elytra_lore);
                elytra.setItemMeta(elytra_meta);

                ItemStack diamond_sword = new ItemStack(Material.DIAMOND_SWORD);

                ItemMeta diamond_sword_meta = diamond_sword.getItemMeta();
                diamond_sword_meta.setDisplayName(ChatColor.BLUE + api.getString("diamond_sword"));
                diamond_sword_meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
                diamond_sword_meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
                diamond_sword_meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
                diamond_sword_meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                diamond_sword_meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 5, true);
                diamond_sword_meta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
                ArrayList<String> diamond_sword_lore = new ArrayList<>();
                diamond_sword_lore.add("");
                diamond_sword_lore.add(ChatColor.GRAY + api.getString("price") + ": " + ChatColor.RED + "15 000 coins");
                diamond_sword_meta.setLore(diamond_sword_lore);
                diamond_sword.setItemMeta(diamond_sword_meta);

                ItemStack diamond_pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);

                ItemMeta diamond_pickaxe_meta = diamond_pickaxe.getItemMeta();
                diamond_pickaxe_meta.setDisplayName(ChatColor.BLUE + api.getString("diamond_pickaxe"));
                diamond_pickaxe_meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
                diamond_pickaxe_meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
                diamond_pickaxe_meta.addEnchant(Enchantment.DURABILITY, 3, true);
                ArrayList<String> diamond_pickaxe_lore = new ArrayList<>();
                diamond_pickaxe_lore.add("");
                diamond_pickaxe_lore.add(ChatColor.GRAY + api.getString("price") + ": " + ChatColor.RED + "15 000 coins");
                diamond_pickaxe_meta.setLore(diamond_pickaxe_lore);
                diamond_pickaxe.setItemMeta(diamond_pickaxe_meta);

                ItemStack diamond_axe = new ItemStack(Material.DIAMOND_AXE);

                ItemMeta diamond_axe_meta = diamond_axe.getItemMeta();
                diamond_axe_meta.setDisplayName(ChatColor.BLUE + api.getString("diamond_axe"));
                diamond_axe_meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
                diamond_axe_meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
                diamond_axe_meta.addEnchant(Enchantment.DURABILITY, 3, true);
                diamond_axe_meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                ArrayList<String> diamond_axe_lore = new ArrayList<>();
                diamond_axe_lore.add("");
                diamond_axe_lore.add(ChatColor.GRAY + api.getString("price") + ": " + ChatColor.RED + "15000 coins");
                diamond_axe_meta.setLore(diamond_axe_lore);
                diamond_axe.setItemMeta(diamond_axe_meta);

                ItemStack enchanted_golden_apple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);

                ItemMeta enchanted_golden_apple_meta = enchanted_golden_apple.getItemMeta();
                enchanted_golden_apple_meta.setDisplayName(ChatColor.GOLD + api.getString("golden_apples"));
                ArrayList<String> enchanted_golden_apple_lore = new ArrayList<>();
                enchanted_golden_apple_lore.add("");
                enchanted_golden_apple_lore.add(ChatColor.GRAY + api.getString("price") + ": " + ChatColor.RED + "9 999 coins");
                enchanted_golden_apple_meta.setLore(enchanted_golden_apple_lore);
                enchanted_golden_apple.setItemMeta(enchanted_golden_apple_meta);

                ItemStack iron_sword = new ItemStack(Material.IRON_SWORD);

                ItemMeta iron_sword_meta = iron_sword.getItemMeta();
                iron_sword_meta.setDisplayName(ChatColor.BLUE + api.getString("iron_sword"));
                iron_sword_meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 2, true);
                iron_sword_meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                iron_sword_meta.addEnchant(Enchantment.SWEEPING_EDGE, 1, true);
                ArrayList<String> iron_sword_lore = new ArrayList<>();
                iron_sword_lore.add("");
                iron_sword_lore.add(ChatColor.GRAY + api.getString("price") + ": " + ChatColor.RED + "7 500 coins");
                iron_sword_meta.setLore(iron_sword_lore);
                iron_sword.setItemMeta(iron_sword_meta);

                ItemStack iron_pickaxe = new ItemStack(Material.IRON_PICKAXE);

                ItemMeta iron_pickaxe_meta = iron_pickaxe.getItemMeta();
                iron_pickaxe_meta.setDisplayName(ChatColor.BLUE + api.getString("diamond_pickaxe"));
                iron_pickaxe_meta.addEnchant(Enchantment.DIG_SPEED, 2, true);
                iron_pickaxe_meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                iron_pickaxe_meta.addEnchant(Enchantment.DURABILITY, 1, true);
                ArrayList<String> iron_pickaxe_lore = new ArrayList<>();
                iron_pickaxe_lore.add("");
                iron_pickaxe_lore.add(ChatColor.GRAY + api.getString("price") + ": " + ChatColor.RED + "7 500 coins");
                iron_pickaxe_meta.setLore(iron_pickaxe_lore);
                iron_pickaxe.setItemMeta(iron_pickaxe_meta);


                ItemStack iron_axe = new ItemStack(Material.IRON_AXE);

                ItemMeta iron_axe_meta = iron_axe.getItemMeta();
                iron_axe_meta.setDisplayName(ChatColor.BLUE + api.getString("diamond_axe"));
                iron_axe_meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
                //iron_axe_meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
                iron_axe_meta.addEnchant(Enchantment.DURABILITY, 1, true);
                iron_axe_meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                ArrayList<String> iron_axe_lore = new ArrayList<>();
                iron_axe_lore.add("");
                iron_axe_lore.add(ChatColor.GRAY + api.getString("price") + ": " + ChatColor.RED + "7 500 coins");
                iron_axe_meta.setLore(iron_axe_lore);
                iron_axe.setItemMeta(iron_axe_meta);



                ItemStack steaks = new ItemStack(Material.COOKED_PORKCHOP, 16);

                ItemMeta steaks_meta = steaks.getItemMeta();
                steaks_meta.setDisplayName(ChatColor.BLUE + api.getString("porks"));
                ArrayList<String> steaks_lore = new ArrayList<>();
                steaks_lore.add("");
                steaks_lore.add(ChatColor.GRAY + api.getString("price") + ": " + ChatColor.RED + " 500 coins");
                steaks_meta.setLore(steaks_lore);
                steaks.setItemMeta(steaks_meta);


                //gui.addItem(hydra,sword,pickaxe,axe);
                gui.setItem(0, empty_slot);
                gui.setItem(1, elytra);
                gui.setItem(2, empty_slot);
                gui.setItem(3, diamond_sword);
                gui.setItem(4, empty_slot);
                gui.setItem(5, diamond_pickaxe);
                gui.setItem(6, empty_slot);
                gui.setItem(7, diamond_axe);
                gui.setItem(8, empty_slot);
                gui.setItem(9, empty_slot);
                gui.setItem(10, enchanted_golden_apple);
                gui.setItem(11, empty_slot);
                gui.setItem(12, iron_sword);
                gui.setItem(13, empty_slot);
                gui.setItem(14, iron_pickaxe);
                gui.setItem(15, empty_slot);
                gui.setItem(16, iron_axe);
                gui.setItem(17, empty_slot);
                gui.setItem(18, empty_slot);
                gui.setItem(19, steaks);
                gui.setItem(20, empty_slot);
                gui.setItem(21, empty_slot);
                gui.setItem(22, empty_slot);
                gui.setItem(23, empty_slot);
                gui.setItem(24, empty_slot);
                gui.setItem(25, empty_slot);
                gui.setItem(26, empty_slot);

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
