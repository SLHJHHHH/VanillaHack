package com.vanillahack.api.events.impl.render;

import com.vanillahack.api.events.impl.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.world.entity.Entity;

@Getter
@Setter
@AllArgsConstructor
public class EntityColorEvent extends Event<EntityColorEvent> {
    private Entity entity;
    private int color;
    private float red;
    private float green;
    private float blue;
    private float alpha;

    public EntityColorEvent(Entity entity, int color) {
        this.entity = entity;
        this.color = color;
        this.alpha = ((color >> 24) & 0xFF) / 255.0F;
        this.red = ((color >> 16) & 0xFF) / 255.0F;
        this.green = ((color >> 8) & 0xFF) / 255.0F;
        this.blue = (color & 0xFF) / 255.0F;
    }
}
