package fi.matiaspaavilainen.masuitepunish.bungee;

import fi.matiaspaavilainen.masuitecore.core.objects.MaSuitePlayer;
import fi.matiaspaavilainen.masuitepunish.bungee.events.PunishmentEvent;
import fi.matiaspaavilainen.masuitepunish.bungee.listeners.PunishmentListener;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class MaSuitePunish extends Plugin implements Listener {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, this);
        getProxy().getPluginManager().registerListener(this, new PunishmentListener(this));
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onPunish(PunishmentEvent e) {
        // TODO: Remove
        getProxy().broadcast(new TextComponent(ChatColor.RED +
                        new MaSuitePlayer().find(e.getPunishment().getPlayer()).getUsername()
                        + " has been banned by "
                        + new MaSuitePlayer().find(e.getPunishment().getPunisher()).getUsername()
                        + "! Reason: " + e.getPunishment().getReason()
                        + " Description: " + e.getPunishment().getDescription()
                )
        );
    }
}
