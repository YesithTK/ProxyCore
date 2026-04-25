package dev.yesithx.proxycore.bungeecord.command;

import dev.yesithx.proxycore.bungeecord.ProxyCoreBungee;
import dev.yesithx.proxycore.bungeecord.util.ColorUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ReplyCommand extends Command {

    private final ProxyCoreBungee plugin;

    public ReplyCommand(ProxyCoreBungee plugin) {
        super("reply", "proxycore.msg", "r");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(ColorUtil.color("&cOnly players can use /reply."));
            return;
        }
        if (args.length < 1) {
            sender.sendMessage(ColorUtil.color("&cUsage: /reply <message>"));
            return;
        }
        ProxiedPlayer player = (ProxiedPlayer) sender;
        ProxiedPlayer target = plugin.getMessageManager().getLastMessaged(player.getUniqueId());
        if (target == null) {
            sender.sendMessage(ColorUtil.color("&cYou have no one to reply to."));
            return;
        }
        String msg = String.join(" ", args);
        player.sendMessage(ColorUtil.color("&7[&fYou &7→ &f" + target.getName() + "&7] &f" + msg));
        target.sendMessage(ColorUtil.color("&7[&f" + player.getName() + " &7→ &fYou&7] &f" + msg));
        plugin.getMessageManager().setLastMessaged(player.getUniqueId(), target.getUniqueId());
    }
}
