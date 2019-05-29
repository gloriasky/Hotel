package front.sample.listPages.listRooms;

import back.valadzko.kseniya.facade.Hotel;
import back.valadzko.kseniya.interfaces.model.IRoom;
import back.valadzko.kseniya.interfaces.model.Status;
import back.valadzko.kseniya.utills.comparators.*;
import front.sample.Main;
import front.sample.helpers.BaseController;
import front.sample.listPages.listServices.ServiceSorters;
import front.sample.updatepages.UpdateRoom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListRoomsCntrl extends BaseController implements Initializable {
    public Button btnBack;
    public ListView<IRoom> listOfRoomsLV;
    public TextField dateTextField;
    public ChoiceBox<Sorters> choicesChoiceB;
    public CheckBox freeRoomsChB;
    public Label numberOfFreeRoomsLbl;
    public Button addBtn;
    public Button update;
    public Button refresh;

    private IRoom current;
    private Hotel hotel = Hotel.getInstance();
    private ObservableList<IRoom> listOfRooms;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnBack.setOnAction(event -> Main.getNavigation().GoBack());

        freeRoomsChB.setOnAction(event -> checkBoxListener());

        listOfRooms = FXCollections.observableArrayList(hotel.getRooms());
        listOfRoomsLV.setItems(listOfRooms);

        addBtn.setOnAction(event -> add());
        update.setOnAction(event -> update());
        refresh.setOnAction(event -> checkBoxListener());

        listOfRoomsLV.setOnMouseClicked(event -> this.current = listOfRoomsLV.getSelectionModel().getSelectedItem());

        numberOfFreeRoomsLbl.setText(String.valueOf(hotel.getFreeRooms().size()));

        ObservableList<Sorters> sorters = FXCollections.observableArrayList(Sorters.values());
        choicesChoiceB.setItems(sorters);
        choicesChoiceB.setOnAction(event -> sort());
    }

    public void checkBoxListener(){
        if(freeRoomsChB.isSelected()){
            listOfRooms = FXCollections.observableArrayList(hotel.getFreeRooms());
        }
        else{
            listOfRooms = FXCollections.observableArrayList(hotel.getRooms());
        }
        listOfRoomsLV.setItems(listOfRooms);
        numberOfFreeRoomsLbl.setText(String.valueOf(hotel.getFreeRooms().size()));

    }

    public void sort(){
        Sorters sorter = choicesChoiceB.getSelectionModel().getSelectedItem();
        if(sorter == Sorters.CAPACITY){
            listOfRooms = FXCollections.observableArrayList(hotel.sortRooms(new SortByCapacity()));
        }
        else if(sorter == Sorters.PRICE){
            listOfRooms = FXCollections.observableArrayList(hotel.sortRooms(new SortRoomByPrice()));
        }
        else if(sorter == Sorters.NUMBEROFSTARS){
            listOfRooms = FXCollections.observableArrayList(hotel.sortRooms(new SortByNumberOfStars()));
        }
        else{
            listOfRooms = FXCollections.observableArrayList(hotel.getRooms());
        }
        listOfRoomsLV.setItems(listOfRooms);
        numberOfFreeRoomsLbl.setText(String.valueOf(hotel.getFreeRooms().size()));
    }
    public void update(){
        UpdateRoom.set(current);
        Main.getNavigation().load("/front/sample/updatepages/updateRoom.fxml").show();
        sort();
    }

    public void add(){
        Main.getNavigation().load("/front/sample/addpages/addRoom/addRoom.fxml").show();
    }
}
