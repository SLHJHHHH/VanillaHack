package com.vanillahack.api.utils.render.shader;

import net.minecraft.core.BlockPos;

import java.util.List;

public interface ShaderOutlineSource {
    List<BlockPos> getOutlineRenderPoses();
    float getOutlineRenderBoxSize();
    float getOutlineRenderFactor();
    float getOutlineStrength();
    float getOutlineThreshold();
}
