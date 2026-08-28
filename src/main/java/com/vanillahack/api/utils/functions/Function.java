package com.vanillahack.api.utils.functions;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Function {

    private final String name;
    private final String description;
    private final Category category;

    @Setter
    private int bind;

    private boolean enabled;

    protected Function() {
        FunctionRegister data = getClass().getAnnotation(FunctionRegister.class);

        if (data == null) {
            throw new IllegalStateException(
                    "Missing @FunctionRegister on " + getClass().getName()
            );
        }

        this.name = data.name();
        this.description = data.description();
        this.category = data.category();
        this.bind = data.bind();
    }

    protected Function(
            String name,
            String description,
            Category category,
            int bind
    ) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.bind = bind;
    }

    public boolean hasBind() {
        return bind != -999;
    }

    public void toggle() {
        setEnabled(!enabled);
    }

    public void setEnabled(boolean enabled) {
        if (this.enabled == enabled) {
            return;
        }

        this.enabled = enabled;

        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    protected void onEnable() {
    }

    protected void onDisable() {
    }
}