#version 330 core
out vec4 FragColor;

void main() {

    float frequency = 0.1;
    float amplitude = 0.5;

    float r = sin(frequency * gl_FragCoord.x + 0.0) * amplitude + 0.5;
    float g = sin(frequency * gl_FragCoord.x + 2.0) * amplitude + 0.5;
    float b = sin(frequency * gl_FragCoord.x + 4.0) * amplitude + 0.5;

    FragColor = vec4(r, g, b, 1.0);
}
