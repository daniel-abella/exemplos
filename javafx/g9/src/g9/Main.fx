package g9;

/* Exemplo obtido via javafx.com/samples */

import javafx.animation.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

var opacity = 1.0;
var fade = Timeline {
    keyFrames: [
        at(0s) { opacity => 0.4 tween Interpolator.LINEAR },
        at(0.5s) { opacity => 0.9 tween Interpolator.LINEAR },
    ]
};

Stage {
    width: 400 height: 250
    opacity: bind opacity;
	title: "Transparent Window"
    scene: Scene {
        fill: Color.WHITE
        content: [
            Text { content: "Surrender Earthling!"
                y: 150 x: 100 font: Font { size: 25 } },
            Rectangle {
                width: 400 height: 250
                fill: Color.rgb(0,0,0,0)
                onMouseEntered: function(e:MouseEvent) {
                    fade.rate = 1.0;
                    fade.play();
                }
                onMouseExited: function(e:MouseEvent) {
                    fade.rate = -1.0;
                    fade.play();
                }
            }
        ]
    }
};

