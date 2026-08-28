package com.vanillahack.api.events.interfaces;

import com.vanillahack.api.events.EventListener;

public interface Subscribable<L, T> {
    EventListener subscribe(L listener);
    void unsubscribe(L listener);
}
