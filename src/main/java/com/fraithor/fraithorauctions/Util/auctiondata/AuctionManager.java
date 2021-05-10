package com.fraithor.fraithorauctions.Util.auctiondata;

import java.util.ArrayList;
import java.util.List;

public class AuctionManager {

    List<AuctionInfo> auctions = new ArrayList<>();

    public void load() {
        //LOAD ALL AUCTION DATA INTO "auctions"
        //
        // for (String path : values) {
        //     int price = file.getInt("Price");
        //     ItemStack item = file.getItemStack("Item");
        //     auctions.add(new AuctionInfo(price, item);
        // }
    }

    public List<AuctionInfo> getAll() {
        return auctions;
    }
}
