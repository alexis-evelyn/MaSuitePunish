package fi.matiaspaavilainen.masuitepunishbridge;

import org.bukkit.plugin.java.JavaPlugin;

public final class MaSuitePunishBridge extends JavaPlugin {

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

    }

    private void registerListeners(){

    }
}
