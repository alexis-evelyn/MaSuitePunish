package fi.matiaspaavilainen.masuitepunish.bungee.events;

import fi.matiaspaavilainen.masuitecore.core.configuration.BungeeConfiguration;
import fi.matiaspaavilainen.masuitecore.core.objects.MaSuitePlayer;
import fi.matiaspaavilainen.masuitecore.core.utils.Date;
import fi.matiaspaavilainen.masuitepunish.bungee.objects.Punishment;
import net.md_5.bungee.api.plugin.Cancellable;
import net.md_5.bungee.api.plugin.Event;


public class PunishmentEvent extends Event implements Cancellable {

    private Punishment punishment;
    private String message;
    private boolean isCancelled;

    public PunishmentEvent(Punishment punishment) {
        this.punishment = punishment;
        this.isCancelled = false;
        BungeeConfiguration config = new BungeeConfiguration();
        this.message = config.load("punish", "messages.yml")
                .getString("punishments." + punishment.getPunishmentType().name().toLowerCase())
                .replace("%player%", new MaSuitePlayer().find(punishment.getPlayer()).getUsername())
                .replace("%punisher%", new MaSuitePlayer().find(punishment.getPunisher()).getUsername())
                .replace("%length%", new Date().getDate(new java.util.Date(punishment.getLength() * 1000)))
                .replace("%reason%", String.valueOf(punishment.getReason()))
                .replace("%description%", punishment.getDescription());
    }

    public Punishment getPunishment() {
        return this.punishment;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCancelled = b;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
