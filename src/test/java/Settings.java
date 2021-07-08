import net.flawe.annotations.cfg.Configuration;
import net.flawe.annotations.util.Comment;
import net.flawe.annotations.util.ConfigKey;
import net.flawe.annotations.util.Indent;

import java.util.ArrayList;
import java.util.List;

@Comment({"The test configuration file 1.0", "Author: flawe"})
public class Settings implements Configuration {

    @Indent(1)
    @Comment({"Greeting the player when entering the server", "{player} - replaced to player name"})
    @ConfigKey("hello-message")
    private String hello = "Hello {player}!";
    @Indent(1)
    @Comment("The plugin help message")
    @ConfigKey("help-message")
    private List<String> help = new ArrayList<String>()
    {{
        add("The help page");
        add("- /help - get help");
    }};

    public String getHello(String player) {
        return hello.replace("{player}", player);
    }

    public List<String> getHelp() {
        return help;
    }
}
