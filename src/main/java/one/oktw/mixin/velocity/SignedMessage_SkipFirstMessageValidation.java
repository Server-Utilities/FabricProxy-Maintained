package one.oktw.mixin.velocity;

import net.minecraft.network.message.MessageSourceProfile;
import net.minecraft.network.message.SignedMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SignedMessage.class)
public class SignedMessage_SkipFirstMessageValidation {
    private boolean firstMessage = true;

    @Inject(method = "verify(Lnet/minecraft/network/message/MessageSourceProfile;)Z", at = @At(value = "HEAD"), cancellable = true)
    private void allowUnknownMessage(MessageSourceProfile profile, CallbackInfoReturnable<Boolean> cir) {
        if (firstMessage) {
            firstMessage = false;
            cir.setReturnValue(true);
        }
    }
}