package g3;

import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

var borda = Rectangle {
    width: 320 height: 45
    fill : LinearGradient {
        endX: 0.0
        endY: 1.0
        stops: [
            Stop { color: Color.web("0xAEBBCC") },
            Stop { color: Color.web("0x6D84A3") offset: 1.0 } ]
    }
};

var icone = ImageView {
    image: Image { url: "{__DIR__}Internet.png" }
};


Stage {
    title: "Apenas barra de menus"
    scene: Scene { content: [ borda icone ] }
}