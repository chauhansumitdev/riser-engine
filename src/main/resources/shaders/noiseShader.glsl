#version 330 core
out vec4 FragColor;

float random(vec2 co) {
    return fract(sin(dot(co.xy ,vec2(12.9898,78.233))) * 43758.5453);
}

void main() {
    // Generate random colors
    float r = random(gl_FragCoord.xy);
    float g = random(vec2(gl_FragCoord.yx));
    float b = random(vec2(gl_FragCoord.y * 3.5, gl_FragCoord.x * 1.5)); // adjustable

    FragColor = vec4(r, g, b, 1.0);
}
