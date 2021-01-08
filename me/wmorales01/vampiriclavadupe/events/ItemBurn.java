/*    */ package me.wmorales01.vampiriclavadupe.events;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Item;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ 
/*    */ 
/*    */ public class ItemBurn
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onItemBurn(EntityDamageEvent event) {
/* 19 */     if (!(event.getEntity() instanceof Item))
/*    */       return; 
/* 21 */     if (!event.getCause().equals(EntityDamageEvent.DamageCause.FIRE) && !event.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK) && 
/* 22 */       !event.getCause().equals(EntityDamageEvent.DamageCause.LAVA))
/*    */       return; 
/* 24 */     Item item = (Item)event.getEntity();
/* 25 */     Location location = item.getLocation();
/* 26 */     List<Block> blocks = getNearbyBlocks(location, 5);
/* 27 */     boolean hasHopperNear = false;
/* 28 */     for (Block block : blocks) {
/* 29 */       if (!block.getType().equals(Material.HOPPER))
/*    */         continue; 
/* 31 */       hasHopperNear = true;
/*    */       break;
/*    */     } 
/* 34 */     if (!hasHopperNear)
/*    */       return; 
/* 36 */     event.setCancelled(true);
/*    */   }
/*    */   
/*    */   private List<Block> getNearbyBlocks(Location location, int radius) {
/* 40 */     List<Block> blocks = new ArrayList<>();
/* 41 */     for (int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
/* 42 */       for (int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
/* 43 */         for (int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
/* 44 */           blocks.add(location.getWorld().getBlockAt(x, y, z));
/*    */         }
/*    */       } 
/*    */     } 
/* 48 */     return blocks;
/*    */   }
/*    */ }


/* Location:              C:\Users\ckelm\Downloads\VampiricLavaDupe (8).jar!\me\wmorales01\vampiriclavadupe\events\ItemBurn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */