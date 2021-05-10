package com.fraithor.fraithorauctions.Util;

import com.fraithor.fraithorauctions.Util.File.FileBasics;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class AuctionGUI {

    private Inventory inv;
    private ArrayList<String> ongoing = (ArrayList<String>) FileBasics.FILETYPE.AUCTIONS.getStringList("Ongoing");

    public AuctionGUI() {
        inv = Bukkit.createInventory(null, 9, "Auction house");
        //initializeItems();
    }

    /*STUCK HERE
    private void initializeItems() {
        for (ongoing og: )
    }
    */
}
