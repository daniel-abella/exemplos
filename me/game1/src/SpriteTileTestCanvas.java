
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 */
class SpriteTileTestCanvas extends GameCanvas implements ImageNumbers, Constants {

    public Image[] imageArray;
    public int viewX;
    public int viewY;
    public SpriteTileTest app;

    public SpriteTileTestCanvas(boolean supressKeyEvents) {

        //this must be called
        super(supressKeyEvents);

        try {
            //create and fill our image array
            imageArray = new Image[MAX_IMAGES];
           imageArray[IMG_TILE] = Image.createImage("/tilegfx.png");
            imageArray[IMG_SPRITE] = Image.createImage("/face.png");
        } catch (IOException e) {
            System.err.println("Failed loading images!!!" + e);
        }
        System.out.println("imagens carregadas!");
    }

    public void paint(Graphics g) {
        //use the layer manager to paint all the layers
        app.layerMgr.paint(g, viewX, viewY);
    }

    public void update() {
        //poll the key state
        int keyState = getKeyStates();

        if ((keyState & LEFT_PRESSED) != 0) {
            app.sprite.move(-SPRITE_SPEED, 0);
        }

        if ((keyState & RIGHT_PRESSED) != 0) {
            app.sprite.move(SPRITE_SPEED, 0);
        }

        if ((keyState & UP_PRESSED) != 0) {
            app.sprite.move(0, -SPRITE_SPEED);
        }

        if ((keyState & DOWN_PRESSED) != 0) {
            app.sprite.move(0, SPRITE_SPEED);
        }

        //update our sprite animation
        app.sprite.nextFrame();

        //update tile animation
        if (app.tiledLayer.getAnimatedTile(app.animIndex) == 1) {
            app.tiledLayer.setAnimatedTile(app.animIndex, 2);
        } else {
            app.tiledLayer.setAnimatedTile(app.animIndex, 1);
        }
    }
}

