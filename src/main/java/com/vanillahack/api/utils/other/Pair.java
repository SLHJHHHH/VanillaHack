package com.vanillahack.api.utils.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pair<A, B> {
    private A first;
    private B second;

    public static <A, B> Pair<A, B> of(A first, B second) {
        return new Pair<>(first, second);
    }

    public A left() {
        return first;
    }

    public B right() {
        return second;
    }
}
