package com.vanillahack.api.utils.render.display;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vanillahack.api.utils.interfaces.QuickImports;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoxRender implements QuickImports {
    private final List<OutlinedBox> outlinedBoxes = new ArrayList<>();
    private final List<FilledBox> filledBoxes = new ArrayList<>();
    private final List<StripedBox> stripedBoxes = new ArrayList<>();

    public enum Render {
        FILL, OUTLINE, STRIPED
    }

    public void setup3DRender(PoseStack poseStack) {
        filledBoxes.clear();
        stripedBoxes.clear();
        outlinedBoxes.clear();
    }

    public void drawBox(float x1, float y1, float z1, float x2, float y2, float z2, float lineWidth, Color color, Render renderMode, float gapDistance) {
        Vec3 pos = new Vec3(x1, y1, z1);
        Vec3 params = new Vec3(x2 - x1, y2 - y1, z2 - z1);

        switch (renderMode) {
            case FILL -> filledBoxes.add(new FilledBox(pos, params, color));
            case OUTLINE -> outlinedBoxes.add(new OutlinedBox(pos, params, lineWidth, color));
            case STRIPED -> stripedBoxes.add(new StripedBox(pos, params, lineWidth, color, gapDistance));
        }
    }

    public record FilledBox(Vec3 pos, Vec3 params, Color color) {}
    public record OutlinedBox(Vec3 pos, Vec3 params, float lineWidth, Color color) {}
    public record StripedBox(Vec3 pos, Vec3 params, float lineWidth, Color color, float gapDistance) {}
}