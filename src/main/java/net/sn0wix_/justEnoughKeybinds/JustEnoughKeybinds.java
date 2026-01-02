package net.sn0wix_.justEnoughKeybinds;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.util.Identifier;
import net.sn0wix_.justEnoughKeybinds.config.*;
import net.sn0wix_.justEnoughKeybinds.events.ClientEndTickEvent;
import net.sn0wix_.justEnoughKeybinds.keybinds.ChatKeys;
import net.sn0wix_.justEnoughKeybinds.keybinds.NotEKKeyBindings;
import net.sn0wix_.justEnoughKeybinds.keybinds.presets.PresetLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JustEnoughKeybinds implements ClientModInitializer {

    public static final String MOD_ID = "just-enough-keybinds";
    public static final String MOD_NAME = "JustEnoughKeybinds";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Identifier ICON = Identifier.of(MOD_ID, "icon.png");

    public static final DebugKeysConfig DEBUG_KEYS_CONFIG = DebugKeysConfig.getConfig();
    public static final ChatKeysConfig CHAT_KEYS_CONFIG = ChatKeysConfig.getConfig();
    public static final NotEKSettings GENERAL_CONFIG = NotEKSettings.getConfig();


    @Override
    public void onInitializeClient() {
        NotEKKeyBindings.registerModKeybinds();

        ClientTickEvents.END_CLIENT_TICK.register(new ClientEndTickEvent());
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> ChatKeys.CHAT_KEYS_CATEGORY.initializeKeys());

        PresetLoader.init();
    }

    public static Identifier getIdentifier(String path) {
        return Identifier.of(MOD_ID, path);
    }
}