package com.fraithor.fraithorauctions.events;

import com.fraithor.fraithorauctions.FraithorAuctions;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EventListener implements Listener {
    //Listen to all events here and hand off to other classes to handle them

    private final EventClick eventClick = new EventClick();

    public void load() {
        Bukkit.getPluginManager().registerEvents(this, FraithorAuctions.getInstance());
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        eventClick.click(e);
    }
}
