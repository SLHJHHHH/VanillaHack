package com.vanillahack.api.utils.render.fonts;

import com.vanillahack.api.utils.files.FileUtil;
import com.vanillahack.api.utils.other.ClientInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.resources.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FontBuilder {
    private String name;
    private Identifier dataIdentifier;
    private Identifier atlasIdentifier;

    public FontBuilder() {}

    public FontBuilder find(String fontName) {
        this.name = fontName;
        this.dataIdentifier = Identifier.fromNamespaceAndPath(ClientInfo.NAME.toLowerCase(), "fonts/" + fontName + ".json");
        this.atlasIdentifier = Identifier.fromNamespaceAndPath(ClientInfo.NAME.toLowerCase(), "fonts/" + fontName + ".png");
        return this;
    }

    public Font load() {
        FontData data = FileUtil.fromJsonToInstance(this.dataIdentifier, FontData.class);
        AbstractTexture texture = Minecraft.getInstance().getTextureManager().getTexture(this.atlasIdentifier);

        if (data == null) {
            throw new RuntimeException("Failed to read font data file: " + this.dataIdentifier + "; Are you sure this is json file? Try to check the correctness of its syntax.");
        }

        float aWidth = data.atlas().width();
        float aHeight = data.atlas().height();
        Map<Integer, MsdfGlyph> glyphs = data.glyphs().stream().collect(Collectors.toMap(FontData.GlyphData::unicode, glyphData -> new MsdfGlyph(glyphData, aWidth, aHeight)));

        Map<Integer, Map<Integer, Float>> kernings = new HashMap<>();
        if (data.kernings() != null) {
            data.kernings().forEach(kerning -> {
                Map<Integer, Float> map = kernings.computeIfAbsent(kerning.leftChar(), k -> new HashMap<>());
                map.put(kerning.rightChar(), kerning.advance());
            });
        }

        return new Font(name, texture, data.atlas(), data.metrics(), glyphs, kernings);
    }
}
