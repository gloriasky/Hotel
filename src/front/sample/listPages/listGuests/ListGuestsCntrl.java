package front.sample.listPages.listGuests;

import back.valadzko.kseniya.exceptions.SomethingWentWrong;
import back.valadzko.kseniya.facade.Hotel;
import back.valadzko.kseniya.interfaces.model.IGuest;
import back.valadzko.kseniya.utills.comparators.SortByDate;
import front.sample.Main;
import front.sample.helpers.BaseController;
import front.sample.updatepages.UpdateGuest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ListGuestsCntrl extends BaseController implements Initializable {
    public Button btnBack;
    public Label numberOfGuestsLbl;
    public CheckBox sortChB;
    public Button update;
    public ListView<IGuest> listOfGuestLV;
    public Button evictBtn;
    public Button checkBtn;
    public Button addBtn;
    public Button refresh;
    private IGuest current;
    private ObservableList<IGuest> listOfGuests;

    private Hotel hotel = Hotel.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnBack.setOnAction(event -> Main.getNavigation().GoBack());

        listOfGuests = FXCollections.observableArrayList(hotel.getGuests());
        listOfGuestLV.setItems(listOfGuests);

        listOfGuestLV.setOnMouseClicked(event -> this.current = listOfGuestLV.getSelectionModel().getSelectedItem());

        sortChB.setOnAction(event -> changeList());

        addBtn.setOnAction(event -> add());
        evictBtn.setOnAction(event -> evict());
        refresh.setOnAction(event -> changeList());

        long numberOfGuest = hotel.numberOfGuests();
        numberOfGuestsLbl.setText(String.valueOf(numberOfGuest));
        update.setOnAction(event -> update());

        checkBtn.setOnAction(event -> {
            int price = hotel.getSum(current);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Считаем чек");

            alert.setHeaderText(null);
            alert.setContentText("Необходимо оплатить: " + price + " RUB");

            alert.showAndWait();
        });


    }

    public void changeList(){
        if(sortChB.isSelected()){
            try {
                listOfGuests = FXCollections.observableArrayList(hotel.sortGuests(new SortByDate()));
            } catch (SomethingWentWrong somethingWentWrong) {

            }
        }
        else{
            listOfGuests = FXCollections.observableArrayList(hotel.getGuests());
        }
        listOfGuestLV.setItems(listOfGuests);
        long numberOfGuest = hotel.numberOfGuests();
        numberOfGuestsLbl.setText(String.valueOf(numberOfGuest));
    }

    public void update(){
        UpdateGuest.set(this.current);
        Main.getNavigation().load("/front/sample/updatepages/updateGuest.fxml").Show();
        changeList();
    }

    public void add(){
        Main.getNavigation().load("/front/sample/addPages/addGuest/addGuest.fxml").Show();
        changeList();
    }

    private void evict(){
        hotel.evictGuest(this.current.getRoom().getId(),this.current);
        changeList();
    }
}
