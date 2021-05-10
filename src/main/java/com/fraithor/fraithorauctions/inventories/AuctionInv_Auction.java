package com.fraithor.fraithorauctions.inventories;

import com.fraithor.fraithorauctions.Util.auctiondata.AuctionInfo;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.List;

public interface AuctionInv_Auction extends AuctionInv {

    Inventory open(Player p, List<AuctionInfo> auctions);

}
