package com.vanillahack.api.utils.functions.setting;

import com.vanillahack.api.utils.other.LocalUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Supplier;

@Getter
@Setter
public abstract class Setting<T> implements DisplayNamed {
    protected String name;
    protected T value;
    protected Supplier<Boolean> visibilityCondition = () -> true;
    protected Runnable action;

    public Setting(String name) {
        this.name = name;
    }

    public Setting<T> setVisible(Supplier<Boolean> condition) {
        this.visibilityCondition = condition;
        return this;
    }

    public void runAction() {
        if (this.action != null) {
            action.run();
        }
    }

    protected boolean sameValue(T newValue) {
        if (value == null || newValue == null) return false;

        return value == newValue;
    }

    public T getValue() {
        return value;
    }

    public Setting<T> onAction(Runnable action) {
        this.action = action;
        return this;
    }

    public boolean isVisible() {
        return visibilityCondition.get();
    }

    @Override
    public String getDisplayName() {
        return LocalUtil.translateSetting(name);
    }

    public abstract Setting<T> value(T value);
}
