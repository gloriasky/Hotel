package front.sample.addpages.addService;

import back.valadzko.kseniya.facade.Hotel;
import back.valadzko.kseniya.model.Service;
import back.valadzko.kseniya.utills.IdGenerator;
import front.sample.Main;
import front.sample.helpers.BaseController;
import front.sample.helpers.ChangeListenerImpl;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class AddServiceCntrl extends BaseController implements Initializable {
    public Button btnBack;
    public TextField SectionField;
    public TextField nameField;
    public TextField priceField;
    public Label wrongPrice;
    public Button submit;
    public Button reset;
    private final Logger logger = LogManager.getLogger(AddServiceCntrl.class.getName());
    private Hotel hotel = Hotel.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        submit.setOnAction(event -> {
            try {
                String section = SectionField.getText();
                String name = nameField.getText();
                int price = Integer.parseInt(priceField.getText());

                Service service = new Service(IdGenerator.generateId(), section, name, price);
                hotel.addService(service);

                Main.getNavigation().GoBack();
            }catch (Exception ex){
                logger.error(ex.getMessage());
            }
        });
        priceField.textProperty().addListener(ChangeListenerImpl.getNumberCheckListener(wrongPrice));

        reset.setOnAction(event -> {
            SectionField.setText("");
            nameField.setText("");
            priceField.setText("0");
        });


        btnBack.setOnAction(event -> Main.getNavigation().GoBack());
    }
}
