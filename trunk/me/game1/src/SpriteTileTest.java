
import java.util.Timer;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.game.Layer;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 */
public class SpriteTileTest extends MIDlet implements CommandListener,
    Constants, ImageNumbers {

    boolean firstTime;
    public int appFlags;
    public Sprite sprite;
    public TiledLayer tiledLayer;
    public int animIndex;
    public LayerManager layerMgr;
    private Timer timer_;
    private SpriteTileTestCanvas canvas_;
    private Display display_;
    private HeartbeatTask heartTask_;
    private int[] frameSequence_ = {0, 1, 2, 1, 0};

    public SpriteTileTest() {
        firstTime = true;
    }

    public void startApp() throws MIDletStateChangeException {

        if (firstTime) {
            display_ = Display.getDisplay(this);
            canvas_ = new SpriteTileTestCanvas(true);
            canvas_.app = this;

            //add tile map
            tiledLayer = new TiledLayer(16, 16, canvas_.imageArray[IMG_TILE], 16, 16);

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    //create an animated tile
                    tiledLayer.setCell(i, j, 1);
                }
            }
            animIndex = tiledLayer.createAnimatedTile(0);

            //make a line down the middle that's animated
            for (int y = 0; y < 10; y++) {
                tiledLayer.setCell(5, y, animIndex);
            }

            //create sprite
            sprite = new Sprite(canvas_.imageArray[IMG_SPRITE], 16, 16);
            sprite.setPosition(0, 0);

            //create a ping-pong style animation sequence
            sprite.setFrameSequence(frameSequence_);

            //create the layer manager
            layerMgr = new LayerManager();

            //add to the layer manager
            layerMgr.append((Layer) sprite);
            layerMgr.append((Layer) tiledLayer);
            timer_ = new Timer();
            heartTask_ = new HeartbeatTask(this);
            timer_.schedule(heartTask_, 0, ANIM_PERIOD);
            firstTime = false;
        }
        display_.setCurrent(canvas_);
        canvas_.repaint();
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable s) {
    }

    public void update() {
        canvas_.update();
        canvas_.repaint();
    }
} //class

