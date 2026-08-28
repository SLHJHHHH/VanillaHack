package com.vanillahack.api.events.impl.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vanillahack.api.events.impl.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.DeltaTracker;

@Getter
@Setter
@AllArgsConstructor
public class RenderEvent3D extends Event<RenderEvent3D> {
    private PoseStack poseStack;
    private DeltaTracker deltaTracker;
    private float partialTicks;
}
