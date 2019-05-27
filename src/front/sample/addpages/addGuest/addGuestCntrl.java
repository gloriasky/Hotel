package front.sample.addpages.addGuest;

import back.valadzko.kseniya.facade.Hotel;
import back.valadzko.kseniya.interfaces.model.IGuest;
import back.valadzko.kseniya.interfaces.model.IRoom;
import back.valadzko.kseniya.interfaces.model.IService;
import back.valadzko.kseniya.interfaces.model.Status;
import back.valadzko.kseniya.model.Guest;
import back.valadzko.kseniya.model.Room;
import back.valadzko.kseniya.utills.IdGenerator;
import front.sample.Main;
import front.sample.helpers.BaseController;
import front.sample.helpers.ChangeListenerImpl;
import back.valadzko.kseniya.utills.DateHelper;
import front.sample.listPages.listGuests.ListGuestsCntrl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class addGuestCntrl extends BaseController implements Initializable {
    public Button btnBack;
    public TextField name;
    public TextField lastName;
    public TextField arrivalDate;
    public Label wrongArrivalDate;
    public TextField dateOfRelease;
    public Label wrongReleaseDate;
    public ChoiceBox<IRoom> freeRooms;
    public ListView<IService> services;
    public Button submit;
    public Button reset;

    private IRoom current;

    private Hotel hotel = Hotel.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnBack.setOnAction(event -> Main.getNavigation().GoBack());

        MultipleSelectionModel<IService> servicesSelectionModel = services.getSelectionModel();
        servicesSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        submit.setOnAction(event -> {
            try {
                String firstName = name.getText();
                String lasnNameStr = lastName.getText();
                Date dateOfArrival = DateHelper.stringToDate(arrivalDate.getText());
                Date releaseDate = DateHelper.stringToDate(dateOfRelease.getText());

                IGuest guest = new Guest(firstName, lasnNameStr);
                guest.setDateOfRelease(releaseDate);
                guest.setArrivalDate(dateOfArrival);
                guest.setId(IdGenerator.generateId());
                ObservableList<IService> curr = servicesSelectionModel.getSelectedItems();
                List<IService> guestServ = new ArrayList<>();
                guestServ.addAll(curr);
                guest.setServices(guestServ);
                hotel.addGuest(guest);
                hotel.setGuest(current.getId(),guest);

                Main.getNavigation().GoBack();
            }catch (Exception ex){

            }
        });

        reset.setOnAction(event -> {
            name.setText("");
            lastName.setText("");
            arrivalDate.setText("");
            dateOfRelease.setText("");
        });

        dateOfRelease.textProperty().addListener(ChangeListenerImpl.getDataCheckListener(wrongReleaseDate));
        arrivalDate.textProperty().addListener(ChangeListenerImpl.getDataCheckListener(wrongArrivalDate));

        ObservableList<IRoom> langs = FXCollections.observableArrayList(hotel.getRooms());
        freeRooms.setItems(langs);

        freeRooms.setOnAction(event -> this.current = freeRooms.getValue());

        ObservableList<IService> serv = FXCollections.observableArrayList(hotel.getServices());
        services.setItems(serv);
    }
}
