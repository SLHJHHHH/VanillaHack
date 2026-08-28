package com.vanillahack.api.utils.render;

import com.mojang.blaze3d.vertex.PoseStack;
import org.joml.Vector3f;

import java.awt.Color;

public final class CrystalRender {

    private static final Vector3f[] VERTICES = new Vector3f[]{
            new Vector3f(0.0F, 1.5F, 0.0F),
            new Vector3f(0.0F, -1.5F, 0.0F),
            new Vector3f(1.0F, 0.0F, 0.0F),
            new Vector3f(-1.0F, 0.0F, 0.0F),
            new Vector3f(0.0F, 0.0F, 1.0F),
            new Vector3f(0.0F, 0.0F, -1.0F)
    };

    private static final int[][] FACES = new int[][]{
            {0, 2, 4}, {0, 4, 3}, {0, 3, 5}, {0, 5, 2},
            {1, 4, 2}, {1, 3, 4}, {1, 5, 3}, {1, 2, 5}
    };

    private static final float[] FACE_BRIGHTNESS = new float[]{
            1.0F, 0.8F, 0.6F, 0.9F, 0.7F, 0.5F, 0.4F, 0.6F
    };

    public static void render(PoseStack matrices, float x, float y, float z, float size, Color color) {
        // Crystal render
    }

    private static int applyBrightness(int color, float brightness) {
        int alpha = (color >> 24) & 255;
        int red = (int) ((float) ((color >> 16) & 255) * brightness);
        int green = (int) ((float) ((color >> 8) & 255) * brightness);
        int blue = (int) ((float) (color & 255) * brightness);
        red = Math.min(255, Math.max(0, red));
        green = Math.min(255, Math.max(0, green));
        blue = Math.min(255, Math.max(0, blue));
        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }

    private CrystalRender() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}