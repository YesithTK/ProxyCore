package dev.yesithx.proxycore.bungeecord.command;

import dev.yesithx.proxycore.bungeecord.ProxyCoreBungee;
import dev.yesithx.proxycore.bungeecord.util.ColorUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;

public class AlertCommand extends Command {

    private final ProxyCoreBungee plugin;

    public AlertCommand(ProxyCoreBungee plugin) {
        super("alert", "proxycore.alert");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 1) {
            sender.sendMessage(ColorUtil.color("&cUsage: /alert <message>"));
            return;
        }
        String message = String.join(" ", args);
        String line = "&8&m" + "=".repeat(40);
        ProxyServer.getInstance().broadcast(ColorUtil.color(line));
        ProxyServer.getInstance().broadcast(ColorUtil.color("    &c&l⚠ ALERT &c&l⚠"));
        ProxyServer.getInstance().broadcast(ColorUtil.color("    &f" + message));
        ProxyServer.getInstance().broadcast(ColorUtil.color(line));
    }
}
