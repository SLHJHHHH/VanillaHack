package com.vanillahack.api.events.impl.render;

import com.vanillahack.api.events.impl.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FramebufferResizeEvent extends Event<FramebufferResizeEvent> {
    @Getter
    private static final FramebufferResizeEvent instance = new FramebufferResizeEvent(0, 0);

    private int width;
    private int height;
}
