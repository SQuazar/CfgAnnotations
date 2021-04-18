package net.flawe.example;

import net.flawe.annotations.ConfigurationLoader;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Example extends JavaPlugin implements Listener {

    private final ExampleCfg config = new ExampleCfg();

    @Override
    public void onEnable() {
        ConfigurationLoader.loadConfiguration(config, getConfig());
        try {
            ConfigurationLoader.saveConfiguration(config, new File(getDataFolder(), "config.yml"));
        } catch (IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
        getLogger().info("Config version is " + config.getVersion());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().sendMessage(ChatColor
                .translateAlternateColorCodes('&', config.getWelcomeMessage()));
    }
}
