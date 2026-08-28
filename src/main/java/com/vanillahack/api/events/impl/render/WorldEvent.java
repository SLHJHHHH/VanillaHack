package com.vanillahack.api.events.impl.render;

import com.vanillahack.api.events.impl.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.multiplayer.ClientLevel;

@Getter
@Setter
@AllArgsConstructor
public class WorldEvent extends Event<WorldEvent> {
    private ClientLevel world;
}
