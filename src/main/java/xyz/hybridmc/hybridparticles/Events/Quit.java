package xyz.hybridmc.hybridparticles.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.hybridmc.hybridparticles.Models.ParticleData;

import java.util.List;

public class Quit implements Listener {

    public void onQuit(PlayerQuitEvent event) {
        ParticleData p = new ParticleData(event.getPlayer().getUniqueId());
        if (p.hasID())
            p.endTask();
    }
}
