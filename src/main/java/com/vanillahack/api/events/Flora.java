package com.vanillahack.api.events;

import com.vanillahack.api.events.interfaces.Cacheable;
import com.vanillahack.api.events.interfaces.Notifiable;
import com.vanillahack.api.events.interfaces.Subscribable;

import java.util.concurrent.ConcurrentSkipListSet;

public abstract class Flora<T> implements Cacheable<T>, Subscribable<Listener<T>, T>, Notifiable<T> {
    private final ConcurrentSkipListSet<Listener<T>> listeners = new ConcurrentSkipListSet<>();

    @SuppressWarnings("unchecked")
    private volatile Listener<T>[] cache = (Listener<T>[]) new Listener<?>[0];

    private volatile boolean rebCache = true;

    @Override
    @SuppressWarnings("unchecked")
    public Listener<T>[] getCache() {
        if (rebCache) {
            cache = listeners.toArray(Listener[]::new);
            rebCache = false;
        }
        return cache;
    }

    @Override
    public EventListener subscribe(Listener<T> listener) {
        listeners.add(listener);
        rebCache = true;
        return new EventListener(() -> unsubscribe(listener));
    }

    @Override
    public void unsubscribe(Listener<T> listener) {
        if (listeners.remove(listener))
            rebCache = true;
    }

    @Override
    public void notify(T event) {
        for (Listener<T> tListener : getCache()) {
            tListener.getHandler().accept(event);
        }
    }
}