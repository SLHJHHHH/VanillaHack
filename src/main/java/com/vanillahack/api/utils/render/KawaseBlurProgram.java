package com.vanillahack.api.utils.render;

import com.mojang.blaze3d.GpuFormat;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.blaze3d.vertex.PoseStack;
import com.vanillahack.api.events.Listener;
import com.vanillahack.api.events.impl.render.FramebufferResizeEvent;
import com.vanillahack.api.utils.framelimiter.FrameLimiter;
import com.vanillahack.api.utils.interfaces.QuickImports;
import com.vanillahack.client.features.modules.render.ClickGUIModule;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class KawaseBlurProgram implements QuickImports {
    public final List<RenderTarget> fbos = new ArrayList<>();

    private boolean init = false;
    private final FrameLimiter f = new FrameLimiter(false);

    public void load() {
        if (!init) {
            for (int i = 0; i <= ClickGUIModule.getPasses(); i++) {
                fbos.add(createFbo());
            }
            init = true;
        }

        FramebufferResizeEvent.getInstance().subscribe(new Listener<>(event -> recreate()));
    }

    public void recreate() {
        fbos.forEach(RenderTarget::destroyBuffers);
        fbos.clear();

        for (int i = 0; i <= ClickGUIModule.getPasses(); i++) {
            fbos.add(createFbo());
        }
    }

    public void render(PoseStack matrixStack) {
        if (ClickGUIModule.getGlassy() != 1f) {
            f.execute(40, () -> {
                // blur execution
            });
        }
    }

    private RenderTarget createFbo() {
        return new TextureTarget("KawaseFBO", mc.getWindow().getWidth(), mc.getWindow().getHeight(), false, GpuFormat.RGBA8_UNORM);
    }
}
