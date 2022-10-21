package one.oktw.mixin.startup;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tv.quaint.Manager;

import java.util.function.Function;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Inject(method = "startServer", at = @At(value = "HEAD"))
    private static <S> void startServer(Function<Thread, S> serverFactory, CallbackInfoReturnable<S> cir) {
        new Manager();
    }
}
