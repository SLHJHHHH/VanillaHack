package com.vanillahack.api.utils.functions.setting;

import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class StringSetting extends Setting<String> {
    private int maxLength = 120;

    public StringSetting(String name) {
        super(name);
    }

    @Override
    public StringSetting value(String value) {
        setValue(value);
        return this;
    }

    @Override
    public void setValue(String value) {
        String safe = value == null ? "" : value;
        if (safe.length() > maxLength) {
            safe = safe.substring(0, maxLength);
        }
        if (sameValue(safe)) return;
        super.setValue(safe);
        runAction();
    }

    public StringSetting maxLength(int maxLength) {
        this.maxLength = Math.max(1, maxLength);
        if (getValue() != null && getValue().length() > this.maxLength) {
            setValue(getValue().substring(0, this.maxLength));
        }
        return this;
    }

    @Override
    public StringSetting setVisible(Supplier<Boolean> condition) {
        return (StringSetting) super.setVisible(condition);
    }

    @Override
    public StringSetting onAction(Runnable action) {
        return (StringSetting) super.onAction(action);
    }
}
