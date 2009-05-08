package g5;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.stage.Stage;

var srv = "grin.hq.nasa.gov";
var img = "http://{srv}/IMAGES/SMALL/GPN-2000-001124.jpg";

Stage {
    scene: Scene {
        width: 640 height: 649
        content: 
            ImageView { image:
                Image {
                    url: img
                    backgroundLoading: true
                    placeholder: Image { url: "{__DIR__}aguarde.png" }
                }
            }
    }
}