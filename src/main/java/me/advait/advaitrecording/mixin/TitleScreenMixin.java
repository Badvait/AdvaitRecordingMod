package me.advait.advaitrecording.mixin;

import me.advait.advaitrecording.AdvaitServerScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "switchToRealms", at = @At("HEAD"), cancellable = true)
    private void switchToRealms(CallbackInfo ci) {
        MinecraftClient.getInstance().setScreen(new AdvaitServerScreen(this));
        ci.cancel();
    }

}
