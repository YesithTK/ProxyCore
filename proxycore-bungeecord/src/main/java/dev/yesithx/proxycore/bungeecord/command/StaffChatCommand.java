package dev.yesithx.proxycore.bungeecord.command;

import dev.yesithx.proxycore.bungeecord.ProxyCoreBungee;
import dev.yesithx.proxycore.bungeecord.util.ColorUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class StaffChatCommand extends Command {

    private final ProxyCoreBungee plugin;

    public StaffChatCommand(ProxyCoreBungee plugin) {
        super("staffchat", "proxycore.staffchat", "sc");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 1) {
            sender.sendMessage(ColorUtil.color("&cUsage: /staffchat <message>"));
            return;
        }
        String message = String.join(" ", args);
        String name = (sender instanceof ProxiedPlayer) ? sender.getName() : "Console";
        String formatted = ColorUtil.color("&8[&cStaff&8] &7" + name + ": &f" + message);

        for (ProxiedPlayer player : plugin.getProxy().getPlayers()) {
            if (player.hasPermission("proxycore.staffchat")) {
                player.sendMessage(formatted);
            }
        }
        // Also log to console
        plugin.getLogger().info("[StaffChat] " + name + ": " + message);
    }
}
