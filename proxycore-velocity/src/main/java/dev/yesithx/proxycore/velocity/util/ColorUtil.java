package dev.yesithx.proxycore.velocity.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class ColorUtil {
    private static final LegacyComponentSerializer SERIALIZER =
            LegacyComponentSerializer.legacyAmpersand();

    public static Component color(String text) {
        if (text == null) return Component.empty();
        return SERIALIZER.deserialize(text);
    }

    public static String strip(String text) {
        if (text == null) return "";
        return text.replaceAll("&[0-9a-fk-orA-FK-OR]", "");
    }
}
