package com.vanillahack.api.utils.framelimiter;

public class FrameLimiter {
    private long lastTime = 0L;
    private boolean vsync = false;

    public FrameLimiter() {}

    public FrameLimiter(boolean vsync) {
        this.vsync = vsync;
    }

    public void execute(int targetFps, Runnable task) {
        long now = System.currentTimeMillis();
        long interval = 1000L / Math.max(1, targetFps);
        if (now - lastTime >= interval) {
            lastTime = now;
            task.run();
        }
    }
}
