package com.vanillahack.api.utils.functions.setting;

import java.awt.*;
import java.util.function.Supplier;

public class ColorSetting extends Setting<Color> {
    public ColorSetting(String name) {
        super(name);
    }

    @Override
    public ColorSetting value(Color value) {
        setValue(value);
        return this;
    }

    @Override
    public void setValue(Color value) {
        if (sameValue(value)) return;
        super.setValue(value);
        runAction();
    }

    @Override
    public ColorSetting setVisible(Supplier<Boolean> condition) {
        return (ColorSetting) super.setVisible(condition);
    }

    @Override
    public ColorSetting onAction(Runnable action) {
        return (ColorSetting) super.onAction(action);
    }
}
