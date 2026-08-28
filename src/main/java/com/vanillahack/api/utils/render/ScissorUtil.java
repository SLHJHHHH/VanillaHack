package com.vanillahack.api.utils.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.vanillahack.api.utils.interfaces.QuickImports;
import lombok.experimental.UtilityClass;

import java.util.ArrayDeque;
import java.util.Deque;

@UtilityClass
public class ScissorUtil implements QuickImports {
    private final Deque<int[]> scissorStack = new ArrayDeque<>();

    public void start(PoseStack matrixStack, float x, float y, float width, float height) {
        float scale = (float) mc.getWindow().getGuiScale();

        float adjustedY = mc.getWindow().getGuiScaledHeight() - y;

        int sx = Math.round(x * scale);
        int sy = Math.round((adjustedY - height) * scale);
        int sw = Math.max(0, Math.round(width * scale));
        int sh = Math.max(0, Math.round(height * scale));

        if (!scissorStack.isEmpty()) {
            int[] parent = scissorStack.peek();
            int nx = Math.max(sx, parent[0]);
            int ny = Math.max(sy, parent[1]);
            int nRight = Math.min(sx + sw, parent[0] + parent[2]);
            int nTop = Math.min(sy + sh, parent[1] + parent[3]);
            sx = nx;
            sy = ny;
            sw = Math.max(0, nRight - nx);
            sh = Math.max(0, nTop - ny);
        }

        matrixStack.pushPose();
        scissorStack.push(new int[]{sx, sy, sw, sh});
        RenderSystem.enableScissorForRenderTypeDraws(sx, sy, sw, sh);
    }

    public void stop(PoseStack matrixStack) {
        if (!scissorStack.isEmpty()) {
            scissorStack.pop();
        }

        if (scissorStack.isEmpty()) {
            RenderSystem.disableScissorForRenderTypeDraws();
        } else {
            int[] parent = scissorStack.peek();
            RenderSystem.enableScissorForRenderTypeDraws(parent[0], parent[1], parent[2], parent[3]);
        }
        matrixStack.popPose();
    }
}
