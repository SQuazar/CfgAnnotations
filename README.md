# CfgAnnotations

This is my library for advanced configuration management.

# Features

<ul>
<li>Add comments to configuration</li>
<li>Easy configuration setup and management</li>
<li>Flexible customization using annotations</li>
</ul>

# Maven

Add the CodeMC Repo:

```xml

<repositories>
    <repository>
        <id>codemc-repo</id>
        <url>https://repo.codemc.io/repository/maven-public/</url>
    </repository>
</repositories>
```

And add the CfgAnnotations dependency:

```xml
<dependencies>
    <dependency>
        <groupId>net.flawe</groupId>
        <artifactId>annotations</artifactId>
        <version>1.0.1-SNAPSHOT</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

# Gradle

Add the CodeMC Repo:

```groovy
repositories {
    maven {
        url 'https://repo.codemc.io/repository/maven-public/'
    }
}
```

And add the CfgAnnotations dependency:

```groovy
dependencies {
    implementation 'net.flawe:annotations:1.0.1-SNAPSHOT'
}
```

# API Usage Example

Create your configuration class:

```java
package net.flawe.example;

import net.flawe.annotations.cfg.Configuration;
import net.flawe.annotations.util.Comment;
import net.flawe.annotations.util.ConfigKey;
import net.flawe.annotations.util.Indent;

@Comment("This is example configuration")
public class ExampleCfg implements Configuration {

    @Comment("Configuration version")
    @Indent(1)
    @ConfigKey("version")
    private String version = "1.0";
    @Comment("Welcome message")
    @ConfigKey("welcome-message")
    private String welcomeMessage = "&6Welcome to the server!";
    @Comment("Start player balance")
    @Indent(1)
    @ConfigKey("start-balance")
    private double startBalance = 1000.0;

    public String getVersion() {
        return version;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public double getStartBalance() {
        return startBalance;
    }
}
```

And create plugin's main class:

```java
package net.flawe.example;

import net.flawe.annotations.ConfigurationLoader;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Example extends JavaPlugin implements Listener {

    private final ExampleCfg config = new ExampleCfg();

    @Override
    public void onEnable() {
        ConfigurationLoader.loadConfiguration(config, getConfig());
        try {
            ConfigurationLoader.saveConfiguration(config, new File(getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        getLogger().info("Config version is " + config.getVersion());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().sendMessage(ChatColor
                .translateAlternateColorCodes('&', config.getWelcomeMessage()));
    }
}
```
