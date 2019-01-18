package fi.matiaspaavilainen.masuitepunish.bukkit.commands;

import fi.matiaspaavilainen.masuitecore.core.objects.PluginChannel;
import fi.matiaspaavilainen.masuitepunish.bukkit.MaSuitePunish;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {

    private MaSuitePunish plugin;

    public BanCommand(MaSuitePunish plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        if (args.length < 3) {
            sender.sendMessage("syntaxxx");
            return false;
        }
        Player p = (Player) sender;
        StringBuilder msg = new StringBuilder();
        for (int i = 3; i < args.length; i++) {
            msg.append(args[i]).append(" ");
        }
        new PluginChannel(plugin, p, new Object[]{"MaSuitePunish", "BAN", p.getUniqueId().toString(), args[0], args[1], args[2], msg.toString()}).send();
        new PluginChannel(plugin, p, new Object[]{"MaSuitePunish", "BAN", p.getUniqueId().toString(), args[0], "PERMANENT", args[1], msg.toString()}).send();
        return false;
    }
}
