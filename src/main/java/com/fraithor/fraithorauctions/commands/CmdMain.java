package com.fraithor.fraithorauctions.commands;

import com.fraithor.fraithorauctions.FraithorAuctions;
import com.fraithor.fraithorauctions.Util.auctiondata.AuctionInfo;
import com.fraithor.fraithorauctions.inventories.AuctionInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class CmdMain implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sendi, Command command, String label, String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                FraithorAuctions.getInstance().reload(sendi); //Made it reload so you can see where the reload class is
            }
        }

        Player p = (Player) sendi;
        List<AuctionInfo> auctionInfo = FraithorAuctions.getInstance().getAuction().getAll();
        AuctionInventory.MAIN.open(p, auctionInfo);

        return false;
    }
}
