package dev.yesithx.proxycore.bungeecord.command;

import dev.yesithx.proxycore.bungeecord.ProxyCoreBungee;
import dev.yesithx.proxycore.bungeecord.util.ColorUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class IPCommand extends Command {

    private final ProxyCoreBungee plugin;

    public IPCommand(ProxyCoreBungee plugin) {
        super("pip", "proxycore.ip");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 1) {
            sender.sendMessage(ColorUtil.color("&cUsage: /pip <player>"));
            return;
        }
        ProxiedPlayer target = plugin.getProxy().getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ColorUtil.color(plugin.getMessages().getString("player-not-found", "&cPlayer not found.").replace("%player%", args[0])));
            return;
        }
        String ip = target.getSocketAddress().toString().replace("/", "").split(":")[0];
        sender.sendMessage(ColorUtil.color("&7" + target.getName() + "'s IP: &e" + ip));
    }
}
