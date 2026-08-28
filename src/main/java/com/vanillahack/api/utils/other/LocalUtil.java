package com.vanillahack.api.utils.other;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.locale.Language;

import java.util.Locale;

public final class LocalUtil {

    private LocalUtil() {
    }

    public static String translateSetting(String rawName) {
        return translate("setting.vanillahack.", rawName);
    }

    public static String translateValue(String rawValue) {
        return translate("value.vanillahack.", rawValue);
    }

    private static String translate(String prefix, String rawValue) {
        if (rawValue == null || rawValue.isBlank()) {
            return rawValue;
        }

        String key = prefix + normalize(rawValue);
        String translated = Language.getInstance().getOrDefault(key);

        return translated.equals(key) ? rawValue : translated;
    }

    private static String normalize(String value) {
        return value.toLowerCase(Locale.ROOT)
                .replace("%", "_percent")
                .replaceAll("[^a-z0-9]+", "_")
                .replaceAll("_+", "_")
                .replaceAll("^_|_$", "");
    }
}