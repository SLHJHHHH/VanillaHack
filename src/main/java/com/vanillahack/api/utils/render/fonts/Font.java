package com.vanillahack.api.utils.render.fonts;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vanillahack.api.utils.animation.Easing;
import com.vanillahack.api.utils.color.ColorUtil;
import com.vanillahack.api.utils.files.FileUtil;
import com.vanillahack.api.utils.other.Pair;
import com.vanillahack.api.utils.other.ReplaceUtil;
import com.vanillahack.api.utils.other.TextUtil;
import com.vanillahack.api.utils.render.ScissorUtil;
import com.vanillahack.api.utils.render.fonts.FontData.AtlasData;
import com.vanillahack.api.utils.render.fonts.FontData.MetricsData;
import com.vanillahack.client.services.RenderService;
import lombok.Getter;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.network.chat.Component;

import java.awt.Color;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public final class Font {
    private final String name;
    private final AbstractTexture texture;
    @Getter private final AtlasData atlas;
    @Getter private final MetricsData metrics;
    private final Map<Integer, MsdfGlyph> glyphs;
    private final Map<Integer, Map<Integer, Float>> kernings;

    public Font(String name, AbstractTexture texture, AtlasData atlas, MetricsData metrics, Map<Integer, MsdfGlyph> glyphs, Map<Integer, Map<Integer, Float>> kernings) {
        this.name = name;
        this.texture = texture;
        this.atlas = atlas;
        this.metrics = metrics;
        this.glyphs = glyphs;
        this.kernings = kernings;
    }

    private Pair<Float, Float> offset(float x, float y) {
        float scale = RenderService.getInstance().getScale();

        float x1 = x;
        float y1 = y;

        boolean isPS = name != null && name.contains(Fonts.ps);
        boolean isSF = name != null && name.contains(Fonts.sf);

        if (isSF || isPS) {
            y1 -= scale;
            if (isPS) {
                x1 -= scale / 2f;
            }
        }

        return new Pair<>(x1, y1);
    }

    public void drawText(PoseStack matrixStack, Component text, float x, float y, float size, float thickness, float smoothness, float spacing, int outlineColor, float outlineThickness) {
        if (text == null) return;
        // Text drawing implementation
    }

    public void drawText(PoseStack matrixStack, String text, float x, float y, float size, float thickness, int color, int colorSecond, float offset, float smoothness, float spacing, int outlineColor, float outlineThickness) {
        if (text == null) return;
        // Text drawing implementation
    }

    public void drawText(PoseStack matrixStack, Component text, float x, float y, float size, float thickness) {
        Pair<Float, Float> coordinates = offset(x, y);
        drawText(matrixStack, text, coordinates.left(), coordinates.right(), size, thickness, 0.5f, 0f, -1, thickness);
    }

    public void drawText(PoseStack matrixStack, String text, float x, float y, float size, Color color, float thickness) {
        Pair<Float, Float> coordinates = offset(x, y);
        drawText(matrixStack, text, coordinates.left(), coordinates.right(), size, thickness, color.getRGB(), -1, -1f, 0.5f, 0f, -1, thickness);
    }

    public void drawGradientText(PoseStack matrixStack, String text, float x, float y, float size, Color colorFirst, Color colorSecond, float offset, float thickness) {
        Pair<Float, Float> coordinates = offset(x, y);
        drawText(matrixStack, text, coordinates.left(), coordinates.right(), size, thickness, colorFirst.getRGB(), colorSecond.getRGB(), offset, 0.5f, 0f, -1, thickness);
    }

    public void drawGradientText(PoseStack matrixStack, String text, float x, float y, float size, Color color, Color colorSecond, float offset) {
        drawGradientText(matrixStack, text, x, y, size, color, colorSecond, offset, 0f);
    }

    public void drawText(PoseStack matrixStack, Component text, float x, float y, float size) {
        drawText(matrixStack, text, x, y, size, 0f);
    }

    public void drawText(PoseStack matrixStack, String text, float x, float y, float size, Color color) {
        drawText(matrixStack, text, x, y, size, color, 0f);
    }

    public void drawText(PoseStack matrixStack, String text, float x, float y, float size, int color) {
        drawText(matrixStack, text, x, y, size, new Color(color, true));
    }

    public float getStringWidth(String text, float size) {
        return getWidth(text, size);
    }

    public void drawCenteredText(PoseStack matrixStack, String text, float x, float y, float size, Color color, float thickness) {
        drawText(matrixStack, text, x - getWidth(text, size, thickness) / 2f, y, size, color, thickness);
    }

    public void drawCenteredText(PoseStack matrixStack, String text, float x, float y, float size, Color color) {
        drawCenteredText(matrixStack, text, x, y, size, color, 0f);
    }

    public void drawCenteredGradientText(PoseStack matrixStack, String text, float x, float y, float size, Color color, Color colorSecond, float offset, float thickness) {
        drawGradientText(matrixStack, text, x - getWidth(text, size, thickness) / 2f, y, size, color, colorSecond, offset, thickness);
    }

    public void drawCenteredGradientText(PoseStack matrixStack, String text, float x, float y, float size, Color color, Color colorSecond, float offset) {
        drawCenteredGradientText(matrixStack, text, x, y, size, color, colorSecond, offset, 0f);
    }

    public void drawWrap(PoseStack matrixStack, String text, float x, float y, float width, float size, Color color, float offset, Duration cycleDuration, Duration pauseDuration) {
        if (color.getAlpha() <= 0) return;

        float textWidth = getWidth(text, size);

        if (textWidth <= width) {
            drawText(matrixStack, text, x, y, size, color);
        } else {
            ScissorUtil.start(matrixStack, x, y - size / 4F, width, size * 1.5F);
            long cycleMillis = cycleDuration.toMillis();
            long pauseMillis = pauseDuration.toMillis();
            long totalCycleTime = cycleMillis + pauseMillis;

            long elapsed = System.currentTimeMillis() % totalCycleTime;

            float progress = (elapsed < cycleMillis)
                    ? (float) elapsed / cycleMillis
                    : 1.0F;

            float value = (Easing.SINE_BOTH.apply(progress) * (textWidth + offset));

            drawText(matrixStack, text, x - value, y, size, color);
            drawText(matrixStack, text, x - value + (textWidth + offset), y, size, color);
            ScissorUtil.stop(matrixStack);
        }
    }

    public float getHeight(float size) {
        return size;
    }

    public float getWidth(Component text, float size) {
        return getWidth(text, size, 0f);
    }

    public float getWidth(Component text, float size, float thickness) {
        if (text == null) return 0f;

        List<MsdfGlyph.ColoredGlyph> glyphs = TextUtil.parseTextToColoredGlyphs(text);
        int prevChar = -1;
        float width = 0.0f;

        for (int i = 0; i < glyphs.size(); i++) {
            int _char = glyphs.get(i).c();
            MsdfGlyph glyph = this.glyphs.get(_char);
            if (glyph == null)
                continue;

            Map<Integer, Float> kerning = this.kernings.get(prevChar);
            if (kerning != null) {
                width += kerning.getOrDefault(_char, 0.0f) * size * (1f + thickness);
            }

            width += glyph.getWidth(size);
            prevChar = _char;
        }

        return width;
    }

    public float getWidth(String text, float size) {
        return getWidth(text, size, 0f);
    }

    public float getWidth(String text, float size, float thickness) {
        int prevChar = -1;
        float width = 0.0f;

        String finalText = ReplaceUtil.protectedString(text);

        for (int i = 0; i < finalText.length(); i++) {
            int _char = finalText.charAt(i);
            MsdfGlyph glyph = this.glyphs.get(_char);
            if (glyph == null) continue;

            Map<Integer, Float> kerning = this.kernings.get(prevChar);
            if (kerning != null) {
                width += kerning.getOrDefault(_char, 0.0f) * size * (1f + thickness);
            }
            width += glyph.getWidth(size) * (1f + thickness);
            prevChar = _char;
        }
        return width;
    }

    public static FontBuilder builder() {
        return new FontBuilder();
    }
}
