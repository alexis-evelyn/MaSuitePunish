package fi.matiaspaavilainen.masuitepunish.bungee;

import fi.matiaspaavilainen.masuitecore.bungee.chat.Formator;
import fi.matiaspaavilainen.masuitecore.core.configuration.BungeeConfiguration;
import fi.matiaspaavilainen.masuitepunish.bungee.events.PunishmentEvent;
import fi.matiaspaavilainen.masuitepunish.bungee.listeners.PunishmentListener;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class MaSuitePunish extends Plugin implements Listener {

    private BungeeConfiguration config = new BungeeConfiguration();
    private Formator formator = new Formator();
    @Override
    public void onEnable() {

        config.create(this, "punish", "messages.yml");
        getProxy().getPluginManager().registerListener(this, this);
        getProxy().getPluginManager().registerListener(this, new PunishmentListener(this));
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onPunish(PunishmentEvent e) {
        formator.sendMessage(getProxy().getPlayer("Masagameplay"), formator.colorize(e.getMessage()));
    }
}
