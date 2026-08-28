package com.vanillahack.api.events.impl.player;

import com.vanillahack.api.events.impl.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollisionEvent extends Event<CollisionEvent> {

    private boolean horizontal;
    private boolean vertical;

    public CollisionEvent(boolean horizontal, boolean vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }
}