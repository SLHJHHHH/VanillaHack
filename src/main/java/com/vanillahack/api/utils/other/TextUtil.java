package com.vanillahack.api.utils.other;

import com.vanillahack.api.utils.render.fonts.MsdfGlyph;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public final class TextUtil {
    private TextUtil() {}

    public static List<MsdfGlyph.ColoredGlyph> parseTextToColoredGlyphs(String text) {
        List<MsdfGlyph.ColoredGlyph> glyphs = new ArrayList<>();
        if (text == null || text.isEmpty()) return glyphs;

        int currentColor = 0xFFFFFFFF;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '§' && i + 1 < text.length()) {
                char code = Character.toLowerCase(text.charAt(i + 1));
                currentColor = getColorFromCode(code);
                i++;
                continue;
            }
            glyphs.add(new MsdfGlyph.ColoredGlyph(c, currentColor));
        }
        return glyphs;
    }

    public static List<MsdfGlyph.ColoredGlyph> parseTextToColoredGlyphs(Component component) {
        if (component == null) return new ArrayList<>();
        return parseTextToColoredGlyphs(component.getString());
    }

    public static int getColorFromCode(char code) {
        return switch (code) {
            case '0' -> 0xFF000000;
            case '1' -> 0xFF0000AA;
            case '2' -> 0xFF00AA00;
            case '3' -> 0xFF00AAAA;
            case '4' -> 0xFFAA0000;
            case '5' -> 0xFFAA00AA;
            case '6' -> 0xFFFFAA00;
            case '7' -> 0xFFAAAAAA;
            case '8' -> 0xFF555555;
            case '9' -> 0xFF5555FF;
            case 'a' -> 0xFF55FF55;
            case 'b' -> 0xFF55FFFF;
            case 'c' -> 0xFFFF5555;
            case 'd' -> 0xFFFF55FF;
            case 'e' -> 0xFFFFFF55;
            default -> 0xFFFFFFFF;
        };
    }
}
