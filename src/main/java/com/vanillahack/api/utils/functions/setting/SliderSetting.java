    package com.vanillahack.api.utils.functions.setting;


    import lombok.Getter;


    import java.util.function.Supplier;

    @Getter
    public class SliderSetting extends Setting<Float> {
        private float min = Float.MIN_VALUE;
        private float max = Float.MAX_VALUE;
        private float step = 1.0f;

        public SliderSetting(String name) {
            super(name);
        }

        @Override
        public SliderSetting value(Float value) {
            setValue(value);
            return this;
        }

        @Override
        public void setValue(Float value) {
            if (sameValue(value)) return;
            super.setValue(value);
            runAction();
        }


        @Override
        public SliderSetting setVisible(Supplier<Boolean> condition) {
            return (SliderSetting) super.setVisible(condition);
        }

        @Override
        public SliderSetting onAction(Runnable action) {
            return (SliderSetting) super.onAction(action);
        }


        public SliderSetting range(float min, float max) {
            this.min = min;
            this.max = max;
            return this;
        }

        public SliderSetting step(float step) {
            this.step = step;
            return this;
        }

    }