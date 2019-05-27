package front.sample.menu;

import front.sample.Main;
import front.sample.helpers.BaseController;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Menu extends BaseController implements Initializable {


    public Button guestsBtn;
    public Button roomsBtn;
    public Button servicesBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        guestsBtn.setOnAction(event -> Main.getNavigation().load("/front/sample/listPages/listGuests/listGuests.fxml").Show());

        roomsBtn.setOnAction(event -> Main.getNavigation().load("/front/sample/listPages/listRooms/listRooms.fxml").Show());

        servicesBtn.setOnAction(event -> Main.getNavigation().load("/front/sample/listPages/listServices/listServices.fxml").Show());
    }
}
