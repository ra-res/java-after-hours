import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Aquarium extends Frame implements Runnable {
    private static final long serialVersionUID = 1L;
    private MediaTracker tracker;
    private Image aquariumImage, memoryImage;
    private Graphics memoryGraphics;
    private Image[] fishImages = new Image[2];
    private Thread thread;
    private final static int NUMBER_OF_FISH = 12, THREAD_SLEEP = 120;
    private Vector<Fish> fishes = new Vector<>();
    private boolean runOK = true;

    public Aquarium() {

        setTitle("Aquarium");

        tracker = new MediaTracker(this);
        fishImages[0] = Toolkit.getDefaultToolkit().getImage("images/fish.png");
        tracker.addImage(fishImages[0], 0);

        fishImages[1] = Toolkit.getDefaultToolkit().getImage("images/fish2.png");
        tracker.addImage(fishImages[1], 0);

        aquariumImage = Toolkit.getDefaultToolkit().getImage("images/ocean.gif");
        tracker.addImage(aquariumImage, 0);

        try {
            tracker.waitForID(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                runOK = false;
                dispose();
            }
        });
        setSize(aquariumImage.getWidth(this), aquariumImage.getHeight(this));
        setResizable(false);
        setVisible(true);

        memoryImage = createImage(getSize().width, getSize().height);
        memoryGraphics = memoryImage.getGraphics();

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < NUMBER_OF_FISH; i++) {
            Rectangle edges = new Rectangle(0 + getInsets().left, 0 + getInsets().top,
                    getSize().width - (getInsets().left + getInsets().right),
                    getSize().height - (getInsets().top) + getInsets().bottom);
            fishes.add(new Fish(fishImages[0], fishImages[1], edges, this));
            try {
                Thread.sleep(THREAD_SLEEP);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(fishes.size());
        Fish fish;
        while (runOK) {
            for (int i = 0; i < NUMBER_OF_FISH; i++) {
                fish = fishes.elementAt(i);
                fish.swim();
            }
            try {
                Thread.sleep(THREAD_SLEEP);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            repaint();
        }
    }

    public void update(Graphics g) {
        memoryGraphics.drawImage(aquariumImage, 0, 0, this);
        for (int i = 0; i < NUMBER_OF_FISH; i++) {
            fishes.elementAt(i).drawFishImage(memoryGraphics);
        }
        g.drawImage(memoryImage, 0, 0, this);
    }
}
