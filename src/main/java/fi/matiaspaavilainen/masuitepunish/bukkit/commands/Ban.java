package fi.matiaspaavilainen.masuitepunish.bukkit.commands;

import fi.matiaspaavilainen.masuitepunish.bukkit.MaSuitePunish;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Ban implements CommandExecutor {

    private MaSuitePunish plugin;

    public Ban(MaSuitePunish plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player p = (Player) sender;
        try (ByteArrayOutputStream b = new ByteArrayOutputStream();
             DataOutputStream out = new DataOutputStream(b)) {
            out.writeUTF("MaSuitePunish");
            out.writeUTF("Ban");
            out.writeUTF(p.getUniqueId().toString());
            out.writeUTF(p.getUniqueId().toString());
            out.writeInt(1);
            out.writeUTF("Being noob");
            p.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
        } catch (IOException e) {
            e.getStackTrace();
        }
        return false;
    }
}
