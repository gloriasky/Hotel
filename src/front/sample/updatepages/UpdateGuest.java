package front.sample.updatepages;

import back.valadzko.kseniya.facade.Hotel;
import back.valadzko.kseniya.interfaces.model.IGuest;
import back.valadzko.kseniya.interfaces.model.IRoom;
import back.valadzko.kseniya.interfaces.model.IService;
import back.valadzko.kseniya.services.GuestManager;
import back.valadzko.kseniya.utills.DateHelper;
import front.sample.Main;
import front.sample.helpers.BaseController;
import front.sample.helpers.ChangeListenerImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateGuest extends BaseController implements Initializable {

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
    private static IGuest guest;
    private IRoom current;
    private Hotel hotel = Hotel.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setFields();
        btnBack.setOnAction(event -> Main.getNavigation().GoBack());

        MultipleSelectionModel<IService> serviceSelectionModel = services.getSelectionModel();
        serviceSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);


        submit.setOnAction(event -> {
            try {
                String firstName = name.getText();
                String lasnNameStr = lastName.getText();
                Date dateOfArrival = DateHelper.stringToDate(arrivalDate.getText());
                Date releaseDate = DateHelper.stringToDate(dateOfRelease.getText());

                guest.setFirstName(firstName);
                guest.setLastName(lasnNameStr);
                guest.setDateOfRelease(releaseDate);
                guest.setArrivalDate(dateOfArrival);

                ObservableList<IService> curr = serviceSelectionModel.getSelectedItems();
                List<IService> guestServ = new ArrayList<>();
                guestServ.addAll(curr);
                guest.setServices(guestServ);

                GuestManager.getInstance().update(guest.getId(),guest);
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



        freeRooms.setOnAction(event -> this.current = freeRooms.getValue());

        ObservableList<IService> serv = FXCollections.observableArrayList(hotel.getServices());
        services.setItems(serv);

    }
    public static void set(IGuest current){
        guest = current;
    }
    private void setFields(){
        name.setText(guest.getFirstName());
        lastName.setText(guest.getLastName());
        arrivalDate.setText(DateHelper.dateToString(guest.getArrivalDate()));
        dateOfRelease.setText(DateHelper.dateToString(guest.getDateOfRelease()));
        ObservableList<IRoom> rooms = FXCollections.observableArrayList(hotel.getRooms());
        freeRooms.setItems(rooms);
        freeRooms.setValue(guest.getRoom());
        ObservableList<IService> serviceObservableList = FXCollections.observableArrayList(hotel.getServices());
        services.setItems(serviceObservableList);
    }

}
