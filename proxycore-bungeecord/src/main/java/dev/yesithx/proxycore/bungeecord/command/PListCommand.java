package dev.yesithx.proxycore.bungeecord.command;

import dev.yesithx.proxycore.bungeecord.ProxyCoreBungee;
import dev.yesithx.proxycore.bungeecord.util.ColorUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.Collection;
import java.util.stream.Collectors;

public class PListCommand extends Command {

    private final ProxyCoreBungee plugin;

    public PListCommand(ProxyCoreBungee plugin) {
        super("plist", "proxycore.plist");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 1) {
            sender.sendMessage(ColorUtil.color("&cUsage: /plist <server>"));
            return;
        }
        ServerInfo server = plugin.getProxy().getServerInfo(args[0]);
        if (server == null) {
            sender.sendMessage(ColorUtil.color("&cServer &e" + args[0] + " &cnot found."));
            return;
        }
        Collection<ProxiedPlayer> players = server.getPlayers();
        sender.sendMessage(ColorUtil.color("&8&m--&r &e" + server.getName() + " &7(&f" + players.size() + "&7) &8&m--"));
        if (players.isEmpty()) {
            sender.sendMessage(ColorUtil.color(" &7No players online."));
        } else {
            String names = players.stream().map(ProxiedPlayer::getName).collect(Collectors.joining("&7, &f"));
            sender.sendMessage(ColorUtil.color(" &f" + names));
        }
    }
}
