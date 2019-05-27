package front.sample.updatepages;

import back.valadzko.kseniya.facade.Hotel;
import back.valadzko.kseniya.interfaces.model.IRoom;
import back.valadzko.kseniya.interfaces.model.IService;
import back.valadzko.kseniya.model.Service;
import back.valadzko.kseniya.services.ServiceManager;
import back.valadzko.kseniya.utills.DateHelper;
import back.valadzko.kseniya.utills.IdGenerator;
import front.sample.Main;
import front.sample.helpers.BaseController;
import front.sample.helpers.ChangeListenerImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateService extends BaseController implements Initializable {
    public Button btnBack;
    public TextField SectionField;
    public TextField nameField;
    public TextField priceField;
    public Label wrongPrice;
    public Button submit;
    public Button reset;

    private Hotel hotel = Hotel.getInstance();
    private static IService service;

    public static void set(IService current) {
        service = current;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setFields();
        submit.setOnAction(event -> {
            try {
                String section = SectionField.getText();
                String name = nameField.getText();
                int price = Integer.parseInt(priceField.getText());

                service.setSection(section);
                service.setPrice(price);
                service.setName(name);

                ServiceManager.getInstance().update(service);
                Main.getNavigation().GoBack();
            } catch (Exception ex) {

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

    private void setFields() {
        SectionField.setText(service.getSection());
        nameField.setText(service.getName());
        priceField.setText(service.getPrice().toString());
    }

}
