package com.vanillahack.api.events;

public record EventListener(Runnable action) {
    public void unsubscribe() {
        action.run();
    }
}
