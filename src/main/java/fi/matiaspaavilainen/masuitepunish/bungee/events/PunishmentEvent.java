package fi.matiaspaavilainen.masuitepunish.bungee.events;

import fi.matiaspaavilainen.masuitepunish.bungee.objects.Punishment;
import net.md_5.bungee.api.plugin.Cancellable;
import net.md_5.bungee.api.plugin.Event;

public class PunishmentEvent extends Event implements Cancellable {

    private Punishment punishment;
    private boolean isCancelled;

    public PunishmentEvent(Punishment punishment) {
        this.punishment = punishment;
        this.isCancelled = false;
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
}
