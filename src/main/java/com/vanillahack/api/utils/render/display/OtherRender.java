package com.vanillahack.api.utils.render.display;

import com.mojang.blaze3d.vertex.PoseStack;

public class OtherRender {
    public void scaleStart(PoseStack matrixStack, float x, float y, double scale) {
        matrixStack.pushPose();
        matrixStack.translate(x, y, 0);
        matrixStack.scale((float) scale, (float) scale, 1f);
        matrixStack.translate(-x, -y, 0);
    }

    public void squshStart(PoseStack matrixStack, float x, float y, double scale) {
        matrixStack.pushPose();
        matrixStack.translate(x, y, 0);
        matrixStack.scale(1f, (float) scale, 1f);
        matrixStack.translate(-x, -y, 0);
    }

    public void scaleStop(PoseStack matrixStack) {
        matrixStack.popPose();
    }
}
