/*
 * Main.fx
 *
 * Created on Mar 8, 2009, 9:16:49 PM
 */

package jfx1;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 * @author kyrios
 */

Stage {
    title: "Application title"
    width: 250
    height: 80
    scene: Scene {
        content: Text {
            font : Font {
                size : 16
            }
            x: 10, y: 30
            content: "Meu primeiro teste"
        }
    }
}