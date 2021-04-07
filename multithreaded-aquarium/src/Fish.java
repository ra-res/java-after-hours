import java.awt.*;
import java.util.Random;

public class Fish {

    private Component tank;
    Image image1, image2;
    Point location, velocity;
    Rectangle edges;
    Random random;

    Fish(Image image1, Image image2, Rectangle edges, Component tank) {
        random = new Random(System.currentTimeMillis());
        this.tank = tank;
        this.image1 = image1;
        this.image2 = image2;
        this.edges = edges;
        this.location = new Point(100 + (Math.abs(random.nextInt()) % 300),
                100 + (Math.abs(100 + random.nextInt()) % 100));
        this.velocity = new Point(random.nextInt() % 8, random.nextInt() % 8);
    }

    public void swim() {
        if (random.nextInt() % 7 <= 1) {
            velocity.x += random.nextInt() % 4;
            velocity.x = Math.min(velocity.x, 8);
            velocity.x = Math.max(velocity.x, -8);
            velocity.y += random.nextInt() % 4;
            velocity.y = Math.min(velocity.y, 8);
            velocity.y = Math.max(velocity.y, -8);
        }
        location.x += velocity.x;
        location.y += velocity.y;
        if (location.x < edges.x) {
            location.x = edges.x;
            velocity.x = velocity.x;
        }

        if ((location.x + image1.getWidth(tank)) > (edges.x + edges.width)) {
            location.x = edges.x + edges.width - image1.getWidth(tank);
            velocity.x = -velocity.x;
        }
        if (location.y < edges.y) {
            location.y = edges.y;
            velocity.y = -velocity.y;
        }
        if ((location.y + image1.getHeight(tank)) > (edges.y + edges.height)) {
            location.y = edges.y + edges.height - image1.getHeight(tank);
            velocity.y = -velocity.y;
        }
    }

    public void drawFishImage(Graphics memoryGraphics) {
        if (velocity.x > 0) {
            memoryGraphics.drawImage(image1, location.x, location.y, tank);
        } else {
            memoryGraphics.drawImage(image2, location.x, location.y, tank);
        }
    }
}