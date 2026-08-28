#version 150

#moj_import <slaughterware:common.glsl>

in vec2 FragCoord;
in vec4 FragColor;
in vec2 TexCoord;

uniform sampler2D Sampler0;
uniform vec2 uSize;
uniform vec4 uRadius;
uniform float uAlpha;
uniform float uMix;
uniform float uSmoothness;
uniform vec4 uTopLeftColor;
uniform vec4 uBottomLeftColor;
uniform vec4 uTopRightColor;
uniform vec4 uBottomRightColor;

out vec4 fragColor;

vec4 superSex(vec2 uv) {
    vec4 topColor = mix(uTopLeftColor, uTopRightColor, uv.x);
    vec4 bottomColor = mix(uBottomLeftColor, uBottomRightColor, uv.x);

    return mix(topColor, bottomColor, uv.y);
}

void main() {
    vec2 center = uSize * 0.5;
    vec2 fragPos = center - (FragCoord * uSize);
    float dist = rdist(fragPos, center - 1.0, uRadius);

    float smoothedAlpha = ralpha(uSize, FragCoord, uRadius, uSmoothness);

    if (smoothedAlpha > 0.0) {
        vec4 texColor = texture(Sampler0, TexCoord);
        vec4 mixedColor = mix(texColor, superSex(FragCoord), uMix);
        mixedColor.a *= smoothedAlpha * uAlpha;

        fragColor = mixedColor;
    } else {
        fragColor = vec4(0.0);
    }
}