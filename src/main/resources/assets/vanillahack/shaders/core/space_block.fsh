#version 150

in vec2 FragCoord;
in vec4 FragColor;

uniform float Time;
uniform float Alpha;
uniform vec3 BaseColor;

out vec4 fragColor;

float field(in vec3 p) {
    float strength = 7.0;
    float accum = 0.0;
    float prev = 0.0;
    float tw = 0.0;
    for (int i = 0; i < 6; ++i) {
        float mag = dot(p, p);
        p = abs(p) / mag + vec3(-0.5, -0.4, -1.5);
        float w = exp(-float(i) / 7.0);
        accum += w * exp(-strength * abs(mag - prev));
        tw += w;
        prev = mag;
    }
    return max(0.0, 5.0 * accum / tw - 0.3);
}

void main() {
    vec2 uv = FragCoord * 2.0 - 1.0;

    vec3 pos = vec3(uv * 1.0, Time * 0.1);

    float f = field(pos);

    vec3 cosmicColor = mix(BaseColor, vec3(0.0, 0.8, 1.0), f * 0.4);

    fragColor = vec4(cosmicColor, Alpha);
}