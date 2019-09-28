package me.whoyou.losowanie;

import javafx.collections.SetChangeListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    private Api api;

    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "\nRuletka zostala wlaczona!");

        loadConfiguration();

        getCommand("bet").setExecutor((CommandExecutor) new Bet());
        getCommand("saldo").setExecutor((CommandExecutor) new Saldo());
        getCommand("setcoins").setExecutor((CommandExecutor) new Setcoins());
        getCommand("kup").setExecutor((CommandExecutor) new Kup());

        api = new Api(this);
        Bet.api = new Api(this);
        Saldo.api = new Api(this);
        Setcoins.api = new Api(this);
        Kup.api = new Api(this);
        ClickEvent.api = new Api(this);
        getServer().getPluginManager().registerEvents(this,this);
        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "\nRuletka zostala wylaczona!");
    }

    public void loadConfiguration() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }


    @EventHandler
    public void addPlayerToConfigFile(PlayerJoinEvent playerJoinEvent) {
        Player p = playerJoinEvent.getPlayer();
        String namePlayer = p.getName();
        p.sendMessage(namePlayer);

        if (getConfig().getString(p.getUniqueId().toString()) == null) {
            getConfig().set(p.getUniqueId().toString(), 25);
            saveConfig();
        }

    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        if(e.getEntity() instanceof Monster) {
            Monster monsterEnt = (Monster) e.getEntity();
            Player player = monsterEnt.getKiller();
            if(player == null) {
                return;
            }
            player.sendMessage(ChatColor.GRAY + "Właśnie zabiłeś " + ChatColor.RED + "moba" + ChatColor.GRAY +"! Dostajesz " + ChatColor.RED + "3" + ChatColor.GRAY + " punkty!");
            api.addPlayerCoins(player,3);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Block block = e.getBlock();
        Player p = e.getPlayer();

        if(block.getType().equals(Material.COAL_ORE)) {
            p.sendMessage(ChatColor.GRAY + "Właśnie rozbiłeś rudę " + ChatColor.DARK_GRAY + "węgla" + ChatColor.GRAY + "! Dostajesz " + ChatColor.RED + "2" + ChatColor.GRAY + " punkt!");
            api.addPlayerCoins(p,2);
        }

      //  if(block.getType().equals(Material.IRON_ORE)) {
      //      p.sendMessage(ChatColor.GRAY + "Właśnie rozbiłeś rudę " + ChatColor.DARK_GRAY + "żelaza" + ChatColor.GRAY + "! Dostajesz " + ChatColor.RED + "2" + ChatColor.GRAY + " punktów!");
      //      api.addPlayerCoins(p,2);
     //  }

      //  if(block.getType().equals(Material.REDSTONE_ORE)) {
      //      p.sendMessage(ChatColor.GRAY + "Właśnie rozbiłeś rudę " + ChatColor.DARK_RED + "redstone'u" + ChatColor.GRAY + "! Dostajesz " + ChatColor.RED + "3" + ChatColor.GRAY + " punktów!");
      //      api.addPlayerCoins(p,3);
      //  }

        if(block.getType().equals(Material.LAPIS_ORE)) {
              p.sendMessage(ChatColor.GRAY + "Właśnie rozbiłeś rudę " + ChatColor.DARK_BLUE + "lapis'u" + ChatColor.GRAY + "! Dostajesz " + ChatColor.RED + "3" + ChatColor.GRAY + " punktów!");
              api.addPlayerCoins(p,3);
          }

        if(block.getType().equals(Material.EMERALD_ORE)) {
            p.sendMessage(ChatColor.GRAY + "Właśnie rozbiłeś rudę " + ChatColor.DARK_GREEN + "emeralda" + ChatColor.GRAY + "! Dostajesz " + ChatColor.RED + "7" + ChatColor.GRAY + " punktów!");
            api.addPlayerCoins(p,7);
        }

        if(block.getType().equals(Material.DIAMOND_ORE)) {
            p.sendMessage(ChatColor.GRAY + "Właśnie rozbiłeś rudę " + ChatColor.BLUE + "diamentu" + ChatColor.GRAY + "! Dostajesz " + ChatColor.RED + "5" + ChatColor.GRAY + " punktów!");
            api.addPlayerCoins(p,5);
        }
    }
}


// KOMENDA BEDZIE TAK WYGLADAC: /bet 50
//                              /bet ilość_pieniędzy
// POZNIEJ WYSKOCZY OKIENKO DO WYBORU
// PO PARU SEKUNDACH NA CHACIE POKAZE SIE TAK:
//      - WIN:  Wygrałeś XXX! Gratulacje!
//      - LOSE: Przegrałeś XXX.