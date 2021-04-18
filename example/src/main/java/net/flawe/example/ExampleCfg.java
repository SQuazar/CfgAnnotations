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
