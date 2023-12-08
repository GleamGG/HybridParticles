package xyz.hybridmc.hybridparticles.Models;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI {

    private static Inventory INV;

    public void register() {
        Inventory inv = Bukkit.createInventory(null, 54, "§b" + "§5Trails Menu");

        ItemStack item = new ItemStack(Material.WATER_BUCKET);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§e§lWater Spiral");
        item.setItemMeta(meta);
        inv.setItem(21, item);

        item = new ItemStack(Material.LAVA_BUCKET);
        meta = item.getItemMeta();
        meta.setDisplayName("§c§lFire Trail");
        item.setItemMeta(meta);
        inv.setItem(22, item);

        item = new ItemStack(Material.BARRIER);
        meta = item.getItemMeta();
        meta.setDisplayName("§4§lCOMING SOON");
        item.setItemMeta(meta);
        inv.setItem(23, item);

        setInventory(inv);
    }

    public  Inventory getInventory() {
        return INV;
    }

    private void setInventory(Inventory inv) {
        INV = inv;
    }

    public void openInventory(Player player) {
        player.openInventory(INV);
    }

}
