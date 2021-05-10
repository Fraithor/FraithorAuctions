package com.fraithor.fraithorauctions.Util.playerdata;

import com.fraithor.fraithorauctions.inventories.AuctionInventory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.Nullable;

public class PlayerData {

    private final Player p;
    private Inventory inventory;
    private AuctionInventory currentInv;

    PlayerData(Player p) {
        this.p = p;
    }

    //Inventory Menus
    public void setInventory(Inventory inv, AuctionInventory pinv, boolean from_command) {
        if (from_command)
            clear();
        inventory = inv;
        currentInv = pinv;
    }

    @Nullable
    public Inventory getInventory() {
        return inventory;
    }

    @Nullable
    public AuctionInventory getCurrent() {
        return currentInv;
    }

    public void clear() {
        inventory = null;
        currentInv = null;
    }
}
