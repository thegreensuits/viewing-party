package fr.thegreensuits.viewing_party.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {
  @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            if(event.getCause() == EntityDamageEvent.DamageCause.VOID)
                //Teleport to spawn when the player is too low
                event.getEntity().teleport(event.getEntity().getWorld().getSpawnLocation());

            if(!player.isOp()) {
                event.setCancelled(true);
            }
        }
    }
}
