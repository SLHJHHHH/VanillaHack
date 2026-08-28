package com.vanillahack.api.utils.functions.setting;

import com.vanillahack.api.utils.other.LocalUtil;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@Getter
public class ModeSetting extends Setting<String> {
    private final List<String> modes = new ArrayList<>();

    public interface NamedChoice {
        String getName();
    }

    public ModeSetting(String name) {
        super(name);
    }

    public ModeSetting values(String... values) {
        modes.addAll(Arrays.asList(values));
        if (value == null && !modes.isEmpty()) {
            value = modes.getFirst();
        }
        return this;
    }

    public ModeSetting values(Enum<?>... enums) {
        modes.addAll(Arrays.stream(enums)
                .map(e -> {
                    if (e instanceof NamedChoice) {
                        return ((NamedChoice) e).getName();
                    }
                    return e.name();
                })
                .toList());
        if (value == null && !modes.isEmpty()) {
            value = modes.getFirst();
        }
        return this;
    }

    public ModeSetting value(Enum<?> e) {
        return value(e != null ? (e instanceof NamedChoice ? ((NamedChoice) e).getName() : e.name()) : null);
    }

    public boolean is(Enum<?> e) {
        if (e == null) return false;
        String enumStr = e instanceof NamedChoice ? ((NamedChoice) e).getName() : e.name();
        return this.value.equals(enumStr);
    }

    @Override
    public ModeSetting value(String value) {
        setValue(value);
        return this;
    }

    @Override
    public void setValue(String value) {
        if (sameValue(value)) return;
        super.setValue(value);
        runAction();
    }

    @Override
    public ModeSetting setVisible(Supplier<Boolean> condition) {
        return (ModeSetting) super.setVisible(condition);
    }

    @Override
    public ModeSetting onAction(Runnable action) {
        return (ModeSetting) super.onAction(action);
    }

    public boolean is(String value) {
        return this.value != null && this.value.equalsIgnoreCase(value);
    }

    public String getDisplayValue() {
        return LocalUtil.translateValue(value);
    }

    public String getDisplayValue(String rawValue) {
        return LocalUtil.translateValue(rawValue);
    }
}
