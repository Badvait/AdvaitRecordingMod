package me.advait.advaitrecording.mixin;


import com.google.common.base.Strings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.DebugHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Mixin(DebugHud.class)
public abstract class DebugHudMixin {

    @Shadow protected abstract List<String> getLeftText();


    @Inject(at = @At("HEAD"), method = "getLeftText", cancellable = true)
    private void getLeftText(CallbackInfoReturnable<List<String>> cir) {
        List<String> list = new ArrayList<>();
        list.add((String.format
                (Locale.ROOT, "XYZ: %.3f / %.5f / %.3f",
                        MinecraftClient.getInstance().getCameraEntity().getX(),
                        MinecraftClient.getInstance().getCameraEntity().getY(),
                        MinecraftClient.getInstance().getCameraEntity().getZ())));
        cir.setReturnValue(list);
    }


    @Shadow @Final private TextRenderer textRenderer;

    @Inject(at = @At("HEAD"), method = "getRightText", cancellable = true)
    private void getRightText(CallbackInfoReturnable<List<String>> cir) {
        cir.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderLeftText", cancellable = true)
    private void renderLeftText(MatrixStack matrices, CallbackInfo ci) {
        getLeftText().clear();
        getLeftText().add((String.format
                (Locale.ROOT, "XYZ: %.3f / %.5f / %.3f",
                        MinecraftClient.getInstance().getCameraEntity().getX(),
                        MinecraftClient.getInstance().getCameraEntity().getY(),
                        MinecraftClient.getInstance().getCameraEntity().getZ())));
        for(int i = 0; i < getLeftText().size(); ++i) {
            String string = (String)getLeftText().get(i);
            if (!Strings.isNullOrEmpty(string)) {
                Objects.requireNonNull(this.textRenderer);
                int j = 9;
                int k = this.textRenderer.getWidth(string);
                int m = 2 + j * i;
                DrawableHelper.fill(matrices, 1, m - 1, 2 + k + 1, m + j - 1, -1873784752);
                this.textRenderer.draw(matrices, string, 2.0F, (float)m, 14737632);
            }
        }
        ci.cancel();

    }

    @Inject(at = @At("HEAD"), method = "renderRightText", cancellable = true)
    private void renderRightText(MatrixStack matrices, CallbackInfo ci) {
        ci.cancel();
    }

}