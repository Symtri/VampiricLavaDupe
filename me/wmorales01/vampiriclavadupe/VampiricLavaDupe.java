/*    */ package me.wmorales01.vampiriclavadupe;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import me.wmorales01.vampiriclavadupe.commands.CommandCompleter;
/*    */ import me.wmorales01.vampiriclavadupe.commands.Commands;
/*    */ import me.wmorales01.vampiriclavadupe.commands.DropItem;
/*    */ import me.wmorales01.vampiriclavadupe.events.HopperPickUpItem;
/*    */ import me.wmorales01.vampiriclavadupe.events.ItemBurn;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.TabCompleter;
/*    */ import org.bukkit.entity.Item;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class VampiricLavaDupe extends JavaPlugin {
/* 18 */   public Map<Item, Player> droppers = new HashMap<>();
/*    */ 
/*    */   
/*    */   public void onEnable() {
/* 22 */     saveDefaultConfig();
/*    */     
/* 24 */     getCommand("vampiriclavadupe").setExecutor((CommandExecutor)new Commands(this));
/* 25 */     getCommand("vampiriclavadupe").setTabCompleter((TabCompleter)new CommandCompleter());
/* 26 */     getServer().getPluginManager().registerEvents((Listener)new DropItem(this), (Plugin)this);
/* 27 */     getServer().getPluginManager().registerEvents((Listener)new ItemBurn(), (Plugin)this);
/* 28 */     getServer().getPluginManager().registerEvents((Listener)new HopperPickUpItem(this), (Plugin)this);
/*    */   }
/*    */   
/*    */   public void onDisable() {}
/*    */ }


/* Location:              C:\Users\ckelm\Downloads\VampiricLavaDupe (8).jar!\me\wmorales01\vampiriclavadupe\VampiricLavaDupe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */