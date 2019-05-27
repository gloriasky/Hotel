package front.sample.addpages.addRoom;

import back.valadzko.kseniya.facade.Hotel;
import back.valadzko.kseniya.interfaces.model.Status;
import back.valadzko.kseniya.model.Room;
import back.valadzko.kseniya.utills.IdGenerator;
import front.sample.Main;
import front.sample.helpers.BaseController;
import front.sample.helpers.ChangeListenerImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AddRoomCntrl extends BaseController implements Initializable {
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
    private Status currentStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnBack.setOnAction(event -> Main.getNavigation().GoBack());

        submit.setOnAction(event -> {
            try {
                int capacity = Integer.parseInt(capacityField.getText());
                int price = Integer.parseInt(priceField.getText());
                int numberOfStars = Integer.parseInt(numberOfStarsField.getText());
                Status status = statusBox.getValue();

                Room room = new Room(IdGenerator.generateId(), price, capacity, numberOfStars, status);
                hotel.addRoom(room);
                Main.getNavigation().GoBack();
            }catch (Exception ex){
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
}
