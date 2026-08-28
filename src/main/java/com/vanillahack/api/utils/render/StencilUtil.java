package com.vanillahack.api.utils.render;

import com.vanillahack.api.utils.interfaces.QuickImports;
import lombok.experimental.UtilityClass;
import org.lwjgl.opengl.GL11;

@UtilityClass
public class StencilUtil implements QuickImports {
    public void push() {
        GL11.glStencilMask(0xFF);
        GL11.glClear(GL11.GL_STENCIL_BUFFER_BIT);
        GL11.glEnable(GL11.GL_STENCIL_TEST);
        GL11.glStencilFunc(GL11.GL_ALWAYS, 1, 1);
        GL11.glStencilOp(GL11.GL_REPLACE, GL11.GL_REPLACE, GL11.GL_REPLACE);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glColorMask(false, false, false, false);
    }

    public void read(int ref) {
        GL11.glColorMask(true, true, true, true);
        GL11.glStencilFunc(GL11.GL_EQUAL, ref, 1);
        GL11.glStencilOp(GL11.GL_KEEP, GL11.GL_KEEP, GL11.GL_KEEP);
    }

    public void pop() {
        GL11.glDisable(GL11.GL_STENCIL_TEST);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }
}
