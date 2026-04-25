package dev.yesithx.proxycore.api.manager;

import java.util.List;

/**
 * Manages automatic rotating announcements broadcast to all players.
 *
 * @author YesithTK
 */
public interface IAnnounceManager {

    /**
     * Starts the announcement scheduler.
     * Reads interval and messages from config.
     */
    void startScheduler();

    /**
     * Stops the announcement scheduler.
     */
    void stopScheduler();

    /**
     * Reloads config and restarts the scheduler.
     * Call this after a plugin reload.
     */
    void reload();

    /**
     * Returns whether the announcement scheduler is currently running.
     */
    boolean isRunning();

    /**
     * Returns the list of configured announcement messages.
     */
    List<String> getMessages();

    /**
     * Returns the interval in seconds between announcements.
     */
    int getIntervalSeconds();
}
