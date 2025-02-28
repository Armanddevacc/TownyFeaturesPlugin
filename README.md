# 🏙️ Towny Features Plugin - Reputation System for Towny  

## ⚠️ Project Status: Outdated  
This project was developed **over 5 years ago** and is now **outdated**. Some dependencies or functionalities may no longer work with the latest **Minecraft versions** or **Towny updates**. Contributions are welcome if anyone wants to **update or maintain** this plugin.  

---

## 🌟 Overview  
This plugin enhances the **Towny Minecraft Plugin** by introducing a **reputation system** for **players, towns, and nations**. Reputation is earned or lost based on various in-game actions, allowing for a more dynamic and immersive town-building experience.

---

## 🔥 Features  
✅ **Player Reputation** → Track and display individual reputation levels  
✅ **Town Reputation** → Towns gain or lose reputation based on citizen actions  
✅ **Nation Reputation** → Nations develop reputations based on alliances and conflicts  
✅ **Configurable Settings** → Adjust how reputation is gained or lost  
✅ **Integration with Towny** → Works seamlessly with the Towny plugin  

---

## 🛠️ Installation  

### 📥 1. Download  
- **⚠️ Note:** The plugin may not work with recent Towny/Minecraft versions.  
- Download the latest **TownyFeaturesPlugin.jar** from the [Releases](https://github.com/Armanddevacc/TownyFeaturesPlugin/releases) page.  

### 📂 2. Place in Plugins Folder  
Move the `.jar` file into your **Minecraft server's** `plugins/` directory.

### ▶️ 3. Restart Server  
Restart your server to load the plugin.  

---

## ⚙️ Configuration  
A `config.yml` file will be generated in the plugin's folder upon first startup.  

### Example Config:
```yaml
reputation:
  max: 100
  min: -100
  default: 0
  actions:
    kill_mob: 1
    help_player: 5
    betray_town: -10
```

Modify these values to customize reputation gain/loss in your server.

### 🎮 Commands & Permissions

## 📝 Commands:
Command	Description
```bash
/rep	Check your reputation
/town rep	View your town's reputation
/nation rep	View your nation's reputation
/rep give <player> <amount>	Grant reputation points
/rep take <player> <amount>	Remove reputation points
```
## 🔐 Permissions:
Permission	Description
townyfeatures.rep.view	Allows players to check their reputation
townyfeatures.rep.admin	Allows admins to modify reputation
### 🛠️ Development

## 🚀 Building from Source
Clone the repository:
```bash
git clone https://github.com/Armanddevacc/TownyFeaturesPlugin.git
cd TownyFeaturesPlugin
Build the plugin using Maven:
mvn clean package
```
The compiled .jar file will be in the target/ folder.
## 📌 Future Plans (If Updated)

🔹 Update compatibility with newer versions of Minecraft & Towny
🔹 Add more ways to earn/lose reputation
🔹 Implement visual indicators for reputation (prefixes, scoreboard)
🔹 Introduce leaderboards for top towns/nations

## 🤝 Contributing

Since this project is outdated, contributions to update it are highly appreciated! Feel free to fork the repo and submit a pull request.
