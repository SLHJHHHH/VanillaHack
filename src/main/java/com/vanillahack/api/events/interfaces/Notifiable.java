package com.vanillahack.api.events.interfaces;

public interface Notifiable<E> {
    void notify(E event);
}
