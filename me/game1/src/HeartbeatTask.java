
import java.util.TimerTask;

/**
 *
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 */
class HeartbeatTask extends TimerTask implements Constants {

    private SpriteTileTest app;
    public HeartbeatTask(SpriteTileTest spriteTileTest) {
        app = spriteTileTest;
    }

    public void run() {
        app.update();
    }
}

