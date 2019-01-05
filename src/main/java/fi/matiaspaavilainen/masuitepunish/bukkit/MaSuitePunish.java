package fi.matiaspaavilainen.masuitepunish.bukkit;

import fi.matiaspaavilainen.masuitecore.bukkit.MaSuiteCore;
import fi.matiaspaavilainen.masuitepunish.bukkit.commands.Ban;
import org.bukkit.plugin.java.JavaPlugin;

public final class MaSuitePunish extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        registerCommands();
        registerListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands(){
        getCommand("ban").setExecutor(new Ban(this));
    }

    private void registerListeners(){
        if (MaSuiteCore.bungee) {
            getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        }
    }
}
