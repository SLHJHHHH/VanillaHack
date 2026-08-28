package com.vanillahack.api.utils.render.display;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.joml.Vector4f;

import java.awt.Color;

public class RectRender {
    public void draw(PoseStack matrixStack, float x, float y, float width, float height, float radius, Color color) {
        draw(matrixStack, x, y, width, height, new Vector4f(radius, radius, radius, radius), color);
    }

    public void draw(PoseStack matrixStack, float x, float y, float width, float height, float radius, int color) {
        draw(matrixStack, x, y, width, height, radius, new Color(color, true));
    }

    public void draw(PoseStack matrixStack, float x, float y, float width, float height, Vector4f radius, Color color) {
        // 2D rect rendering via matrixStack
    }

    public void draw(GuiGraphicsExtractor graphics, float x, float y, float width, float height, int color) {
        graphics.fill((int) x, (int) y, (int) (x + width), (int) (y + height), color);
    }

    public void draw(GuiGraphicsExtractor graphics, float x, float y, float width, float height, Color color) {
        draw(graphics, x, y, width, height, color.getRGB());
    }

    public void drawOutline(GuiGraphicsExtractor graphics, float x, float y, float width, float height, int color) {
        graphics.outline((int) x, (int) y, (int) width, (int) height, color);
    }
}
