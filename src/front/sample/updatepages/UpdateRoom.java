package front.sample.updatepages;

import back.valadzko.kseniya.facade.Hotel;
import back.valadzko.kseniya.interfaces.model.IRoom;
import back.valadzko.kseniya.interfaces.model.Status;
import back.valadzko.kseniya.services.RoomManager;
import front.sample.Main;
import front.sample.helpers.BaseController;
import front.sample.helpers.ChangeListenerImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateRoom extends BaseController implements Initializable {

    public Button btnBack;
    public TextField capacityField;
    public Label wrongCapacity;
    public TextField numberOfStarsField;
    public Label wrongNumberOfStars;
    public TextField priceField;
    public Label wrongPrice;
    public ChoiceBox<Status> statusBox;
    public Button submit;
    public Button reset;

    private Hotel hotel = Hotel.getInstance();
    private static IRoom room;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setFields();
        btnBack.setOnAction(event -> Main.getNavigation().GoBack());

        submit.setOnAction(event -> {
            try {
                int capacity = Integer.parseInt(capacityField.getText());
                int price = Integer.parseInt(priceField.getText());
                int numberOfStars = Integer.parseInt(numberOfStarsField.getText());
                Status status = statusBox.getValue();

                room.setCapacity(capacity);
                room.setPrice(price);
                room.setStatus(status);
                room.setNumberOfStars(numberOfStars);

                RoomManager.getInstance().update(room);

                Main.getNavigation().GoBack();
            }catch (Exception ex){
                System.out.println(ex);
            }

        });
        reset.setOnAction( event -> {
            capacityField.setText("");
            priceField.setText("");
            numberOfStarsField.setText("");
        });

        capacityField.textProperty().addListener(ChangeListenerImpl.getNumberCheckListener(wrongCapacity));
        priceField.textProperty().addListener(ChangeListenerImpl.getNumberCheckListener(wrongPrice));
        numberOfStarsField.textProperty().addListener(ChangeListenerImpl.getNumberCheckListener(wrongNumberOfStars));

        ObservableList<Status> statuses = FXCollections.observableArrayList(Status.values());
        statusBox.setItems(statuses);
    }
    public static void set(IRoom current){
        room = current;
    }

    private void setFields(){
        capacityField.setText(String.valueOf(room.getCapacity()));
        priceField.setText(String.valueOf(room.getPrice()));
        numberOfStarsField.setText(String.valueOf(room.getNumberOfStars()));
        statusBox.setValue(room.getStatus());
    }
}
