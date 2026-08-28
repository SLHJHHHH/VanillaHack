package com.vanillahack.api.utils.animation;

public enum Easing {
    LINEAR {
        @Override
        public double ease(double x) {
            return x;
        }
    },
    EASE_IN_QUAD {
        @Override
        public double ease(double x) {
            return x * x;
        }
    },
    EASE_OUT_QUAD {
        @Override
        public double ease(double x) {
            return 1 - (1 - x) * (1 - x);
        }
    },
    EASE_IN_OUT_QUAD {
        @Override
        public double ease(double x) {
            return x < 0.5 ? 2 * x * x : 1 - Math.pow(-2 * x + 2, 2) / 2;
        }
    },
    EASE_OUT_CUBIC {
        @Override
        public double ease(double x) {
            return 1 - Math.pow(1 - x, 3);
        }
    },
    EASE_IN_OUT_CUBIC {
        @Override
        public double ease(double x) {
            return x < 0.5 ? 4 * x * x * x : 1 - Math.pow(-2 * x + 2, 3) / 2;
        }
    },
    SINE_BOTH {
        @Override
        public double ease(double x) {
            return -(Math.cos(Math.PI * x) - 1) / 2.0;
        }
    };

    public abstract double ease(double x);

    public float apply(float x) {
        return (float) ease(x);
    }
}
