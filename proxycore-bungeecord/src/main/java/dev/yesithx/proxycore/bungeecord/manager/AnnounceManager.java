package dev.yesithx.proxycore.bungeecord.manager;

import dev.yesithx.proxycore.bungeecord.ProxyCoreBungee;
import dev.yesithx.proxycore.bungeecord.util.ColorUtil;
import net.md_5.bungee.api.ProxyServer;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AnnounceManager {

    private final ProxyCoreBungee plugin;
    private int index = 0;
    private net.md_5.bungee.api.scheduler.ScheduledTask task;

    public AnnounceManager(ProxyCoreBungee plugin) {
        this.plugin = plugin;
    }

    public void startScheduler() {
        int intervalSeconds = plugin.getConfig().getInt("announcements.interval", 60);
        boolean enabled = plugin.getConfig().getBoolean("announcements.enabled", true);
        if (!enabled) return;

        task = ProxyServer.getInstance().getScheduler().schedule(plugin, () -> {
            List<String> announcements = (List<String>) plugin.getConfig().getList("announcements.messages");
            if (announcements == null || announcements.isEmpty()) return;

            if (index >= announcements.size()) index = 0;
            String msg = announcements.get(index++);
            String prefix = plugin.getMessages().getString("announce-prefix", "&8[&6Announce&8] &r");
            ProxyServer.getInstance().broadcast(ColorUtil.color(prefix + msg));
        }, intervalSeconds, intervalSeconds, TimeUnit.SECONDS);
    }

    public void stopScheduler() {
        if (task != null) task.cancel();
    }

    public void reload() {
        stopScheduler();
        index = 0;
        startScheduler();
    }
}
