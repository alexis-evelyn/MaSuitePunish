package fi.matiaspaavilainen.masuitepunish.bungee.listeners;

import fi.matiaspaavilainen.masuitecore.bungee.Utils;
import fi.matiaspaavilainen.masuitecore.core.objects.MaSuitePlayer;
import fi.matiaspaavilainen.masuitepunish.bungee.MaSuitePunish;
import fi.matiaspaavilainen.masuitepunish.bungee.events.PunishmentEvent;
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
import java.time.Instant;
import java.util.UUID;

public class PunishmentListener implements Listener {

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
                    if (childchannel.equals("BAN")) {
                        ProxiedPlayer sender = ProxyServer.getInstance().getPlayer(UUID.fromString(in.readUTF()));
                        if (utils.isOnline(sender)) {
                            MaSuitePlayer player = new MaSuitePlayer().find(in.readUTF());
                            if(player.getUniqueId() == null){
                                // TODO: Add message
                                sender.sendMessage("Player not found");
                                return;
                            }
                            String time = in.readUTF();
                            int reason = in.readInt();
                            String desc = in.readUTF();

                            if(time.equalsIgnoreCase("permanent")){
                                childchannel = "BAN";
                            } else {

                            }
                            Punishment punishment = new Punishment(player.getUniqueId(), sender.getUniqueId(), reason, desc, PunishmentType.valueOf(childchannel), Instant.now().getEpochSecond(), Instant.now().plusMillis(100000).getEpochSecond());
                            if(punishment.create()){
                                plugin.getProxy().getPluginManager().callEvent(new PunishmentEvent(punishment));
                            }
                        }

                    }

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}