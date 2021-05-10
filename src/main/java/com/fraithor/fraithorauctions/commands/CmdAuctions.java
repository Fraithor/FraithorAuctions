package com.fraithor.fraithorauctions.commands;

import com.fraithor.fraithorauctions.FraithorAuctions;
import com.fraithor.fraithorauctions.Util.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdAuctions implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sendi, Command command, String label, String[] args) {
        if (sendi instanceof Player) {
            FraithorAuctions.getInstance().reload(sendi); //Made it reload so you can see where the reload class is
            Player player = (Player) sendi;


        } else {
            Message.info("Only players may use this command!");
        }
        return false;
    }

}
