package g2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.stage.Stage;

var logo = "http://kyriosdata.com.br/images/kyrios.jpg";

var imagem = ImageView {
    image: Image { url: logo width: 200 preserveRatio: true }
};

Stage {
    title: "Ícone Kyrios"
    scene: Scene { content: imagem }
}