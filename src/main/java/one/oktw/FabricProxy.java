package one.oktw;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import tv.quaint.objects.handling.derived.ModEventable;

import java.util.List;
import java.util.Set;

public class FabricProxy implements IMixinConfigPlugin {
    public static class FBEventable extends ModEventable {
        public FBEventable() {
            super("FabricProxy-ReMaintained", true);
        }
    }

    public static FBEventable eventable;

    public static ModConfig config;
    private final Logger logger = LogManager.getLogger("FabricProxy");

    @Override
    public void onLoad(String mixinPackage) {
        eventable = new FBEventable();
        if (config == null) {
            config = new ModConfig();
        }
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        String module = mixinClassName.split("\\.")[3];
        if (module.equals("bungee") && config.getBungeeCord()) {
            logger.info("BungeeCord support injected: {}", mixinClassName);
            return true;
        }

        if (module.equals("velocity") && config.getVelocity()) {
            if (config.getSecret().isEmpty()) {
                logger.error("Error: velocity secret is empty!");
            } else {
                logger.info("Velocity support injected: {}", mixinClassName);
                return true;
            }
        }

        return false;
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
