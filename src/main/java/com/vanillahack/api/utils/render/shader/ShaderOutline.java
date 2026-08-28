package com.vanillahack.api.utils.render.shader;

public class ShaderOutline {
    private final ShaderOutlineSource source;

    public ShaderOutline(ShaderOutlineSource source) {
        this.source = source;
    }

    public void render(float partialTicks) {
        if (source == null) {
            return;
        }
        // Fallback implementation. Real shader pipeline can be restored later.
    }
}
