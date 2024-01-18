package fr.thegreensuits.viewing_party.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
  @EventHandler
  public void onBlockBreak(BlockBreakEvent event) {
    if(!event.getPlayer().isOp()) event.setCancelled(true);
  }
}