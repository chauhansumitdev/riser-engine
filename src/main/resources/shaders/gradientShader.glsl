#version 330 core
out vec4 FragColor;

void main() {
    // Define two colors for the gradient
    vec3 colorTop = vec3(0.0, 0.5, 1.0); // Light blue color at the top
    vec3 colorBottom = vec3(1.0, 0.5, 0.0); // Orange color at the bottom

    // Calculate the interpolation factor
    float gradientFactor = gl_FragCoord.y / 600.0; // Adjust 600.0 to match your viewport height

    // Interpolate between the two colors based on the gradient factor
    vec3 gradientColor = mix(colorBottom, colorTop, gradientFactor);

    FragColor = vec4(gradientColor, 1.0);
}
