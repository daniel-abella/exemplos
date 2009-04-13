package javafxbookch31;

import javafx.ext.swing.SwingButton;
import javafx.ext.swing.SwingCheckBox;
import javafx.ext.swing.SwingTextField;
import javafx.lang.FX;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

var args = FX.getArguments();
var stageStyle = StageStyle.DECORATED;
if (sizeof args >= 1) {
    if (args[0].toLowerCase() == "transparent") {
        stageStyle = StageStyle.TRANSPARENT;
    } else if (args[0].toLowerCase() == "undecorated") {
        stageStyle = StageStyle.UNDECORATED;
    }
}

var resizable:Boolean = true;
var fullScreen:Boolean = false;
var title:String = "Stage Coach";
var stageRef:Stage;

var fonte:Font = Font {
    name : "Sans Serif"
    size:14
}

var xText:Text = Text {
    textOrigin: TextOrigin.TOP
    font: fonte
    content: bind "x: {stageRef.x}"
}

var yText = Text {
    textOrigin: TextOrigin.TOP
    font: fonte
    content: bind "y: {stageRef.y}"
}

var heightText = Text {
    textOrigin: TextOrigin.TOP
    font: fonte
    content: bind "height: {stageRef.height}"
}

var widthText = Text {
    textOrigin: TextOrigin.TOP
    font: fonte
    content: bind "width: {stageRef.width}"
}

var focusedText = Text {
    textOrigin: TextOrigin.TOP
    font: fonte
    content: bind "focused: {stageRef.focused}"
}

var resizableText = Text {
    textOrigin: TextOrigin.TOP
    font: fonte
    content: bind "resizable: {stageRef.resizable}"
}

var fullscreenText = Text {
    textOrigin: TextOrigin.TOP
    font: fonte
    content: bind "fullScreen: {stageRef.fullScreen}"
}

var titleText = Text {
    textOrigin: TextOrigin.TOP
    font: fonte
    content: "title:"
}

stageRef = Stage {
    title: bind title
    width: 330
    height: 550
    style: stageStyle
    resizable: bind resizable
    fullScreen: bind fullScreen
    onClose: function():Void {
        println("Stage is closing");
    }
    scene: Scene {
        fill: Color.TRANSPARENT
        content: [
            Rectangle {
                width: 300
                height: 500
                arcWidth: 50
                arcHeight: 50
                fill: Color.GREEN
                onMouseDragged: function(me:MouseEvent):Void {
                    stageRef.x += me.dragX;
                    stageRef.y += me.dragY;
                }
            },
            VBox {
                translateX: 10
                translateY: 10
                spacing: 10
                content: [
                    xText,
                    yText,
                    heightText,
                    widthText,
                    focusedText,
                    SwingCheckBox {
                        blocksMouse: true
                        text: "Resizable: "
                        selected: bind resizable with inverse
                    },
                    resizableText,
                    SwingCheckBox {
                        blocksMouse: true
                        text: "Full-screen: "
                        selected: bind fullScreen with inverse
                    },
                    fullscreenText,
                    titleText,
                    SwingTextField {
                        blocksMouse: true
                        text: bind title with inverse
                        columns: 15
                    },
                    SwingButton {
                        text: "toBack()"
                        action: function():Void {
                            stageRef.toBack();
                        }
                    },
                    SwingButton {
                        text: "toFront()"
                        action: function():Void {
                            stageRef.toFront();
                        }
                    },
                    SwingButton {
                        text: "clos()"
                        action: function():Void {
                            stageRef.close();
                        }
                    },
                    SwingButton {
                        text: "FX.exit()"
                        action: function():Void {
                            FX.exit();
                        }
                    }
                ]
            }
        ]
    }
}




