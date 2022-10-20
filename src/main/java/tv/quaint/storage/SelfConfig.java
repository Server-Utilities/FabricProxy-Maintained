package tv.quaint.storage;

import de.leonhard.storage.Config;
import lombok.Getter;
import tv.quaint.storage.resources.FlatFileResource;

import java.io.File;

public class SelfConfig extends FlatFileResource<Config> {
    @Getter
    private static final File modsFolder = new File(System.getProperty("user.dir"), "mods" + File.separator);
    @Getter
    private static final File selfFolder = new File(getModsFolder(), "FabricProxy" + File.separator);

    private static SelfConfig instance;

    public static SelfConfig getInstance() {
        if (instance == null) new SelfConfig();
        return instance;
    }

    public SelfConfig() {
        super(Config.class, "config.yml", getSelfFolder(), true);
        instance = this;
    }

    public static String getKickMessage() {
        SelfConfig config = getInstance();
        config.reloadResource();

        return config.getOrSetDefault("messages.kick",
                "&cYou must join through the main proxy&8!\n&eYou can connect correctly at the IP address of&8:\n\n&bplasmere.net");
    }
}
