package com.fraithor.fraithorauctions.inventories;

import com.fraithor.fraithorauctions.Util.File.FileBasics;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

public abstract class AuctionInvLoader {

    String title = null;
    HashMap<String, ItemStack> items = new HashMap<>();

    protected ItemStack getItem(String section, Player p, Object info) {
        return HelperItem.getItem(items.get(section).clone(), p, info);
    }

    protected String getTitle(Player p, Object info) {
        return title;//Message.placeholder(p , title, info);
    }

    public void load() {
        items.clear();
        FileBasics.FILETYPE file = FileBasics.FILETYPE.MENU;
        String pre = getSection();
        title = file.getString(pre + ".Title");
        List<String> sections = getSections();
        if (sections != null)
            for (String sec : sections) {
                String _pre = pre + "." + sec + ".";
                ItemStack item = HelperItem.getItemFromFile(_pre, file);
                this.items.put(sec, item);
            }
    }

    protected abstract String getSection();

    @Nullable
    protected abstract List<String> getSections();

}
