package net.sn0wix_.justEnoughKeybinds.compat;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.sn0wix_.justEnoughKeybinds.gui.screen.keybindsScreen.NotEKSettingsScreen;

public class ModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return NotEKSettingsScreen::new;
    }
}
