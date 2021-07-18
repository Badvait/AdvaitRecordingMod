package me.advait.advaitrecording.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class AdvaitRecordingClient implements ClientModInitializer {

    public static MinecraftClient minecraftClient;

    @Override
    public void onInitializeClient() {
        minecraftClient = MinecraftClient.getInstance();
    }

}
