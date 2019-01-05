package fi.matiaspaavilainen.masuitepunish.bungee.listeners;

import fi.matiaspaavilainen.masuitecore.bungee.Utils;
import fi.matiaspaavilainen.masuitecore.bungee.chat.Formator;
import fi.matiaspaavilainen.masuitecore.core.configuration.BungeeConfiguration;
import fi.matiaspaavilainen.masuitepunish.bungee.MaSuitePunish;
import fi.matiaspaavilainen.masuitepunish.bungee.objects.Punishment;
import fi.matiaspaavilainen.masuitepunish.core.PunishmentType;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.UUID;

public class PunishmentListener implements Listener {

    private BungeeConfiguration config = new BungeeConfiguration();
    private Formator formator = new Formator();
    private Utils utils = new Utils();
    private MaSuitePunish plugin;

    public PunishmentListener(MaSuitePunish plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMessageReceived(PluginMessageEvent e) {
        if (e.getTag().equals("BungeeCord")) {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(e.getData()));
            try {
                String subchannel = in.readUTF();
                if (subchannel.equals("MaSuitePunish")) {
                    String childchannel = in.readUTF();
                    if (childchannel.equals("Ban")) {
                        ProxiedPlayer sender = ProxyServer.getInstance().getPlayer(UUID.fromString(in.readUTF()));
                        if (utils.isOnline(sender)) {
                            Punishment punishment = new Punishment(UUID.fromString(in.readUTF()), sender.getUniqueId(), in.readInt(), in.readUTF(), PunishmentType.BAN);
                            punishment.create();
                        }

                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
