#version 150

#moj_import <slaughterware:common.glsl>

in vec2 FragCoord;
in vec4 FragColor;

uniform vec2 uSize;
uniform float uTime;
uniform vec2 uMouse;
uniform float uStyle;
uniform vec4 uColorModulator;

out vec4 fragColor;

float hash(vec2 p) {
    p = fract(p * vec2(123.34, 456.21));
    p += dot(p, p + 45.32);
    return fract(p.x * p.y);
}

float noise(vec2 p) {
    vec2 i = floor(p);
    vec2 f = fract(p);
    float a = hash(i);
    float b = hash(i + vec2(1.0, 0.0));
    float c = hash(i + vec2(0.0, 1.0));
    float d = hash(i + vec2(1.0, 1.0));
    vec2 u = f * f * (3.0 - 2.0 * f);
    return mix(a, b, u.x) + (c - a) * u.y * (1.0 - u.x) + (d - b) * u.x * u.y;
}

float fbm(vec2 p) {
    float value = 0.0;
    float amp = 0.55;
    for (int i = 0; i < 4; i++) {
        value += noise(p) * amp;
        p = p * 2.03 + vec2(11.7, 7.9);
        amp *= 0.5;
    }
    return value;
}

void main() {
    vec2 uv = FragCoord;
    vec2 centered = uv - 0.5;
    centered.x *= uSize.x / max(uSize.y, 1.0);

    vec2 mouseNorm = vec2(uMouse.x / max(uSize.x, 1.0), uMouse.y / max(uSize.y, 1.0));
    vec2 mouseShift = (mouseNorm - 0.5) * vec2(0.18, -0.18);

    vec2 p = centered * 2.2 + mouseShift;
    float t = uTime * 0.27;

    float n1 = fbm(p + vec2(t, -t * 0.7));
    float n2 = fbm(p * 1.6 - vec2(t * 1.3, t * 0.4));
    float flow = smoothstep(0.15, 0.95, n1 * 0.6 + n2 * 0.4);

    vec3 deep = vec3(0.04, 0.07, 0.14);
    vec3 mid = vec3(0.08, 0.16, 0.30);
    vec3 hi = vec3(0.18, 0.42, 0.78);

    if (uStyle > 0.5 && uStyle < 1.5) {
        deep = vec3(0.07, 0.04, 0.10);
        mid = vec3(0.22, 0.08, 0.28);
        hi = vec3(0.88, 0.22, 0.56);
    } else if (uStyle > 1.5) {
        deep = vec3(0.03, 0.10, 0.09);
        mid = vec3(0.05, 0.22, 0.18);
        hi = vec3(0.20, 0.80, 0.66);
    }
    vec3 glow = mix(deep, mid, flow);
    glow = mix(glow, hi, pow(flow, 2.0) * 0.75);

    float vignette = smoothstep(1.32, 0.25, length(centered));
    float pulse = 0.92 + sin(uTime * 1.35 + n2 * 6.0) * 0.08;

    vec3 color = glow * vignette * pulse;
    color += vec3(0.02, 0.04, 0.07) * (1.0 - vignette);

    fragColor = vec4(color, 1.0) * uColorModulator;
}
