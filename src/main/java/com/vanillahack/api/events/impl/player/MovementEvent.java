package com.vanillahack.api.events.impl.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.world.phys.Vec3;

public class MovementEvent {
    @Getter
    private static final MovementEvent instance = new MovementEvent();

    private float yaw;
    private float pitch;

    public MovementEvent() {

    }

    public MovementEvent(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class MovementEventData {
        private double x;
        private double y;
        private double z;

        public void set(Vec3 vec3) {
            x = vec3.x;
            y = vec3.y;
            z = vec3.z;
        }
    }
}
