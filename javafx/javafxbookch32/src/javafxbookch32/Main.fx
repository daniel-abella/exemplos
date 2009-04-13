package javafxbookch32;

import javafx.ext.swing.SwingButton;
import javafx.ext.swing.SwingComboBox;
import javafx.ext.swing.SwingComboBoxItem;
import javafx.ext.swing.SwingSlider;
import javafx.scene.Cursor;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.stage.Stage;

var sceneRef : Scene;

var cursorNames = [
    "DEFAULT",
    "CROSSHAIR",
    "WAIT",
    "TEXT",
    "HAND",
    "MOVE",
    "N_RESIZE",
    "NE_RESIZE",
    "E_RESIZE",
    "SE_RESIZE",
    "S_RESIZE",
    "SW_RESIZE",
    "W_RESIZE",
    "NW_RESIZE",
    "NONE"
];

var cursors = [
    Cursor.DEFAULT,
    Cursor.CROSSHAIR,
    Cursor.WAIT,
    Cursor.TEXT,
    Cursor.HAND,
    Cursor.MOVE,
    Cursor.N_RESIZE,
    Cursor.NE_RESIZE,
    Cursor.E_RESIZE,
    Cursor.SE_RESIZE,
    Cursor.S_RESIZE,
    Cursor.SW_RESIZE,
    Cursor.W_RESIZE,
    Cursor.NW_RESIZE,
    Cursor.NONE
];

var selectedCursorIndex : Integer;
var fillVals = 255;

Stage {
    title : "On the Scene"
    scene: sceneRef = Scene {
        width: 600
        height: 350
        cursor: bind cursors[selectedCursorIndex]
        fill: bind Color.rgb(fillVals, fillVals, fillVals)
        content: [
          SwingSlider {
            minimum: 0
            maximum: 255
            value: bind fillVals with inverse
            vertical: true
        },
        VBox {
            spacing: 10
            content: [
               Text {
                   textOrigin: TextOrigin.TOP
                   font: Font.font("Sans Serif", 14)
                   content: bind "Scene x: {sceneRef.x}"
               },
               Text {
                   textOrigin: TextOrigin.TOP
                   font: Font.font("Sans Serif", 14)
                   content: bind "Scene y: {sceneRef.y}"
               },
               Text {
                   textOrigin: TextOrigin.TOP
                   font: Font.font("Sans Serif", 14)
                   content: bind "Scene width: {sceneRef.width}"
               },
               Text {
                   textOrigin: TextOrigin.TOP
                   font: Font.font("Sans Serif", 14)
                   content: bind "Scene height: {sceneRef.height}"
               },
               SwingButton {
                   text: "lookup()"
                   action: function():Void {
                       var textRef = sceneRef.lookup("sceneHeight") as Text;
                       println(textRef.content);
                   }
               },
               SwingButton {
                   text: "onTheScene.css"
                   action: function():Void {
                       sceneRef.stylesheets = "{__DIR__}onTheScene.css";
                   }
               },
               SwingButton {
                   text: "changeOfScene.css"
                   action: function():Void {
                       sceneRef.stylesheets = "{__DIR__}changeOfScene.css";
                   }
               }
            ]
        },
        VBox {
            spacing: 10
            content: [
                Text {
                    id: "stageX"
                    textOrigin: TextOrigin.TOP
                    font: Font.font("Sans Serif", 14)
                    content: bind "Stage x: {sceneRef.stage.x}"
                },
                Text {
                    id: "stageY"
                    textOrigin: TextOrigin.TOP
                    font: Font.font("Sans Serif", 14)
                    content: bind "Stage y: {sceneRef.stage.y}"
                },
                Text {
                    textOrigin: TextOrigin.TOP
                    font: Font.font("Sans Serif", 14)
                    content: bind "Stage width: {sceneRef.stage.width}"
                },
                Text {
                    textOrigin: TextOrigin.TOP
                    font: Font.font("Sans Serif", 14)
                    content: bind "Stage height: {sceneRef.stage.height}"
                },
                SwingComboBox {
                    items: bind for (cursorName in cursorNames) {
                        SwingComboBoxItem {
                            text: cursorName
                        }
                    }
                    selectedIndex: bind selectedCursorIndex with inverse
                }
            ]
        }
      ]
      stylesheets: "{__DIR__}onTheScene.css"
    }
}

insert Text {
    translateX: 20
    translateY: 15
    textOrigin: TextOrigin.TOP
    font: Font.font("Sans Serif", FontWeight.BOLD, 14)
    content: bind "sceneRef.fill: {sceneRef.fill}"
}
into sceneRef.content;

