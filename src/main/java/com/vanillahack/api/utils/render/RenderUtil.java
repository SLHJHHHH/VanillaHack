package com.vanillahack.api.utils.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vanillahack.api.utils.render.display.*;
import lombok.experimental.UtilityClass;

import java.awt.*;

@UtilityClass
public class RenderUtil {
    public RectRender RECT = new RectRender();
    public BlurRectRender BLUR_RECT = new BlurRectRender();
    public GradientRectRender GRADIENT_RECT = new GradientRectRender();
    public TextureRectRender TEXTURE_RECT = new TextureRectRender();

    public OtherRender OTHER = new OtherRender();
    public WorldRender WORLD = new WorldRender();
    public BoxRender BOX = new BoxRender();
    public LiveWallpaperRender LIVE_WALLPAPER = new LiveWallpaperRender();

    public static int injectAlpha(Color color, int alpha) {
        int cappedAlpha = Math.max(0, Math.min(255, alpha));
        return (cappedAlpha << 24) | (color.getRGB() & 0x00FFFFFF);
    }

    public static void draw2DGradientRect(PoseStack matrices, float x, float y, float w, float h, int c1, int c2, int c3, int c4) {
        GRADIENT_RECT.draw(matrices, x, y, w, h, 0f,
                new Color(c1, true),
                new Color(c2, true),
                new Color(c3, true),
                new Color(c4, true)
        );
    }
}
