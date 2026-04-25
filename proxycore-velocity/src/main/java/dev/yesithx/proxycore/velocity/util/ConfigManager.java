package dev.yesithx.proxycore.velocity.util;

import dev.yesithx.proxycore.velocity.ProxyCoreVelocity;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ConfigManager {

    private final ProxyCoreVelocity plugin;
    private Map<String, Object> config = new HashMap<>();
    private Map<String, Object> messages = new HashMap<>();

    public ConfigManager(ProxyCoreVelocity plugin) {
        this.plugin = plugin;
    }

    public void load() {
        config = loadYaml("config.yml");
        messages = loadYaml("messages.yml");
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> loadYaml(String name) {
        Path dir = plugin.getDataDirectory();
        Path file = dir.resolve(name);
        try {
            if (!Files.exists(dir)) Files.createDirectories(dir);
            if (!Files.exists(file)) {
                try (InputStream in = plugin.getClass().getResourceAsStream("/" + name)) {
                    if (in != null) Files.copy(in, file);
                }
            }
            try (InputStream in = Files.newInputStream(file)) {
                Yaml yaml = new Yaml();
                Map<String, Object> result = yaml.load(in);
                return result != null ? result : new HashMap<>();
            }
        } catch (IOException e) {
            plugin.getLogger().error("Could not load " + name, e);
            return new HashMap<>();
        }
    }

    public String getString(String key, String def) {
        String[] parts = key.split("\\.");
        Map<String, Object> current = config;
        for (int i = 0; i < parts.length - 1; i++) {
            Object val = current.get(parts[i]);
            if (!(val instanceof Map)) return def;
            current = (Map<String, Object>) val;
        }
        Object val = current.get(parts[parts.length - 1]);
        return val != null ? val.toString() : def;
    }

    public String getMessage(String key, String def) {
        Object val = messages.get(key);
        return val != null ? val.toString() : def;
    }

    public boolean getBoolean(String key, boolean def) {
        String[] parts = key.split("\\.");
        Map<String, Object> current = config;
        for (int i = 0; i < parts.length - 1; i++) {
            Object v = current.get(parts[i]);
            if (!(v instanceof Map)) return def;
            current = (Map<String, Object>) v;
        }
        Object val = current.get(parts[parts.length - 1]);
        return val instanceof Boolean ? (Boolean) val : def;
    }

    public int getInt(String key, int def) {
        String[] parts = key.split("\\.");
        Map<String, Object> current = config;
        for (int i = 0; i < parts.length - 1; i++) {
            Object v = current.get(parts[i]);
            if (!(v instanceof Map)) return def;
            current = (Map<String, Object>) v;
        }
        Object val = current.get(parts[parts.length - 1]);
        return val instanceof Number ? ((Number) val).intValue() : def;
    }

    @SuppressWarnings("unchecked")
    public List<String> getStringList(String key) {
        String[] parts = key.split("\\.");
        Map<String, Object> current = config;
        for (int i = 0; i < parts.length - 1; i++) {
            Object v = current.get(parts[i]);
            if (!(v instanceof Map)) return new ArrayList<>();
            current = (Map<String, Object>) v;
        }
        Object val = current.get(parts[parts.length - 1]);
        if (val instanceof List) return (List<String>) val;
        return new ArrayList<>();
    }
}
