package dev.yesithx.proxycore.velocity.manager;

import com.velocitypowered.api.proxy.Player;
import dev.yesithx.proxycore.velocity.ProxyCoreVelocity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class MessageManager {

    private final ProxyCoreVelocity plugin;
    private final Map<UUID, UUID> lastMessaged = new HashMap<>();

    public MessageManager(ProxyCoreVelocity plugin) {
        this.plugin = plugin;
    }

    public void setLastMessaged(UUID sender, UUID target) {
        lastMessaged.put(sender, target);
        lastMessaged.put(target, sender);
    }

    public Optional<Player> getLastMessaged(UUID uuid) {
        UUID targetUUID = lastMessaged.get(uuid);
        if (targetUUID == null) return Optional.empty();
        return plugin.getServer().getPlayer(targetUUID);
    }

    public void removePlayer(UUID uuid) {
        lastMessaged.remove(uuid);
    }
}
