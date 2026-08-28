package com.vanillahack.api.utils.functions.setting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MultiBooleanSetting extends Setting<List<BooleanSetting>> {
    public MultiBooleanSetting(String name) {
        super(name);
        this.value = new ArrayList<>();
    }

    @Override
    public MultiBooleanSetting value(List<BooleanSetting> value) {
        setValue(value);
        return this;
    }

    public MultiBooleanSetting value(BooleanSetting... value) {
        setValue(new ArrayList<>(Arrays.asList(value)));
        return this;
    }

    @Override
    public void setValue(List<BooleanSetting> value) {
        if (sameValue(value)) return;
        super.setValue(value);
        runAction();
    }

    @Override
    public MultiBooleanSetting onAction(Runnable action) {
        return (MultiBooleanSetting) super.onAction(action);
    }

    public MultiBooleanSetting addValues(BooleanSetting... value) {
        this.value.addAll(Arrays.asList(value));
        return this;
    }

    public boolean isEnabled(String name) {
        return getBooleanSettingByName(name).map(BooleanSetting::getValue).orElse(false);
    }

    public boolean toggle(String name) {
        return getBooleanSettingByName(name).map(booleanSetting -> {
            booleanSetting.value(!booleanSetting.getValue());
            return true;
        }).orElse(false);
    }

    public List<String> getAllNames() {
        return value.stream().map(BooleanSetting::getName).collect(Collectors.toList());
    }

    public List<String> getList() {
        return value.stream().filter(BooleanSetting::getValue).map(BooleanSetting::getName).collect(Collectors.toList());
    }

    private Optional<BooleanSetting> getBooleanSettingByName(String name) {
        return value.stream().filter(setting -> setting.getName().equalsIgnoreCase(name)).findFirst();
    }

    @Override
    public MultiBooleanSetting setVisible(Supplier<Boolean> condition) {
        return (MultiBooleanSetting) super.setVisible(condition);
    }
}