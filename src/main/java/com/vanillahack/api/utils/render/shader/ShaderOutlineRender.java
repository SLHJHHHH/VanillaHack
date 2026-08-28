package com.vanillahack.api.utils.render.shader;//package slaughterware.fun.api.utils.render.shader;
//
//import com.mojang.blaze3d.systems.RenderSystem;
//import net.minecraft.client.MinecraftClient;
//import net.minecraft.client.gl.Framebuffer;
//import net.minecraft.client.gl.SimpleFramebuffer;
//import net.minecraft.client.render.VertexConsumerProvider;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.client.util.math.MatrixStack;
//import java.awt.Color;
//
//public class ShaderOutlineRender {
//    private static Framebuffer entityBuffer;
//    private static final MinecraftClient mc = MinecraftClient.getInstance();
//
//    public static void render(Entity entity, float partialTicks, MatrixStack ms, Color color, float width) {
//        // Проверяем и создаем буфер под размер окна
//        setupBuffer();
//
//        // 1. Очищаем наш буфер
//        entityBuffer.clear(false);
//        entityBuffer.beginWrite(false);
//
//        // 2. Рендерим сущность в этот буфер (тут нужен хук или прямой вызов рендера модели)
//        // Для упрощения в этом примере: мы используем стандартный рендер,
//        // но в идеале здесь вызывается mc.getEntityRenderDispatcher().render(...)
//
//        entityBuffer.endWrite();
//
//        // 3. Рисуем содержимое буфера на экран через шейдер обводки
//        applyShader(color, width);
//    }
//
//    private static void setupBuffer() {
//        if (entityBuffer == null ||
//                entityBuffer.textureWidth != mc.getWindow().getFramebufferWidth() ||
//                entityBuffer.textureHeight != mc.getWindow().getFramebufferHeight()) {
//            if (entityBuffer != null) entityBuffer.delete();
//            entityBuffer = new SimpleFramebuffer(mc.getWindow().getFramebufferWidth(), mc.getWindow().getFramebufferHeight(), true);
//        }
//    }
//
//    private static void applyShader(Color color, float width) {
//        // Здесь мы берем твой .glsl шейдер и рисуем квад на весь экран
//        // Используем entityBuffer.getDepthAttachment() чтобы обводить только края
//        RenderSystem.setShaderColor(color.getRed()/255f, color.getGreen()/255f, color.getBlue()/255f, color.getAlpha()/255f);
//        // ... логика активации шейдера ...
//    }
//}