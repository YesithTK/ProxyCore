package dev.yesithx.proxycore.bungeecord.command;

import dev.yesithx.proxycore.bungeecord.ProxyCoreBungee;
import dev.yesithx.proxycore.bungeecord.util.ColorUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class AnnounceCommand extends Command {

    private final ProxyCoreBungee plugin;

    public AnnounceCommand(ProxyCoreBungee plugin) {
        super("announce", "proxycore.announce", "ann");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 1) {
            sender.sendMessage(ColorUtil.color("&cUsage: /announce <message>"));
            return;
        }
        String message = String.join(" ", args);
        String prefix = plugin.getMessages().getString("announce-prefix", "&8[&6Announce&8] &r");
        plugin.getProxy().broadcast(ColorUtil.color(prefix + message));
    }
}
