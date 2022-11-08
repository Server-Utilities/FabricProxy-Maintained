package one.oktw;

import tv.quaint.storage.resources.flat.simple.SimpleConfiguration;

public class ModConfig extends SimpleConfiguration {

    public ModConfig() {
        super("config.yml", FabricProxy.eventable, false);
    }

    @Override
    public void init() {
        getVelocity();
        getBungeeCord();
        getBungeeCordWorkaround();
        getSecret();
        getAllowBypassProxy();
        getDisconnectMessage();
    }

    public boolean getVelocity() {
        reloadResource();

        return getOrSetDefault("is.velocity", false);
    }

    public boolean getBungeeCord() {
        reloadResource();

        return getOrSetDefault("is.bungeecord", true);
    }

    public boolean getBungeeCordWorkaround() {
        reloadResource();

        return getOrSetDefault("is.bungeecord-workaround", true);
    }

    public String getSecret() {
        reloadResource();

        return getOrSetDefault("secret", "");
    }

    public boolean getAllowBypassProxy() {
        reloadResource();

        return getOrSetDefault("allow.bypass.proxy", false);
    }

    public String getDisconnectMessage() {
        reloadResource();

        return getOrSetDefault("messages.kick", "&cYou must join through the main proxy&8!\n&eYou can connect correctly at the IP address of&8:\n\n&bplasmere.net");
    }

    public boolean getHackEarlySend() {
        reloadResource();

        return getOrSetDefault("hack.early-send", true);
    }
}
