package dev.yesithx.proxycore.api.manager;

/**
 * Manages the network maintenance mode.
 * When enabled, non-staff players are kicked and cannot join.
 *
 * @author YesithTK
 */
public interface IMaintenanceManager {

    /**
     * Returns whether maintenance mode is currently active.
     */
    boolean isEnabled();

    /**
     * Enables or disables maintenance mode.
     *
     * @param enabled true to enable, false to disable
     */
    void setEnabled(boolean enabled);

    /**
     * Returns the kick message shown to players when maintenance is on.
     * Supports & color codes.
     */
    String getKickMessage();

    /**
     * Returns the permission node that allows bypassing maintenance mode.
     *
     * @return permission string, default: "proxycore.maintenance.bypass"
     */
    default String getBypassPermission() {
        return "proxycore.maintenance.bypass";
    }
}
