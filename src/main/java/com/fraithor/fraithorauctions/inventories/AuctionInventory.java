package com.fraithor.fraithorauctions.inventories;

import com.fraithor.fraithorauctions.Util.auctiondata.AuctionInfo;
import com.fraithor.fraithorauctions.inventories.types.InvAuction;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;

public enum AuctionInventory {
    MAIN(new InvAuction());

    private final AuctionInv inv;

    AuctionInventory(AuctionInv inv) {
        this.inv = inv;
    }

    public AuctionInv get() {
        return inv;
    }

    public void click(InventoryClickEvent e) {
        inv.clickEvent(e);
    }

    public void open(Player p, List<AuctionInfo> auctionInfo) {
        if (inv instanceof AuctionInv_Auction)
            ((AuctionInv_Auction) inv).open(p, auctionInfo);
    }
}
