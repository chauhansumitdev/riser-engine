package com.engine.render;

import com.engine.core.Triangle;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Window {

    private long window;
    private final int width;
    private final int height;
    private final String title;

    public Window(int width, int height, String title){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void create(){
        GLFWErrorCallback.createPrint(System.err).set();

        if(!GLFW.glfwInit()){
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);

        window = GLFW.glfwCreateWindow(width, height, title, 0, 0);

        if(window == 0){
            throw new RuntimeException("Failed to create the window");
        }

        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwSwapInterval(1);
        GLFW.glfwShowWindow(window);

        GL.createCapabilities();

        Triangle triangle = new Triangle(new float[]{
                -0.5f, -0.5f, 0.0f,  // bottom left
                0.5f, -0.5f, 0.0f,  // bottom right
                0.0f,  0.5f, 0.0f   // top center
        });

        while (!GLFW.glfwWindowShouldClose(window)) {
            clear();
            triangle.render();
            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }

        triangle.cleanup();
        close();
    }

    public void clear(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    }

    public void close(){
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null).free();
    }

    public long getWindow(){
        return window;
    }
}
