package dev.yesithx.proxycore.api.command;

/**
 * Platform-agnostic representation of a command sender.
 * Wraps BungeeCord's CommandSender and Velocity's CommandSource
 * behind a single interface usable in shared API code.
 *
 * @author YesithTK
 */
public interface ProxyCoreCommandSender {

    /**
     * Sends a message to this sender.
     * Supports & color codes.
     *
     * @param message the message to send
     */
    void sendMessage(String message);

    /**
     * Returns whether this sender has the given permission.
     *
     * @param permission the permission node to check
     * @return true if the sender has the permission
     */
    boolean hasPermission(String permission);

    /**
     * Returns the name of this sender.
     * Returns "Console" if the sender is the console.
     *
     * @return the sender's name
     */
    String getName();

    /**
     * Returns whether this sender is a player (not console).
     */
    boolean isPlayer();

    /**
     * Returns the unique identifier of this sender as a string.
     * For players this is their UUID. For console, returns "console".
     */
    String getIdentifier();
}
