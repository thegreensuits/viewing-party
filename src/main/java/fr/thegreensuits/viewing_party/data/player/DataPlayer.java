package fr.thegreensuits.viewing_party.data.player;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import lombok.Getter;

public interface DataPlayer {
  public Player getBukkitPlayer();

  static class DataPlayerImpl implements DataPlayer {
    @Getter
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

      bukkitPlayer.setGameMode(GameMode.ADVENTURE);
      bukkitPlayer.teleport(bukkitPlayer.getWorld().getSpawnLocation());
    }
  }
}
