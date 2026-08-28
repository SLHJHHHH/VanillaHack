package com.vanillahack.api.utils.color;

import java.awt.Color;

public final class ColorUtil {
    private ColorUtil() {}

    public static int rgba(int r, int g, int b, int a) {
        return ((a & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | (b & 0xFF);
    }

    public static int rgb(int r, int g, int b) {
        return rgba(r, g, b, 255);
    }

    public static int getColor(int r, int g, int b, int a) {
        return rgba(r, g, b, a);
    }

    public static Color injectAlpha(Color color, int alpha) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), Math.max(0, Math.min(255, alpha)));
    }

    public static int injectAlpha(int color, int alpha) {
        int cappedAlpha = Math.max(0, Math.min(255, alpha));
        return (cappedAlpha << 24) | (color & 0x00FFFFFF);
    }

    public static Color interpolate(Color start, Color end, float factor) {
        float f = Math.max(0f, Math.min(1f, factor));
        int r = (int) (start.getRed() + f * (end.getRed() - start.getRed()));
        int g = (int) (start.getGreen() + f * (end.getGreen() - start.getGreen()));
        int b = (int) (start.getBlue() + f * (end.getBlue() - start.getBlue()));
        int a = (int) (start.getAlpha() + f * (end.getAlpha() - start.getAlpha()));
        return new Color(r, g, b, a);
    }

    public static float[] normalize(int color) {
        return new float[]{
                ((color >> 16) & 0xFF) / 255.0f,
                ((color >> 8) & 0xFF) / 255.0f,
                (color & 0xFF) / 255.0f,
                ((color >> 24) & 0xFF) / 255.0f
        };
    }

    public static float[] normalize(Color color) {
        if (color == null) return new float[]{1f, 1f, 1f, 1f};
        return new float[]{
                color.getRed() / 255.0f,
                color.getGreen() / 255.0f,
                color.getBlue() / 255.0f,
                color.getAlpha() / 255.0f
        };
    }

    public static int gradient(int color1, int color2, float progress, float total, float time, float offset) {
        float factor = (float) Math.sin((progress / Math.max(1f, total) + time) * Math.PI * 2) * 0.5f + 0.5f;
        Color c1 = new Color(color1, true);
        Color c2 = new Color(color2, true);
        return interpolate(c1, c2, factor).getRGB();
    }
}
