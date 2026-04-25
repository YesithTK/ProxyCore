package dev.yesithx.proxycore.bungeecord.command;

import dev.yesithx.proxycore.bungeecord.ProxyCoreBungee;
import dev.yesithx.proxycore.bungeecord.util.ColorUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BroadcastCommand extends Command {

    private final ProxyCoreBungee plugin;

    public BroadcastCommand(ProxyCoreBungee plugin) {
        super("pbroadcast", "proxycore.broadcast", "pbc");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 1) {
            sender.sendMessage(ColorUtil.color("&cUsage: /pbroadcast <message>"));
            return;
        }
        String message = String.join(" ", args);
        String prefix = plugin.getMessages().getString("broadcast-prefix", "&8[&4Broadcast&8] &r");
        String colored = ColorUtil.color(prefix + message);

        ProxyServer.getInstance().broadcast(new TextComponent(colored));
    }
}
