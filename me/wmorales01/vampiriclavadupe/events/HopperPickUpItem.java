/*    */ package me.wmorales01.vampiriclavadupe.events;
/*    */ 
/*    */ import me.wmorales01.vampiriclavadupe.VampiricLavaDupe;
/*    */ import me.wmorales01.vampiriclavadupe.commands.Commands;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.command.ConsoleCommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.inventory.InventoryPickupItemEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class HopperPickUpItem implements Listener {
/*    */   private VampiricLavaDupe plugin;
/*    */   
/*    */   public HopperPickUpItem(VampiricLavaDupe instance) {
/* 19 */     this.plugin = instance;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onPickUpItem(InventoryPickupItemEvent event) {
/* 24 */     if (event.getInventory().firstEmpty() == -1)
/*    */       return; 
/* 26 */     if (event.getItem().getFireTicks() <= 0) {
/*    */       return;
/*    */     }
/* 29 */     ItemStack item = event.getItem().getItemStack();
/* 30 */     if (item.getMaxStackSize() != 1) {
/* 31 */       item.setAmount(item.getAmount() * this.plugin.getConfig().getInt("item-multiplicator"));
/*    */     } else {
/* 33 */       event.getInventory().addItem(new ItemStack[] { item });
/*    */     } 
/* 35 */     if (!this.plugin.getConfig().getBoolean("notify-dupes"))
/*    */       return; 
/* 37 */     if (!this.plugin.droppers.containsKey(event.getItem())) {
/*    */       return;
/*    */     }
/* 40 */     Location location = event.getItem().getLocation();
/* 41 */     int x = (int)location.getX();
/* 42 */     int y = (int)location.getY();
/* 43 */     int z = (int)location.getZ();
/* 44 */     String world = location.getWorld().getName();
/* 45 */     String stringLocation = "&a&lX: " + x + " Y: " + y + " Z: " + z + " in " + world;
/* 46 */     String playerName = ((Player)this.plugin.droppers.get(event.getItem())).getDisplayName();
/* 47 */     ConsoleCommandSender sender = Bukkit.getConsoleSender();
/* 48 */     sender.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 49 */           String.valueOf(Commands.PREFIX) + "&a&l" + playerName + " &aduped &l" + item.toString() + " at " + stringLocation));
/* 50 */     this.plugin.droppers.remove(event.getItem());
/*    */   }
/*    */ }


/* Location:              C:\Users\ckelm\Downloads\VampiricLavaDupe (8).jar!\me\wmorales01\vampiriclavadupe\events\HopperPickUpItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */