package com.vanillahack.api.events;

import lombok.Getter;
import java.util.function.Consumer;

public class Listener<T> implements Comparable<Listener<T>> {
        private static int counter = 0;

        @Getter private final int priority;
        @Getter private final Consumer<T> handler;
        private final long id;

        public Listener(int priority, Consumer<T> handler) {
            this.priority = priority;
            this.handler = handler;
            this.id = counter++;
        }

        public Listener(Consumer<T> handler){this(0, handler);}

        @Override
        public int compareTo(Listener<T> other) {
            int priorityCompare = Integer.compare(other.priority, this.priority);
            return (priorityCompare != 0) ? priorityCompare : Long.compare(this.id, other.id);
        }
}