package javafxbookch35;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;

var levels:Number[] = [30, 40, 50, 45, 35];
var selectedBarIndex = 0;
def MAX_LEVEL = 230;
def MIN_LEVEL= 10;

var linearGradient = LinearGradient {
    startX: 0.0 startY: 0.0 endX: 0.0 endY: 1.0
    stops: [ 
        Stop { offset: 0.0 color: Color.LIGHTGREEN },
        Stop { offset: 1.0 color: Color.DARKBLUE } ]
};

function onKeyPressed(ke : KeyEvent):Void {
    def totalLevels = sizeof levels;
    def direita = levels[selectedBarIndex] <= MAX_LEVEL - 10;
    def esquerda = levels[selectedBarIndex] > MIN_LEVEL;
    if (ke.code == KeyCode.VK_RIGHT and direita) {
        levels[selectedBarIndex] += 10;
    } else if (ke.code == KeyCode.VK_LEFT and esquerda) {
        levels[selectedBarIndex] -= 10;
    } else if (ke.code == KeyCode.VK_DOWN) {
        selectedBarIndex = (selectedBarIndex + 1) mod totalLevels;
    } else if (ke.code == KeyCode.VK_UP) {
        selectedBarIndex = (totalLevels + selectedBarIndex - 1) mod totalLevels;
    }
}


var groupRef = Group {
    translateX: 10
    onKeyPressed: function(ke:KeyEvent):Void { onKeyPressed(ke); }
    content: bind for (level in levels)
        Rectangle {
            x: 0 y: 60 + (indexof level * 30) width: level height: 20
            fill: linearGradient
            opacity: if (indexof level == selectedBarIndex) 1 else 0.7;
            onMousePressed: function(me:MouseEvent):Void {
                selectedBarIndex = indexof level;
            }
            onMouseDragged: function(me:MouseEvent):Void {
                if (me.x >= MIN_LEVEL and me.x <= MAX_LEVEL) {
                    levels[indexof level] = me.x;
                }
            }
        }
};

var textos: Text[] = for (linha in [0..1]) {
    Text {
        translateX: 25 translateY: 20 + (200 * indexof linha)
        textOrigin: TextOrigin.TOP
        font: Font { name: "Sans Serif" size: 18 }
        content: bind if (indexof linha == 0) "Binding" else "Bar:{selectedBarIndex + 1}, Level: {levels[selectedBarIndex]}"
        fill: Color.WHITE
    }
};

Stage {
    title: "Binding Example"
    scene: Scene {
        fill: Color.BLUE
        width: 240
        height: 320
        content: [ textos[0], groupRef, textos[1] ]
    }
}

groupRef.requestFocus();