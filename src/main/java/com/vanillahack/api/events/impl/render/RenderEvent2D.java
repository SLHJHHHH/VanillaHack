package com.vanillahack.api.events.impl.render;

import com.vanillahack.api.events.impl.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;

@Getter
@Setter
@AllArgsConstructor
public class RenderEvent2D extends Event<RenderEvent2D> {
    private GuiGraphicsExtractor graphicsExtractor;
    private DeltaTracker deltaTracker;
    private float partialTicks;
}
