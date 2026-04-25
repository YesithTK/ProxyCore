package dev.yesithx.proxycore.bungeecord.command;

import dev.yesithx.proxycore.bungeecord.ProxyCoreBungee;
import dev.yesithx.proxycore.bungeecord.util.ColorUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

import java.lang.management.ManagementFactory;

public class NetworkCommand extends Command {

    private final ProxyCoreBungee plugin;

    public NetworkCommand(ProxyCoreBungee plugin) {
        super("network", "proxycore.network");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        int players = plugin.getProxy().getOnlineCount();
        int servers = plugin.getProxy().getServers().size();
        long uptime = ManagementFactory.getRuntimeMXBean().getUptime() / 1000;
        long hours = uptime / 3600;
        long minutes = (uptime % 3600) / 60;
        boolean maintenance = plugin.getMaintenanceManager().isEnabled();

        sender.sendMessage(ColorUtil.color("&8&m-----&r &b&lNetwork Stats &8&m-----"));
        sender.sendMessage(ColorUtil.color(" &7Players online: &f" + players));
        sender.sendMessage(ColorUtil.color(" &7Servers: &f" + servers));
        sender.sendMessage(ColorUtil.color(" &7Uptime: &f" + hours + "h " + minutes + "m"));
        sender.sendMessage(ColorUtil.color(" &7Maintenance: " + (maintenance ? "&cEnabled" : "&aDisabled")));
        sender.sendMessage(ColorUtil.color("&8&m---------------------"));
    }
}
