package com.codebeasts.GUI4Pot;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
  private GUI gui;
  
  public void onEnable() {
    this.gui = new GUI(this);
    Bukkit.getServer().getPluginManager().registerEvents(this, this);
    
    }
  
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent e) {
    Action A = e.getAction();
    if ((A == Action.PHYSICAL) || (e.getItem() == null) || (e.getItem().getType() == Material.AIR)) {
      return;
      
    }
    
    if (e.getItem().getType() == Material.GLASS_BOTTLE) {
      this.gui.show(e.getPlayer());
      
    }
    
  }
  
}
