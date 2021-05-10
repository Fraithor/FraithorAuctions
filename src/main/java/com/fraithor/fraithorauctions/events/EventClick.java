package com.fraithor.fraithorauctions.events;

import com.fraithor.fraithorauctions.FraithorAuctions;
import com.fraithor.fraithorauctions.inventories.AuctionInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class EventClick {

    void click(InventoryClickEvent e) {
        //System.out.println("Move event2");
        if (!validClick(e))
            return;
        e.setCancelled(true);
        AuctionInventory inventory = FraithorAuctions.getInstance().getPlayerData((Player) e.getWhoClicked()).getCurrent();
        if (inventory != null)
            inventory.click(e);
    }

    private boolean validClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player) || e.isCancelled())
            return false;

        // Clicks the inventory
        if (!e.getInventory().equals(FraithorAuctions.getInstance().getPlayerData((Player) e.getWhoClicked()).getInventory()))
            return false;

        // Clicks number key
        if (e.getCurrentItem() == null) {
            if (e.getClick() == ClickType.NUMBER_KEY)
                e.setCancelled(true);
            return false;
        }

        // Checks if item is valid
        if (e.getCurrentItem() == null)
            return false;

        // Clicks their own inventory
        if (!Objects.equals(e.getClickedInventory(),
                FraithorAuctions.getInstance().getPlayerData((Player) e.getWhoClicked()).getInventory())) {
            e.setCancelled(true);
            return false;
        }
        return true;
    }

}
