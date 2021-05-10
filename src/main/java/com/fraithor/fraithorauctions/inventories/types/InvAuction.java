package com.fraithor.fraithorauctions.inventories.types;

import com.fraithor.fraithorauctions.Util.auctiondata.AuctionInfo;
import com.fraithor.fraithorauctions.inventories.AuctionInvLoader;
import com.fraithor.fraithorauctions.inventories.AuctionInv_Auction;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class InvAuction extends AuctionInvLoader implements AuctionInv_Auction {

    @Override
    public Inventory open(Player p, List<AuctionInfo> auctions) {
        Inventory inv = Bukkit.createInventory(null, 9 * 6, getTitle(p, null));

        //--
        //for loop to display all auction items
        //--

        for (ITEMS _i : ITEMS.values()) {
            ItemStack item = getItem(_i.section, p, null);
            int slot = inv.firstEmpty();
            inv.setItem(slot, item);
        }

        p.openInventory(inv);
        return null;
    }

    @Override
    public void clickEvent(InventoryClickEvent e) {
        //Called when this inventory is clicked
    }

    @Override
    protected String getSection() {
        return "MainPage";
    }

    @Override
    protected @Nullable List<String> getSections() {
        List<String> list = new ArrayList<>();
        for (ITEMS _i : ITEMS.values())
            list.add(_i.section);
        return list;
    }

    private enum ITEMS {
        BANK("Bank", 53);

        String section;
        int slot;

        ITEMS(String section, int slot) {
            this.section = section;
        }
    }
}
