package dev.yesithx.proxycore.velocity.manager;

import dev.yesithx.proxycore.velocity.ProxyCoreVelocity;

public class MaintenanceManager {

    private final ProxyCoreVelocity plugin;
    private boolean enabled;

    public MaintenanceManager(ProxyCoreVelocity plugin) {
        this.plugin = plugin;
        this.enabled = plugin.getConfigManager().getBoolean("maintenance.enabled", false);
    }

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public String getKickMessage() {
        return plugin.getConfigManager().getMessage("maintenance-kick",
                "&cThe server is under maintenance. Please try again later.");
    }
}
