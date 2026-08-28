package com.vanillahack.api.events.impl.player;

import com.vanillahack.api.events.impl.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VelocityEvent extends Event<VelocityEvent> {

    private final MovementData velocity;

    public VelocityEvent(double x, double y, double z) {
        this.velocity = new MovementData(x, y, z);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class MovementData {
        private double x;
        private double y;
        private double z;
    }
}