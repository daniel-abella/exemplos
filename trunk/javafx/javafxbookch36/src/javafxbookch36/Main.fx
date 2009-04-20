package javafxbookch36;

import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.transition.AnimationPath;
import javafx.animation.transition.OrientationType;
import javafx.animation.transition.PathTransition;
import javafx.ext.swing.SwingButton;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.stage.Stage;

var startXVal: Number = 100;
/*
var anim = Timeline {
    autoReverse: true
    keyFrames: [
        KeyFrame { time: 0s values: startXVal => 100 },
        KeyFrame { time: 1s values: startXVal => 150 tween Interpolator.LINEAR }
    ]
    repeatCount: Timeline.INDEFINITE
};
*/

/*
var anim = TranslateTransition {
    autoReverse: true
    repeatCount: Timeline.INDEFINITE
    interpolate: Interpolator.LINEAR
    duration: 1s
    node : bind linha
    fromX: 0
    toX: 300
};
*/

var percurso = Path {
    elements: [
        MoveTo { x: 10  y: 50 },
        HLineTo { x: 70 },
        QuadCurveTo { x: 120  y: 60  controlX: 100  controlY: 0 },
        LineTo { x: 175  y: 55 },
        ArcTo { x: 10  y: 50  radiusX: 100  radiusY: 100  sweepFlag: true },
    ]
    fill: Color.GRAY
};

var anim = PathTransition {
    duration : 5s
    autoReverse: false
    repeatCount: Timeline.INDEFINITE
    interpolate: Interpolator.LINEAR
    node: bind elipse
    path: AnimationPath.createFromPath(percurso)
    orientation: OrientationType.ORTHOGONAL_TO_TANGENT
};

var elipse = Ellipse {
    centerX: 100
    centerY: 50
    radiusX: 4
    radiusY: 8
    fill: Color.BLUE
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
            percurso,
            elipse,
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


