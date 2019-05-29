package front.sample.start;

import front.sample.Main;
import front.sample.helpers.BaseController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {
    @FXML
    public Button startBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startBtn.setOnAction(event -> Main.getNavigation().load("/front/sample/menu/menu.fxml").show());
    }
}
