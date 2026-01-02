package net.sn0wix_.justEnoughKeybinds.events;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.sn0wix_.justEnoughKeybinds.JustEnoughKeybinds;
import net.sn0wix_.justEnoughKeybinds.keybinds.NotEKKeyBindings;

public class ClientEndTickEvent implements ClientTickEvents.EndTick {

    @Override
    public void onEndTick(MinecraftClient client) {
        try {
            NotEKKeyBindings.getModKeybindsAsList().forEach(modKeyBinding -> modKeyBinding.tick(client));
        } catch (Exception e) {
            JustEnoughKeybinds.LOGGER.error("Something went wrong with executing keybinding behavior.", e);
        }
    }
}
