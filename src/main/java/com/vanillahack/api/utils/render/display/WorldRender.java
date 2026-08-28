package com.vanillahack.api.utils.render.display;

import com.mojang.blaze3d.vertex.PoseStack;

public class WorldRender {
    public void startRender(PoseStack matrixStack) {
        matrixStack.pushPose();
    }

    public void endRender(PoseStack matrixStack) {
        matrixStack.popPose();
    }
}
