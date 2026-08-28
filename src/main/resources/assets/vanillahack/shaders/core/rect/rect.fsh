#version 150

#moj_import <slaughterware:common.glsl>

in vec2 FragCoord;
in vec4 FragColor;

uniform vec2 uSize;
uniform vec4 uRadius;
uniform float uSmoothness;

out vec4 fragColor;

void main() {
    float alpha = ralpha(uSize, FragCoord, uRadius, uSmoothness);
    vec4 color = vec4(FragColor.rgb, FragColor.a * alpha);

    if (color.a == 0.0) {
        discard;
    }

    fragColor = color;
}