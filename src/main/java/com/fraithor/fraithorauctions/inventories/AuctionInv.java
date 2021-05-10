package com.fraithor.fraithorauctions.inventories;

import com.fraithor.fraithorauctions.FraithorAuctions;
import org.bukkit.event.inventory.InventoryClickEvent;

public interface AuctionInv {

    default FraithorAuctions getPl() {
        return FraithorAuctions.getInstance();
    }

    void clickEvent(InventoryClickEvent e);
}
