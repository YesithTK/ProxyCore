package dev.yesithx.proxycore.api.command;

import java.util.UUID;

/**
 * Platform-agnostic representation of a player connected to the proxy network.
 * Wraps BungeeCord's ProxiedPlayer and Velocity's Player behind one interface.
 *
 * @author YesithTK
 */
public interface NetworkPlayer extends ProxyCoreCommandSender {

    /**
     * Returns the player's unique ID.
     */
    UUID getUniqueId();

    /**
     * Returns the name of the server this player is currently connected to.
     * Returns "unknown" if the server cannot be determined.
     */
    String getCurrentServer();

    /**
     * Returns the player's ping in milliseconds.
     */
    long getPing();

    /**
     * Returns the player's IP address as a string.
     */
    String getIpAddress();

    /**
     * Disconnects the player with the given reason.
     * Supports & color codes.
     *
     * @param reason the disconnect message
     */
    void disconnect(String reason);

    /**
     * Connects the player to a server by name.
     *
     * @param serverName the target server name as defined in proxy config
     */
    void connectToServer(String serverName);
}
