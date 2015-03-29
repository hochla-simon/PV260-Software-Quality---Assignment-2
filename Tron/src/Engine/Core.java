package Engine;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Core {

    private static final DisplayMode modes[]
            = {
                //new DisplayMode(1920,1080,32,0),
//                new DisplayMode(1680, 1050, 32, 0),
                //new DisplayMode(1280,1024,32,0),
                new DisplayMode(1600, 900, 32, 0),
                new DisplayMode(800, 600, 32, 0),
                new DisplayMode(800, 600, 24, 0),
                new DisplayMode(800, 600, 16, 0),
                new DisplayMode(640, 480, 32, 0),
                new DisplayMode(640, 480, 24, 0),
                new DisplayMode(640, 480, 16, 0),};
    private boolean running;
    protected ScreenManager sm;
    private final Game game;
    private final Presentation presentation;

    public Core(Game game, Presentation presentation) {
        this.game = game;
        this.presentation = presentation;
    }

    public void stop() {
        running = false;
    }

    public void run() {
        try {
            init();
            gameLoop();
        } finally {
            sm.restoreScreen();
        }
    }

    public void init() {
        sm = new ScreenManager();
        DisplayMode dm = sm.findFirstCompatibaleMode(modes);
        sm.setFullScreen(dm);
        Window w = sm.getFullScreenWindow();
        w.setFont(new Font("Arial", Font.PLAIN, 20));
        w.setBackground(Color.WHITE);
        w.setForeground(Color.RED);
        w.setCursor(w.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "null"));
        w.addKeyListener(game);
        w.addMouseListener(game);
        w.addMouseMotionListener(game);
        running = true;
    }

    public void gameLoop() {
        while (running) {
            game.move(sm.getWidth(), sm.getHeight());
            presentation.draw(sm);
            sm.update();

            try {
                Thread.sleep(20);
            } catch (Exception ex) {
            }
        }
    }
}
