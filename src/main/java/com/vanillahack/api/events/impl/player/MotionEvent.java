package com.vanillahack.api.events.impl.player;

import com.vanillahack.api.events.impl.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MotionEvent extends Event<MotionEvent> {

    private float yaw;
    private float pitch;
    private boolean onGround;
}