package dev.yesithx.proxycore.bungeecord.command;

import dev.yesithx.proxycore.bungeecord.ProxyCoreBungee;
import dev.yesithx.proxycore.bungeecord.util.ColorUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

import java.lang.management.ManagementFactory;

public class UptimeCommand extends Command {

    private final ProxyCoreBungee plugin;

    public UptimeCommand(ProxyCoreBungee plugin) {
        super("uptime", "proxycore.uptime");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        long uptime = ManagementFactory.getRuntimeMXBean().getUptime() / 1000;
        long days = uptime / 86400;
        long hours = (uptime % 86400) / 3600;
        long minutes = (uptime % 3600) / 60;
        long seconds = uptime % 60;

        sender.sendMessage(ColorUtil.color(
                "&7Network uptime: &e" + days + "d " + hours + "h " + minutes + "m " + seconds + "s"
        ));
    }
}
