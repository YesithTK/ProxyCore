<div align="center">

<img src="proxycore-logo.svg" width="220"/>

<br/><br/>

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:1a1a2e,50:16213e,100:0f3460&height=160&section=header&text=ProxyCore&fontSize=72&fontColor=e94560&animation=fadeIn&fontAlignY=42&desc=All-in-one%20Proxy%20Utilities%20Plugin&descAlignY=65&descColor=a8b2d8" width="100%"/>

<br/>

[![Version](https://img.shields.io/badge/version-1.0.0-e94560?style=for-the-badge&logo=github&logoColor=white)](https://github.com/YesithTK/ProxyCore)
[![Platform](https://img.shields.io/badge/platform-BungeeCord%20%7C%20Velocity-0f3460?style=for-the-badge&logo=minecraft&logoColor=white)](https://github.com/YesithTK/ProxyCore)
[![Java](https://img.shields.io/badge/java-17+-e94560?style=for-the-badge&logo=openjdk&logoColor=white)](https://adoptium.net/)
[![Build](https://img.shields.io/badge/build-Maven-0f3460?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/license-All%20Rights%20Reserved-16213e?style=for-the-badge&logo=gitbook&logoColor=white)](./LICENSE)
[![Author](https://img.shields.io/badge/author-YesithTK-a8b2d8?style=for-the-badge&logoColor=white)](https://github.com/YesithTK)

<br/>

> **ProxyCore** is a powerful, lightweight, all-in-one proxy utilities plugin built for **BungeeCord** and **Velocity** networks.
> 20 essential commands, automatic announcements, maintenance mode, private messaging, staff tools — all in a single plugin with **zero external dependencies**.

<br/>

</div>

---

## 📋 Table of Contents

- [Features](#-features)
- [Requirements](#-requirements)
- [Installation](#-installation)
- [Commands](#-commands)
- [Permissions](#-permissions)
- [Configuration](#-configuration)
- [API](#-api)
- [Roadmap](#-roadmap)
- [Credits](#-credits)
- [License](#-license)

---

## ✨ Features

<div align="center">

| 🔍 Network Info | 📢 Communication | 🚀 Player Management | ⚙️ Administration |
|:---:|:---:|:---:|:---:|
| Find players | Global announcements | Send players across servers | Maintenance mode |
| Server list | Staff chat | Move all players at once | Network-wide alerts |
| Network stats | Private messages | Kick from proxy | Config hot-reload |
| Ping checker | Reply system | Staff list | Uptime display |
| IP lookup | Broadcast with prefix | Force commands (sudo) | Per-server player list |

</div>

<br/>

- ✅ **Dual platform** — One codebase, two JARs: BungeeCord & Velocity
- ✅ **Zero dependencies** — No external libraries required at runtime
- ✅ **Hot reload** — Apply config changes without restarting the proxy
- ✅ **Auto announcements** — Rotating messages with a configurable interval
- ✅ **Maintenance mode** — Kicks non-staff players and blocks new joins
- ✅ **Developer API** — Clean `proxycore-api` module for building addons
- ✅ **Multi-module Maven** — `proxycore-api`, `proxycore-bungeecord`, `proxycore-velocity`

---

## 📦 Requirements

| Requirement | Version |
|-------------|---------|
| Java | 17 or higher |
| BungeeCord | 1.20+ |
| Velocity | 3.x |
| Maven | 3.8+ *(for building from source)* |

---

## 🚀 Installation

### Pre-built JAR *(recommended)*

1. Download the correct JAR from [Releases](https://github.com/YesithTK/ProxyCore/releases):
   - `ProxyCore-BungeeCord-1.0.0.jar` → for BungeeCord
   - `ProxyCore-Velocity-1.0.0.jar` → for Velocity
2. Drop it into your proxy's `plugins/` folder.
3. Start or restart the proxy.
4. Edit the generated `plugins/ProxyCore/config.yml` and `messages.yml`.
5. Run `/proxyreload` to apply changes without restarting.

### Build from Source

```bash
# Clone the repository
git clone https://github.com/YesithTK/ProxyCore.git
cd ProxyCore

# Build BungeeCord JAR
mvn clean package -pl proxycore-bungeecord -am

# Build Velocity JAR
mvn clean package -pl proxycore-velocity -am
```

Output JARs:
- `proxycore-bungeecord/target/ProxyCore-BungeeCord-1.0.0.jar`
- `proxycore-velocity/target/ProxyCore-Velocity-1.0.0.jar`

---

## 💬 Commands

> **Note:** Velocity command names are prefixed with `v` — e.g. `/glist` → `/vglist`, `/send` → `/vsend`.

### 🔍 Network Information

| Command | Description | Permission |
|---------|-------------|------------|
| `/find <player>` | Show which server a player is on | `proxycore.find` |
| `/glist` | List all servers with their player counts | `proxycore.glist` |
| `/network` | Display global network stats | `proxycore.network` |
| `/pping [player]` | Check your own or another player's ping | `proxycore.ping` |
| `/pip <player>` | Retrieve a player's IP address *(admin)* | `proxycore.ip` |

### 📢 Communication

| Command | Description | Permission |
|---------|-------------|------------|
| `/announce <message>` | Broadcast a global announcement | `proxycore.announce` |
| `/staffchat <message>` | Send a message visible only to staff | `proxycore.staffchat` |
| `/pmsg <player> <message>` | Send a private message across servers | `proxycore.msg` |
| `/reply <message>` | Reply to your last private message | `proxycore.msg` |
| `/pbroadcast <message>` | Network-wide broadcast with custom prefix | `proxycore.broadcast` |

### 🚀 Player Management

| Command | Description | Permission |
|---------|-------------|------------|
| `/psend <player> <server>` | Move a player to another server | `proxycore.send` |
| `/sendall <server>` | Move all online players to a server | `proxycore.sendall` |
| `/pkick <player> [reason]` | Kick a player from the entire network | `proxycore.kick` |
| `/stafflist` | List all currently online staff members | `proxycore.stafflist` |
| `/psudo <player> <command>` | Force a player to execute a command | `proxycore.sudo` |

### ⚙️ Administration

| Command | Description | Permission |
|---------|-------------|------------|
| `/maintenance <on\|off>` | Toggle maintenance mode on the network | `proxycore.maintenance` |
| `/alert <message>` | Send a highlighted alert box to all players | `proxycore.alert` |
| `/plist <server>` | List all players on a specific server | `proxycore.plist` |
| `/proxyreload` | Reload ProxyCore config without restarting | `proxycore.reload` |
| `/uptime` | Show how long the network has been running | `proxycore.uptime` |

---

## 🔐 Permissions

| Permission | Description | Default |
|------------|-------------|---------|
| `proxycore.find` | Use `/find` | `true` |
| `proxycore.glist` | Use `/glist` | `true` |
| `proxycore.network` | Use `/network` | `true` |
| `proxycore.ping` | Check own ping | `true` |
| `proxycore.ping.others` | Check other players' ping | `op` |
| `proxycore.ip` | View a player's IP address | `op` |
| `proxycore.announce` | Send global announcements | `op` |
| `proxycore.broadcast` | Send network-wide broadcasts | `op` |
| `proxycore.staffchat` | Access and read staff chat | `op` |
| `proxycore.msg` | Send and receive private messages | `true` |
| `proxycore.send` | Move players between servers | `op` |
| `proxycore.sendall` | Move all players to a server | `op` |
| `proxycore.kick` | Kick players from the network | `op` |
| `proxycore.stafflist` | View the online staff list | `true` |
| `proxycore.staff` | Appear in `/stafflist` | `op` |
| `proxycore.sudo` | Force players to run commands | `op` |
| `proxycore.maintenance` | Toggle maintenance mode | `op` |
| `proxycore.maintenance.bypass` | Join the network during maintenance | `op` |
| `proxycore.alert` | Send network-wide alert messages | `op` |
| `proxycore.plist` | List players on a specific server | `true` |
| `proxycore.reload` | Reload the plugin configuration | `op` |
| `proxycore.uptime` | Check network uptime | `true` |

---

## ⚙️ Configuration

### `config.yml`

```yaml
# ProxyCore Configuration — by YesithTK

maintenance:
  enabled: false          # Set true to enable maintenance on startup

announcements:
  enabled: true
  interval: 60            # Seconds between each auto-announcement
  messages:
    - "&6Welcome to the network! Enjoy your stay."
    - "&bJoin our Discord for news and updates!"
    - "&aReport bugs with /report in-game."
    - "&dFollow us on social media for events and giveaways!"
```

### `messages.yml`

```yaml
# ProxyCore Messages — use & for color codes

prefix: "&8[&6ProxyCore&8] &r"

no-permission:       "&cYou don't have permission to do that."
player-not-found:    "&cPlayer &e%player% &cnot found or offline."
default-kick-reason: "&cYou have been kicked from the network."
maintenance-kick: |-
  &c&lServer Maintenance

  &7The network is currently under maintenance.
  &7Please try again later.

find-result:       "&a%player% &7is connected to &e%server%&7."
announce-prefix:   "&8[&6Announce&8] &r"
broadcast-prefix:  "&8[&4Broadcast&8] &r"
```

---

## 🧩 API

ProxyCore exposes a clean `proxycore-api` module so developers can build addons or integrate with the plugin without touching platform-specific code.

### Project Structure

```
ProxyCore/
├── proxycore-api/               ← Shared interfaces & events
│   └── dev.yesithx.proxycore.api
│       ├── IProxyCorePlugin.java
│       ├── ProxyCoreAPI.java
│       ├── manager/
│       │   ├── IMessageManager.java
│       │   ├── IMaintenanceManager.java
│       │   └── IAnnounceManager.java
│       ├── command/
│       │   ├── ProxyCoreCommandSender.java
│       │   └── NetworkPlayer.java
│       └── event/
│           ├── ProxyCoreEvent.java
│           ├── MaintenanceToggleEvent.java
│           └── NetworkAnnounceEvent.java
├── proxycore-bungeecord/        ← BungeeCord implementation
└── proxycore-velocity/          ← Velocity implementation
```

### Maven Dependency

```xml
<dependency>
    <groupId>dev.yesithx</groupId>
    <artifactId>proxycore-api</artifactId>
    <version>1.0.0</version>
    <scope>provided</scope>
</dependency>
```

### Usage Example

```java
import dev.yesithx.proxycore.api.ProxyCoreAPI;
import dev.yesithx.proxycore.api.IProxyCorePlugin;

// Safe check before using
if (ProxyCoreAPI.isAvailable()) {
    IProxyCorePlugin api = ProxyCoreAPI.get();

    // Check maintenance mode
    boolean maintenance = api.getMaintenanceManager().isEnabled();

    // Toggle maintenance
    api.getMaintenanceManager().setEnabled(true);

    // Reload all managers
    api.reload();

    // Check announce scheduler
    int interval = api.getAnnounceManager().getIntervalSeconds();
}
```

### Available Interfaces

| Interface | Package | Description |
|-----------|---------|-------------|
| `IProxyCorePlugin` | `api` | Base plugin interface — access all managers |
| `ProxyCoreAPI` | `api` | Static entry point for addons |
| `IMessageManager` | `api.manager` | Private messaging between players |
| `IMaintenanceManager` | `api.manager` | Maintenance mode control |
| `IAnnounceManager` | `api.manager` | Auto-announcement scheduler control |
| `ProxyCoreCommandSender` | `api.command` | Platform-agnostic command sender |
| `NetworkPlayer` | `api.command` | Platform-agnostic player abstraction |
| `ProxyCoreEvent` | `api.event` | Base class for all ProxyCore events |
| `MaintenanceToggleEvent` | `api.event` | Fired when maintenance is toggled |
| `NetworkAnnounceEvent` | `api.event` | Fired before each auto-announcement |

---

## 🗺️ Roadmap

| Version | Feature |
|---------|---------|
| `v1.1.0` | LuckPerms integration for permission-based staff detection |
| `v1.1.0` | `/report` command with staff notification system |
| `v1.2.0` | Configurable join/leave messages per server |
| `v1.2.0` | BossBar announcements as alternative to chat |
| `v1.3.0` | MySQL support for cross-restart data persistence |
| `v1.3.0` | REST API for external network monitoring |
| `v2.0.0` | Full PlaceholderAPI support |
| `v2.0.0` | Plugin Messaging Channel support for backend servers |

---

## 👤 Credits

<div align="center">

| Role | Name |
|------|------|
| 🧑‍💻 Developer & Maintainer | **YesithTK** |
| 🏗️ Architecture & Design | **YesithTK** |
| 📖 Documentation | **YesithTK** |

<br/>

*Built with ❤️ for the Minecraft network community.*

</div>

---

## 📄 License

```
Copyright (c) 2026 YesithTK. All Rights Reserved.

This software and its source code are the exclusive property of YesithTK.
No part of this software may be reproduced, distributed, modified, or used
in any form without the prior written permission of the author.

Unauthorized copying, forking, or redistribution of this repository,
via any medium, is strictly prohibited.
```

---

<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0f3460,50:16213e,100:1a1a2e&height=100&section=footer" width="100%"/>

*© 2026 YesithTK — ProxyCore. All Rights Reserved.*

</div>
