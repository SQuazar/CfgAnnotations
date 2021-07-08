import net.flawe.annotations.ConfigurationLoader;
import net.flawe.annotations.cfg.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

public class ConfigurationTest {

    private File file;
    private Settings settings;

    @Before
    public void init() {
        file = new File("src/test/resources", "config.yml");
        settings = new Settings();
    }

    @Test
    public void createAndLoadConfiguration() {
        loadAndSave(settings, file);
    }

    private void loadAndSave(Configuration configuration, File file) {
        ConfigurationLoader.loadConfiguration(configuration, YamlConfiguration.loadConfiguration(file));
        try {
            ConfigurationLoader.saveConfiguration(configuration, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getHelloMessage() {
        loadAndSave(settings, file);
        String hello = settings.getHello("flaweoff");
        System.out.println(hello);
    }

    @Test
    public void getHelpMessage() {
        loadAndSave(settings, file);
        System.out.println(settings.getHelp().stream().map(s -> s + "\n").collect(Collectors.joining()));
    }

}
