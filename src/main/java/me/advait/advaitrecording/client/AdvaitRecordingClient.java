package me.advait.advaitrecording.client;

import com.google.common.base.Strings;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.StickyKeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class AdvaitRecordingClient implements ClientModInitializer {

    /*
    KeyBinding binding = KeyBindingHelper.registerKeyBinding
            (new KeyBinding("key.advaitrecording.enhanced_debug",
                    InputUtil.Type.KEYSYM,
                    GLFW.GLFW_KEY_G,
                    "key.category.first.test"));

     */

    public static MinecraftClient minecraftClient;

    @Override
    public void onInitializeClient() {
        minecraftClient = MinecraftClient.getInstance();
    }


}
