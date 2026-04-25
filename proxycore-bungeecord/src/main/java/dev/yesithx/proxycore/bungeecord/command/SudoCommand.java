package dev.yesithx.proxycore.bungeecord.command;

import dev.yesithx.proxycore.bungeecord.ProxyCoreBungee;
import dev.yesithx.proxycore.bungeecord.util.ColorUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class SudoCommand extends Command {

    private final ProxyCoreBungee plugin;

    public SudoCommand(ProxyCoreBungee plugin) {
        super("psudo", "proxycore.sudo");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(ColorUtil.color("&cUsage: /psudo <player> <command>"));
            return;
        }
        ProxiedPlayer target = plugin.getProxy().getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ColorUtil.color(plugin.getMessages().getString("player-not-found", "&cPlayer not found.").replace("%player%", args[0])));
            return;
        }
        StringBuilder cmd = new StringBuilder();
        for (int i = 1; i < args.length; i++) cmd.append(args[i]).append(" ");
        String command = cmd.toString().trim();

        plugin.getProxy().getPluginManager().dispatchCommand(target, command);
        sender.sendMessage(ColorUtil.color("&aMade &e" + target.getName() + " &arun: &f/" + command));
    }
}
