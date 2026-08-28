package com.vanillahack.api.utils.functions.setting;

import java.util.function.Supplier;

public class RunSetting extends Setting<Runnable> {
    public RunSetting(String name) {
        super(name);
    }

    @Override
    public RunSetting value(Runnable value) {
        this.value = value;
        return this;
    }

    @Override
    public RunSetting setVisible(Supplier<Boolean> condition) {
        return (RunSetting) super.setVisible(condition);
    }
}
