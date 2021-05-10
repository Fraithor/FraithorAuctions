package com.fraithor.fraithorauctions.Commands;

import com.fraithor.fraithorauctions.Util.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Auctions implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sendi, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("auctions")) {
            if (sendi instanceof Player) {
                Player player = (Player) sendi;


            } else {
                Message.info("Only players may use this command!");
            }


        }
        return false;
    }

}
