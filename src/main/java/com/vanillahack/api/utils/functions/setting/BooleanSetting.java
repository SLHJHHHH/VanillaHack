package com.vanillahack.api.utils.functions.setting;

import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class BooleanSetting extends Setting<Boolean> {
    public BooleanSetting(String name) {
        super(name);
    }

    @Override
    public BooleanSetting value(Boolean value) {
        setValue(value);
        return this;
    }

    @Override
    public void setValue(Boolean value) {
        if (sameValue(value)) return;
        super.setValue(value);
        runAction();
    }

    @Override
    public BooleanSetting setVisible(Supplier<Boolean> condition) {
        return (BooleanSetting) super.setVisible(condition);
    }

    @Override
    public BooleanSetting onAction(Runnable action) {
        return (BooleanSetting) super.onAction(action);
    }

    public void toggle() {
        setValue(!getValue());
    }
}