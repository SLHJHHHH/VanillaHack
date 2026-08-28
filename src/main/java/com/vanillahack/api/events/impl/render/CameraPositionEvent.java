package com.vanillahack.api.events.impl.render;

import com.vanillahack.api.events.impl.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Camera;
import net.minecraft.world.phys.Vec3;

@Getter
@Setter
@AllArgsConstructor
public class CameraPositionEvent extends Event<CameraPositionEvent> {
    private Camera camera;
    private double x;
    private double y;
    private double z;
    private float partialTicks;

    public Vec3 getPosition() {
        return new Vec3(x, y, z);
    }

    public void setPosition(Vec3 position) {
        this.x = position.x;
        this.y = position.y;
        this.z = position.z;
    }
}
