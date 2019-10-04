package me.whoyou.losowanie;

import net.minecraft.server.v1_14_R1.IChatBaseComponent;
import net.minecraft.server.v1_14_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_14_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_14_R1.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_14_R1.PacketPlayOutWorldParticles;
import net.minecraft.server.v1_14_R1.PlayerConnection;
import org.bukkit.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.UUID;

public class Api {

    Main plugin;
    public Api(Main instance) {
        plugin = instance;
    }

    public Api() {
        plugin.loadConfiguration();
    }

    public boolean isPlayer(String namePlayer) {

        Player pToSearch = plugin.getServer().getPlayerExact(namePlayer);

        if(pToSearch != null) {
            return true;
        } else {
            return false;
        }
    }

    public Player getPlayer(String namePlayer) {
        Player p = plugin.getServer().getPlayerExact(namePlayer);

        if(p != null) {
            return p;
        } else {
            return null;
        }
    }

    public void addPlayerCoins(Player p, Integer coins) {
        if (plugin.getConfig().getString(p.getUniqueId().toString()) == null) return;

        int coins_old = plugin.getConfig().getInt(p.getUniqueId().toString());

        plugin.getConfig().set(p.getUniqueId().toString(), coins_old + coins);

        plugin.saveConfig();
        plugin.reloadConfig();
    }

    public void removePlayerCoins(Player p, Integer coinsToRemove) {
        if (plugin.getConfig().getString(p.getUniqueId().toString()) == null) return;

        int coins_old = plugin.getConfig().getInt(p.getUniqueId().toString());

        if(coins_old < coinsToRemove) {
            plugin.getConfig().set(p.getUniqueId().toString(), 0);
            return;
        }

        plugin.getConfig().set(p.getUniqueId().toString(), coins_old - coinsToRemove);

        plugin.saveConfig();
        plugin.reloadConfig();
    }

    public Integer getPlayerCoins(Player p) {
        plugin.saveConfig();
        plugin.reloadConfig();

        if (plugin.getConfig().getString(p.getUniqueId().toString()) == null) return 0;
        Integer coins = plugin.getConfig().getInt(p.getUniqueId().toString());
        return coins;
    }

    public void setPlayerCoins(Player p, Integer coins) {
        if (plugin.getConfig().getString(p.getUniqueId().toString()) == null) return;

        plugin.getConfig().set(p.getUniqueId().toString(),coins);

        plugin.saveConfig();
        plugin.reloadConfig();
    }

    public void refreshConfig() {
        plugin.saveConfig();
        plugin.reloadConfig();
    }

    public void sendTitle(Player p, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        CraftPlayer cp = (CraftPlayer) p;
        PlayerConnection connection = cp.getHandle().playerConnection;
        IChatBaseComponent titleJSON = ChatSerializer.a("{\"text\":\"" + title + "\"}");
        IChatBaseComponent subtitleJSON = ChatSerializer.a("{\"text\":\"" + subtitle +"\"}");
        PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(EnumTitleAction.TITLE, titleJSON, fadeIn, stay, fadeOut);
        PacketPlayOutTitle subtitlePackiet = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, subtitleJSON);
        connection.sendPacket(titlePacket);
        connection.sendPacket(subtitlePackiet);
    }

    public void playEffect(Player p, Color color) {
        Firework f = p.getWorld().spawn(p.getLocation(), Firework.class);
        FireworkMeta data = f.getFireworkMeta();
        data.addEffects(FireworkEffect.builder().withColor(color).with(FireworkEffect.Type.BALL_LARGE).build());
        data.setPower(2);
        f.setFireworkMeta(data);
    }


    public String item_name_polish(Integer amount, String one_item, String more_items) {
        String name;
        if(amount == 1) {
            name = one_item;
        } else if(amount > 1) {
            name = more_items;
        } else {
            name = ChatColor.RED + "Błąd!";
        }

        return name;
    }


    public boolean isNumber(String str) {
        try {
            Integer i = Integer.parseInt(str);
            if(i <= 1000000) {
                return true;
            } else {
                return false;
            }
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public Integer getNumber(String str) {
        try {
            Integer i = Integer.parseInt(str);
            return i;
        } catch(NumberFormatException e) {
            return 0;
        }
    }

}
