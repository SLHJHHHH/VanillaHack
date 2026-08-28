package com.vanillahack.api.events.interfaces;

import com.vanillahack.api.events.Listener;

public interface Cacheable<T> {
    Listener<T>[] getCache();
}