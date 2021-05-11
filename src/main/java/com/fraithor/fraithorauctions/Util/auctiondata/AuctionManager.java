package com.fraithor.fraithorauctions.Util.auctiondata;

import com.fraithor.fraithorauctions.Util.File.FileBasics;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AuctionManager {

    List<AuctionInfo> auctions = new ArrayList<>();
    ConfigurationSection file = FileBasics.FILETYPE.AUCTIONS.getConfigurationSection("ongoing");

    public void load() {
        //LOAD ALL AUCTION DATA INTO "auctions"

         for (String ongoing : file.getKeys(true)) {
             int price = file.getInt("Price");
             ItemStack item = file.getItemStack("Item");
             auctions.add(new AuctionInfo(price, item));
         }
    }

    public List<AuctionInfo> getAll() {
        return auctions;
    }
}
