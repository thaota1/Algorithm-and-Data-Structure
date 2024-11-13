import java.awt.*;
import javax.swing.*;

public class SierpinskiTriangle extends JPanel {

    // Recursive method to draw the Sierpinski Triangle
    public void drawTriangle(Graphics g, int x, int y, int size, int depth) {
        if (depth == 0) {
            // Base case: draw the triangle if depth is 0
            int[] xPoints = {x, x + size, x + size / 2};
            int[] yPoints = {y, y, y - (int) (Math.sqrt(3) * size / 2)};
            g.fillPolygon(xPoints, yPoints, 3);  // Fill the triangle
        } else {
            // Recursive case: divide the triangle into 3 smaller triangles
            int newSize = size / 2;
            int newY = y - (int) (Math.sqrt(3) * newSize / 2);

            // Recursively draw 3 smaller triangles
            drawTriangle(g, x, y, newSize, depth - 1);  // Top triangle
            drawTriangle(g, x + newSize, y, newSize, depth - 1);  // Right triangle
            drawTriangle(g, x + newSize / 2, newY, newSize, depth - 1);  // Left triangle
        }
    }

    // Override the paintComponent method to draw the fractal
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the initial position and size for the largest triangle
        int x = 50;  // Starting x position
        int y = 500; // Starting y position (near the bottom of the screen)
        int size = 400;  // Side length of the largest triangle
        int depth = 5;  // Depth of recursion

        // Draw the Sierpinski Triangle
        drawTriangle(g, x, y, size, depth);
    }

    // Main method to run the program
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Triangle");
        SierpinskiTriangle panel = new SierpinskiTriangle();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(panel);
        frame.setVisible(true);
    }
}
