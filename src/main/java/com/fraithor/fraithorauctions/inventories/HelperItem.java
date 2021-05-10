package com.fraithor.fraithorauctions.inventories;

import com.fraithor.fraithorauctions.Util.File.FileBasics;
import com.fraithor.fraithorauctions.Util.Message;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class HelperItem {

    public static ItemStack getItem(ItemStack item, Player p, Object info) {
        //Item Title
        if (item.getItemMeta() != null) {
            String name = item.getItemMeta().getDisplayName();
            name = Message.c(name);
            setTitle(item, p, name);
            //Item Lore
            if (item.getItemMeta().getLore() != null) {
                List<String> lore = item.getItemMeta().getLore();
                lore.forEach(str -> lore.set(lore.indexOf(str), Message.c(str)));
                setLore(item, p, lore, info);
            }
            if (item.getType() == Material.PLAYER_HEAD) {
                SkullMeta meta = (SkullMeta) item.getItemMeta();
                if (info instanceof Player)
                    meta.setOwningPlayer(((Player) info).getPlayer());
                //else //Laggy code
                //    meta.setOwningPlayer(Bukkit.getOfflinePlayers()[ThreadLocalRandom.current().nextInt(0, Bukkit.getOfflinePlayers().length)]);
                item.setItemMeta(meta);
            }
        }

        return item;
    }

    public static ItemStack getItemFromFile(String path, FileBasics.FILETYPE file) {
        //System.out.println(path);
        //Item
        ItemStack item = new ItemStack(getMat(file.getString(path + "Item")));
        //Name
        setTitle(item, null, file.getString(path + "Name"));
        //Lore
        setLore(item, null, file.getStringList(path + "Lore"), null);
        return item;
    }

    public static void enchantItem(ItemStack item, Enchantment enchant) {
        item.addUnsafeEnchantment(enchant, 1);
        if (item.getItemMeta() != null) {
            ItemMeta meta = item.getItemMeta();
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
        }
    }

    private static Material getMat(String str) {
        try {
            return Material.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            return Material.BEDROCK;
        }
    }

    static void setTitle(ItemStack item, Player p, String title) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(title/*Message.placeholder(p, title, null)*/);
        item.setItemMeta(meta);
    }

    static void setLore(ItemStack item, Player p, List<String> lore, Object info) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        //lore.forEach(str -> lore.set(lore.indexOf(str), Message.placeholder(p, "&f" + str, info)));
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    static void addLore(ItemStack item, Player p, List<String> lore, Object info) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        //lore.forEach(str -> lore.set(lore.indexOf(str), Message.placeholder(p, "&f" + str, info)));
        if (meta.getLore() != null) {
            List<String> _clore = meta.getLore();
            _clore.addAll(lore);
            meta.setLore(_clore);
        } else
            meta.setLore(lore);
        item.setItemMeta(meta);
    }
}
