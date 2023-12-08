package xyz.hybridmc.hybridparticles;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.hybridmc.hybridparticles.Commands.Trails;
import xyz.hybridmc.hybridparticles.Events.ClickEvent;
import xyz.hybridmc.hybridparticles.Events.Movement;
import xyz.hybridmc.hybridparticles.Events.Quit;
import xyz.hybridmc.hybridparticles.Models.GUI;

public final class HybridParticles extends JavaPlugin {

    @Override
    public void onEnable() {
        GUI menu = new GUI();
        menu.register();

        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new ClickEvent(), this);
        pm.registerEvents(new Quit(), this);
        pm.registerEvents(new Movement(), this);

        this.getCommand("trail").setExecutor(new Trails());
    }
}