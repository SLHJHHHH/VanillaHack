package com.vanillahack.api.events.impl.render;

import com.vanillahack.api.events.impl.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Camera;

@Getter
@Setter
@AllArgsConstructor
public class CameraEvent extends Event<CameraEvent> {
    private Camera camera;
    private double distance;
    private float yaw;
    private float pitch;
    private float roll;
    private float partialTicks;
}
