import java.awt.*;
import javax.swing.*;

public class VonKochSnowflake extends JPanel {
    private final int depth;

    public VonKochSnowflake(int depth) {
        this.depth = depth;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSnowflake(g, depth, 50, 300, 550, 300);
    }

    private void drawSnowflake(Graphics g, int depth, int x1, int y1, int x5, int y5) {
        if (depth == 0) {
            g.drawLine(x1, y1, x5, y5);
        } else {
            int deltaX = x5 - x1;
            int deltaY = y5 - y1;

            int x2 = x1 + deltaX / 3;
            int y2 = y1 + deltaY / 3;

            int x3 = (int) (0.5 * (x1 + x5) + Math.sqrt(3) * (y1 - y5) / 6);
            int y3 = (int) (0.5 * (y1 + y5) + Math.sqrt(3) * (x5 - x1) / 6);

            int x4 = x1 + 2 * deltaX / 3;
            int y4 = y1 + 2 * deltaY / 3;

            drawSnowflake(g, depth - 1, x1, y1, x2, y2);
            drawSnowflake(g, depth - 1, x2, y2, x3, y3);
            drawSnowflake(g, depth - 1, x3, y3, x4, y4);
            drawSnowflake(g, depth - 1, x4, y4, x5, y5);
        }
    }

    public static void main(String[] args) {
        int depth = 4; // Depth of recursion
        JFrame frame = new JFrame();
        frame.setTitle("Von Koch Snowflake");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new VonKochSnowflake(depth));
        frame.setVisible(true);
    }
}
