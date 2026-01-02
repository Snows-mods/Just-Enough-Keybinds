package net.sn0wix_.justEnoughKeybinds.keybinds;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.world.ClientWorld;
import net.sn0wix_.justEnoughKeybinds.JustEnoughKeybinds;
import net.sn0wix_.justEnoughKeybinds.keybinds.custom.KeybindCategory;
import net.sn0wix_.justEnoughKeybinds.keybinds.custom.NotEKKeyBinding;

public class MiscKeys extends NotEKKeyBindings{
    public static final String MISC_CATEGORY_KEY = JustEnoughKeybinds.getIdentifier("misc").toTranslationKey("key.category");

    public static final NotEKKeyBinding DISCONNECT = registerModKeyBinding(new NotEKKeyBinding("disconnect", MISC_CATEGORY_KEY, (client, keyBinding) -> {
        client.getAbuseReportContext().tryShowDraftScreen(client, new GameMenuScreen(true), () -> GameMenuScreen.disconnect(client, ClientWorld.QUITTING_MULTIPLAYER_TEXT), true);
    }));

    @Override
    public KeybindCategory getCategory() {
        return new KeybindCategory(MISC_CATEGORY_KEY, 2, false, DISCONNECT);
    }
}
