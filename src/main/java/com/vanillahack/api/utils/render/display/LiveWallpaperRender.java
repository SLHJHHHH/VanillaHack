package com.vanillahack.api.utils.render.display;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphicsExtractor;

public class LiveWallpaperRender {
    public void draw(PoseStack matrixStack, float x, float y, float width, float height, float timeSec, float mouseX, float mouseY, int style) {
        // Live wallpaper draw
    }

    public void draw(GuiGraphicsExtractor graphics, int width, int height) {
        graphics.fill(0, 0, width, height, 0xFF141414);
    }
}
