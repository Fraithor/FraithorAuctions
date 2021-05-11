package com.fraithor.fraithorauctions;

import com.fraithor.fraithorauctions.Util.File.FileBasics;
import com.fraithor.fraithorauctions.Util.Message;
import com.fraithor.fraithorauctions.Util.auctiondata.AuctionManager;
import com.fraithor.fraithorauctions.Util.playerdata.PlayerData;
import com.fraithor.fraithorauctions.Util.playerdata.PlayerDataManager;
import com.fraithor.fraithorauctions.commands.CmdMain;
import com.fraithor.fraithorauctions.events.EventListener;
import com.fraithor.fraithorauctions.inventories.AuctionInvLoader;
import com.fraithor.fraithorauctions.inventories.AuctionInventory;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import javax.management.openmbean.CompositeData;
import java.util.Objects;

public class FraithorAuctions extends JavaPlugin {

    private static FraithorAuctions instance;

    public static final CmdMain mainCommand = new CmdMain();
    private static final EventListener eventListener = new EventListener();
    private static final PlayerDataManager dataManager = new PlayerDataManager();
    private static final AuctionManager auctionManager = new AuctionManager();
    private static final FileBasics files = new FileBasics();

    @Override
    public void onEnable() {
        instance = this;
        Objects.requireNonNull(this.getCommand("fraithorauctions")).setExecutor(mainCommand);
        eventListener.load(); //Only needs to be loaded once
        loadAll();
    }

    public void reload(CommandSender sendi) {
        loadAll();
        //MessagesCore.RELOAD.send(sendi);
        Message.toSendi(sendi, "Reloaded plugin!");
        exitMenus();
    }

    public void loadAll() {
        files.load();
        auctionManager.load();
        //Load all inventories that have a loading sequence
        for (AuctionInventory inv : AuctionInventory.values())
            if (inv.get() instanceof AuctionInvLoader)
                ((AuctionInvLoader) inv.get()).load();
    }

    private void exitMenus() {
        for (Player plr : Bukkit.getOnlinePlayers())
            if (getPlayerData(plr).getInventory() != null) {
                getPlayerData(plr).clear();
                plr.closeInventory();
            }
    }

    public static FraithorAuctions getInstance() {
        return instance;
    }

    public PlayerData getPlayerData(Player p) {
        return dataManager.getData(p);
    }

    public AuctionManager getAuction() {
        return auctionManager;
    }
}
