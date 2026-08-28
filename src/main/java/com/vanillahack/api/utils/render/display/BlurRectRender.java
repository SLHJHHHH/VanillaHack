package com.vanillahack.api.utils.render.display;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vanillahack.api.utils.interfaces.QuickImports;
import com.vanillahack.client.features.modules.render.ClickGUIModule;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.joml.Vector4f;

import java.awt.*;

public class BlurRectRender implements QuickImports {
    public void draw(PoseStack matrixStack, float x, float y, float width, float height, float radius, Color color, float mix) {
        draw(matrixStack, x, y, width, height, new Vector4f(radius, radius, radius, radius), color, color, color, color, mix);
    }

    public void draw(PoseStack matrixStack, float x, float y, float width, float height, float radius, Color color) {
        draw(matrixStack, x, y, width, height, radius, color, ClickGUIModule.getGlassy());
    }

    public void draw(PoseStack matrixStack, float x, float y, float width, float height, Vector4f radius, Color color) {
        draw(matrixStack, x, y, width, height, radius, color, color, color, color, ClickGUIModule.getGlassy());
    }

    public void draw(PoseStack matrixStack, float x, float y, float width, float height, Vector4f radius, Color topLeft, Color topRight, Color bottomLeft, Color bottomRight) {
        draw(matrixStack, x, y, width, height, radius, topLeft, topRight, bottomLeft, bottomRight, ClickGUIModule.getGlassy());
    }

    public void draw(PoseStack matrixStack, float x, float y, float width, float height, Vector4f radius, Color topLeft, Color topRight, Color bottomLeft, Color bottomRight, float mix) {
        // Blur draw
    }

    public void draw(GuiGraphicsExtractor graphics, float x, float y, float width, float height, int color) {
        graphics.fill((int) x, (int) y, (int) (x + width), (int) (y + height), color);
    }
}
