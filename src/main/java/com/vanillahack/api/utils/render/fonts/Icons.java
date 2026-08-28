package com.vanillahack.api.utils.render.fonts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Icons {
    // Hud
    COORDS("W"),
    SIGNAL("B"),
    SPEED("V"),
    WLAN("N"),
    PERFORMANCE("Y"),
    LOGO("M"),

    // Main Menu
    QUIT("P"),
    MULTIPLAYER("A"),
    OPTIONS("S"),
    SINGLEPLAYER("U"),

    //Music

    STEP_B("K"),
    STEP_F("L"),
    PAUSE("O"),
    PLAY("I"),

    // Config Menu
    FOLDER("F"),
    RIGHTR("R"),
    REFRESH("G"),
    DOCUMENT("D"),
    TRASH("T"),
    CROSS("C");


    private final String letter;

    public static Icons find(String name) {
        try {
            return Icons.valueOf(name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
