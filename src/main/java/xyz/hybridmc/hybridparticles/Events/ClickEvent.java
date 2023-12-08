package xyz.hybridmc.hybridparticles.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import xyz.hybridmc.hybridparticles.Models.Effects;
import xyz.hybridmc.hybridparticles.Models.GUI;
import xyz.hybridmc.hybridparticles.Models.ParticleData;

public class ClickEvent implements Listener {

    private GUI menu;
    public ClickEvent() {
        menu = new GUI();
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(menu.getInventory()))
            return;

        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);

        if (event.getView().getType() == InventoryType.PLAYER)
            return;

        ParticleData particle = new ParticleData(player.getUniqueId());

        if(particle.hasID()) {
            particle.endTask();
            particle.removeID();
        }

        Effects trails = new Effects(player);
        switch(event.getSlot()) {
            case 3:
                trails.startWater();
                player.closeInventory();
                player.updateInventory();
                break;
            case 5:
                particle.setID(1);
                player.closeInventory();
                player.updateInventory();
                break;
            default:
                break;
        }
    }
}
