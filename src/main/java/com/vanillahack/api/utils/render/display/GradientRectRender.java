package com.vanillahack.api.utils.render.display;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vanillahack.api.utils.interfaces.QuickImports;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.joml.Vector4f;

import java.awt.Color;

public class GradientRectRender implements QuickImports {
    public void draw(PoseStack matrixStack, float x, float y, float width, float height, float radius, Color topLeft, Color topRight, Color bottomLeft, Color bottomRight) {
        draw(matrixStack, x, y, width, height, new Vector4f(radius), topLeft, topRight, bottomLeft, bottomRight);
    }

    public void draw(PoseStack matrixStack, float x, float y, float width, float height, float radius, int topLeft, int topRight, int bottomLeft, int bottomRight) {
        draw(matrixStack, x, y, width, height, radius, new Color(topLeft, true), new Color(topRight, true), new Color(bottomLeft, true), new Color(bottomRight, true));
    }

    public void draw(PoseStack matrixStack, float x, float y, float width, float height, Vector4f radius, Color topLeft, Color topRight, Color bottomLeft, Color bottomRight) {
        // Gradient rect draw
    }

    public void draw(GuiGraphicsExtractor graphics, float x, float y, float width, float height, int colorFrom, int colorTo) {
        graphics.fillGradient((int) x, (int) y, (int) (x + width), (int) (y + height), colorFrom, colorTo);
    }

    public void draw(GuiGraphicsExtractor graphics, float x, float y, float width, float height, Color colorFrom, Color colorTo) {
        draw(graphics, x, y, width, height, colorFrom.getRGB(), colorTo.getRGB());
    }
}
