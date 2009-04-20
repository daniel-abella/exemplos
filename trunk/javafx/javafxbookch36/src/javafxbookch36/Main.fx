package javafxbookch36;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.Interpolator;
import javafx.ext.swing.SwingButton;
import javafx.scene.shape.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

var startXVal: Number = 100;
var anim = Timeline {
    autoReverse: true
    keyFrames: [
        KeyFrame { time: 0s values: startXVal => 100 },
        KeyFrame { time: 1s values: startXVal => 150 tween Interpolator.LINEAR }
    ]
    repeatCount: Timeline.INDEFINITE
};

var btStart = SwingButton {
    text: "Start"
    enabled: bind not anim.running
    action: function():Void {
        anim.playFromStart();
    }
};

var btPause = SwingButton {
    text: "Pause"
    enabled: bind not anim.paused and anim.running
    action: function():Void {
        anim.pause();
    }
};

var btResume = SwingButton {
    text: "Resume"
    enabled: bind anim.paused
    action: function():Void {
        anim.play();
    }
};

var btStop = SwingButton {
    text: "Stop"
    enabled: bind anim.running
    action: function():Void {
        anim.stop();
    }
};

var linha = Line {
    startX: bind startXVal
    startY: 50
    endX: 200
    endY: 400
    strokeWidth: 4
    stroke: Color.BLUE
};

Stage {
    title: "Metronome 1"
    width: 400
    height: 500
    visible: true
    scene: Scene {
        content: [
            linha,
            HBox {
                translateX: 50
                translateY: 420
                spacing: 10
                content: [
                    btStart, btPause, btResume, btStop
                ]
            }
        ]
    }

}


