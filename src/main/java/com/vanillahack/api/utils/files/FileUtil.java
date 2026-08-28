package com.vanillahack.api.utils.files;

import com.google.gson.Gson;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public final class FileUtil {
    private static final Gson GSON = new Gson();

    private FileUtil() {}

    public static Identifier getShader(String path) {
        return Identifier.fromNamespaceAndPath("vanillahack", "shaders/core/" + path);
    }

    public static Identifier getResource(String path) {
        return Identifier.fromNamespaceAndPath("vanillahack", path);
    }

    public static <T> T fromJsonToInstance(Identifier id, Class<T> clazz) {
        try {
            var res = Minecraft.getInstance().getResourceManager().getResource(id);
            if (res.isPresent()) {
                try (var reader = new InputStreamReader(res.get().open(), StandardCharsets.UTF_8)) {
                    return GSON.fromJson(reader, clazz);
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }
}
