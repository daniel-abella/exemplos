package g5;

import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

var srv = "grin.hq.nasa.gov";
var nasa = "http://{srv}/IMAGES/SMALL/GPN-2000-001124.jpg";
var img = Image { url: nasa backgroundLoading: true
                placeholder: Image { url: "{__DIR__}aguarde.png" } };
var perc = Text { x: 40 y: 20 content: bind progresso(img.progress) };

function progresso(percentual : Number) : String {
    if (percentual >= 99.9) then "" else "{percentual}%"
}

def cena = Scene { content: [ ImageView { image: img }, perc ] };

Stage { width: 640 height: 649 scene : cena }