package fr.thegreensuits.viewing_party.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;

public class EntityInteractListener implements Listener {
  @EventHandler
  public void onEntityInteract(EntityInteractEvent event) {
    if(!event.getEntity().isOp()) event.setCancelled(true);
  }
}