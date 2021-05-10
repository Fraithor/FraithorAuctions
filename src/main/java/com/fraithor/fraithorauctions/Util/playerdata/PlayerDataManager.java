package com.fraithor.fraithorauctions.Util.playerdata;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerDataManager {

    private final HashMap<Player, PlayerData> playerData = new HashMap<>();

    public PlayerData getData(Player p) {
        if (!playerData.containsKey(p))
            playerData.put(p, new PlayerData(p));
        return playerData.get(p);
    }

    public void clear() {
        playerData.clear();
    }
}
