package com.vanillahack.api.utils.interfaces;

import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;

public interface QuickImports {
    Minecraft mc = Minecraft.getInstance();

    default Minecraft getMinecraft() {
        return Minecraft.getInstance();
    }

    default LocalPlayer getPlayer() {
        return Minecraft.getInstance().player;
    }

    default ClientLevel getLevel() {
        return Minecraft.getInstance().level;
    }

    default Window getWindow() {
        return Minecraft.getInstance().getWindow();
    }

    default Font getFont() {
        return Minecraft.getInstance().font;
    }
}
