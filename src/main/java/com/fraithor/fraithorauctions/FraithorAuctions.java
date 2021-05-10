package com.fraithor.fraithorauctions;

import com.fraithor.fraithorauctions.Commands.Auctions;
import com.fraithor.fraithorauctions.Commands.MainCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class FraithorAuctions extends JavaPlugin {

    private static FraithorAuctions instance;

    public static final MainCommand mainCommand = new MainCommand();
    public static final Auctions auctions = new Auctions();

    @Override
    public void onEnable() {
        this.getCommand("fraithorauctions").setExecutor(mainCommand);
        this.getCommand("auctions").setExecutor(auctions);
        instance = this;
    }

    public static FraithorAuctions getInstance() {
        return instance;
    }
}
