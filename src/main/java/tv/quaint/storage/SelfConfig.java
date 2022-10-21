package tv.quaint.storage;

import de.leonhard.storage.Config;
import lombok.Getter;
import tv.quaint.Manager;
import tv.quaint.storage.resources.flat.simple.SimpleConfiguration;

import java.io.File;

public class SelfConfig extends SimpleConfiguration {
    @Getter
    private static final File modsFolder = new File(System.getProperty("user.dir"), "mods" + File.separator);
    @Getter
    private static final File selfFolder = new File(getModsFolder(), "FabricProxy" + File.separator);

    public SelfConfig() {
        super("config.yml", Manager.getInstance(), true);
    }

    public String getKickMessage() {
        reloadResource();

        return getOrSetDefault("messages.kick",
                "&cYou must join through the main proxy&8!\n&eYou can connect correctly at the IP address of&8:\n\n&bplasmere.net");
    }

    @Override
    public void init() {
        getKickMessage();
    }
}
