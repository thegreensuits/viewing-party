package fr.thegreensuits.viewing_party.data.player;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import fr.thegreensuits.viewing_party.Main;

public interface DataPlayer {
    public Player getBukkitPlayer();

    static class DataPlayerImpl implements DataPlayer {
        private Player bukkitPlayer;

        public DataPlayerImpl(Player bukkitPlayer) {
            super();

            this.bukkitPlayer = bukkitPlayer;

            initPlayer(bukkitPlayer.isOp());
        }

        private void initPlayer(Boolean isOp) {
            String color = isOp ? "§c" : "§7";

            bukkitPlayer.setDisplayName(String.format("%s%s", color, bukkitPlayer.getName()));
            bukkitPlayer.setPlayerListName(String.format("%s%s", color, bukkitPlayer.getName()));

            // - Stats
            if(!isOp) {
                bukkitPlayer.setGameMode(GameMode.ADVENTURE);
                bukkitPlayer.teleport(bukkitPlayer.getWorld().getSpawnLocation());
                bukkitPlayer.setBedSpawnLocation(bukkitPlayer.getWorld().getSpawnLocation(), true);
                bukkitPlayer.setHealth(20);
                bukkitPlayer.setFoodLevel(20);
                bukkitPlayer.setSaturation(20);
                bukkitPlayer.setExhaustion(0);
                bukkitPlayer.setFireTicks(0);
                bukkitPlayer.setFallDistance(0);
                bukkitPlayer.setExp(0);
                bukkitPlayer.setLevel(0);
                bukkitPlayer.setTotalExperience(0);
                bukkitPlayer.setWalkSpeed(0.2f);
                bukkitPlayer.setFlySpeed(0.1f);
                bukkitPlayer.setAllowFlight(false);
                bukkitPlayer.setFlying(false);
                bukkitPlayer.setCollidable(false);
                bukkitPlayer.setInvulnerable(true);
                bukkitPlayer.setGlowing(false);
                bukkitPlayer.setGliding(false);
            }

            // - Permissions
            this.givePermissionToPlayer("voicechat.listen", bukkitPlayer);
            this.givePermissionToPlayer("voicechat.speak", bukkitPlayer);
            this.givePermissionToPlayer("voicechat.groups", bukkitPlayer);
        }

        public void givePermissionToPlayer(String permission, Player player) {
            player.addAttachment(Main.INSTANCE, permission, true);
        }

        public void hasPermission(String permission, Player player) {
            player.hasPermission(permission);
        }

        public void removePermissionFromPlayer(String permission, Player player) {
            player.addAttachment(Main.INSTANCE, permission, false);
        }

		@Override
		public Player getBukkitPlayer() {
			return this.bukkitPlayer;
		}
    }
}
