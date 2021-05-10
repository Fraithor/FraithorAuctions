package com.fraithor.fraithorauctions.Util.auctiondata;

import org.bukkit.inventory.ItemStack;

public class AuctionInfo {

    public final int price;
    public final ItemStack item;

    AuctionInfo(int price, ItemStack item) {
        this.price = price;
        this.item = item;
    }
}
