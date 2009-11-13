package g3;

import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.stage.Stage;

var imagem = Image { url: "{__DIR__}Internet.png" };

var icone : ImageView = ImageView {
    image: imagem
    translateX : bind (stageRef.width - imagem.width) / 2
    translateY : bind (stageRef.height - imagem.height) / 2
};

var stageRef : Stage = Stage {
    title: "Apenas barra de menus"
    width : 200
    height : 150
    scene: Scene { content: [ icone ] }
}
