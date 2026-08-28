package com.vanillahack.api.utils.render.display;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vanillahack.api.utils.interfaces.QuickImports;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import org.joml.Vector4f;

import java.awt.*;

public class TextureRectRender implements QuickImports {
    public void drawHead(PoseStack matrixStack, Player player, float x, float y, float width, float height, float gap, float radius, Color color) {
        if (!(player instanceof AbstractClientPlayer clientPlayer)) return;
        Identifier skin = clientPlayer.getSkin().body().id();
        float u = 8f / 64f;
        float u2 = 40f / 64f;

        float superGap = gap * 2f;
        draw(matrixStack, x + gap, y + gap, width - superGap, height - superGap, radius, color, u, u, u, u, skin);
        draw(matrixStack, x, y, width, height, radius, color, u2, u, u, u, skin);
    }

    public void draw(PoseStack matrixStack, float x, float y, float width, float height, float radius, Color color, float u, float v, float texWidth, float texHeight, Identifier texture) {
        draw(matrixStack, x, y, width, height, new Vector4f(radius, radius, radius, radius), color, u, v, texWidth, texHeight, texture);
    }

    public void drawRoundedHead(PoseStack matrixStack, Player player, float x, float y, float width, float height, float radius, Color color) {
        drawHead(matrixStack, player, x, y, width, height, 0f, radius, color);
    }

    public void draw(PoseStack matrixStack, float x, float y, float width, float height, Vector4f radius, Color color, float u, float v, float texWidth, float texHeight, Identifier texture) {
        // Texture draw
    }

    public void draw(GuiGraphicsExtractor graphics, Identifier texture, int x, int y, int width, int height, float u, float v, float texWidth, float texHeight) {
        graphics.blit(texture, x, y, width, height, u, v, texWidth, texHeight);
    }
}
