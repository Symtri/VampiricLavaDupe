/*    */ package me.wmorales01.vampiriclavadupe.commands;
/*    */ 
/*    */ import me.wmorales01.vampiriclavadupe.VampiricLavaDupe;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerDropItemEvent;
/*    */ 
/*    */ public class DropItem
/*    */   implements Listener {
/*    */   private VampiricLavaDupe plugin;
/*    */   
/*    */   public DropItem(VampiricLavaDupe instance) {
/* 13 */     this.plugin = instance;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onItemDrop(PlayerDropItemEvent event) {
/* 18 */     this.plugin.droppers.put(event.getItemDrop(), event.getPlayer());
/*    */   }
/*    */ }


/* Location:              C:\Users\ckelm\Downloads\VampiricLavaDupe (8).jar!\me\wmorales01\vampiriclavadupe\commands\DropItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */