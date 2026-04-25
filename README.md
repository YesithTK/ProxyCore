# ProxyCore

All-in-one proxy utilities plugin for **BungeeCord** and **Velocity** networks.

**by YesithTK**

---

## Features — 20 Commands

| Command | Description | Permission |
|---------|-------------|------------|
| `/find <player>` | Find which server a player is on | `proxycore.find` |
| `/glist` | List all servers with player counts | `proxycore.glist` |
| `/network` | Global network stats | `proxycore.network` |
| `/pping [player]` | Check ping | `proxycore.ping` |
| `/pip <player>` | Get a player's IP (admin) | `proxycore.ip` |
| `/announce <msg>` | Global announcement | `proxycore.announce` |
| `/staffchat <msg>` | Staff-only chat | `proxycore.staffchat` |
| `/pmsg <player> <msg>` | Private message across servers | `proxycore.msg` |
| `/reply <msg>` | Reply to last message | `proxycore.msg` |
| `/pbroadcast <msg>` | Network-wide broadcast | `proxycore.broadcast` |
| `/psend <player> <server>` | Move a player to a server | `proxycore.send` |
| `/sendall <server>` | Move all players to a server | `proxycore.sendall` |
| `/pkick <player> [reason]` | Kick a player from the network | `proxycore.kick` |
| `/stafflist` | List online staff members | `proxycore.stafflist` |
| `/psudo <player> <cmd>` | Force a player to run a command | `proxycore.sudo` |
| `/maintenance <on\|off>` | Toggle maintenance mode | `proxycore.maintenance` |
| `/alert <msg>` | Send a highlighted alert to all | `proxycore.alert` |
| `/plist <server>` | List players on a specific server | `proxycore.plist` |
| `/proxyreload` | Reload ProxyCore config | `proxycore.reload` |
| `/uptime` | Show network uptime | `proxycore.uptime` |

> Velocity versions of all commands are prefixed with `v` (e.g. `/vglist`, `/vsend`).

---

## Building

```bash
mvn clean package -pl proxycore-bungeecord -am   # BungeeCord JAR
mvn clean package -pl proxycore-velocity -am      # Velocity JAR
```

JARs will be in `proxycore-bungeecord/target/` and `proxycore-velocity/target/`.

---

## Installation

1. Drop the correct JAR into your proxy's `plugins/` folder.
2. Start the proxy once to generate `config.yml` and `messages.yml`.
3. Configure as needed and use `/proxyreload` to apply changes.

---

## Permissions

- `proxycore.staff` — Marks a player as staff (shows in `/stafflist`)
- `proxycore.maintenance.bypass` — Bypass maintenance mode kick
- `proxycore.ping.others` — Check other players' ping

## License
Copyright © 2026 YesithTK — All Rights Reserved.
Unauthorized use, copying or distribution of this plugin is strictly prohibited.
