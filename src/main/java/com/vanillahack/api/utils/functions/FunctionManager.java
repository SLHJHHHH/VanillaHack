package com.vanillahack.api.utils.functions;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FunctionManager {
    private static final FunctionManager instance = new FunctionManager();

    private final List<Function> functions = new ArrayList<>();

    public void load() {
        register(
                // soon
        );

        functions.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
    }

    public void register(Function... functions) {
        this.functions.addAll(List.of(functions));
    }
}
