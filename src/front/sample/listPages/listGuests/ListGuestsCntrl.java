package front.sample.listPages.listGuests;

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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    public CheckBox allGuestsCB;
    private IGuest current;
    private ObservableList<IGuest> listOfGuests;
    private final Logger logger = LogManager.getLogger(ListGuestsCntrl.class.getName());
    private Hotel hotel = Hotel.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnBack.setOnAction(event -> Main.getNavigation().GoBack());

        allGuestsCB.setOnAction(event -> changeList());

        listOfGuests = FXCollections.observableArrayList(hotel.getCurrentGuests());
        listOfGuestLV.setItems(listOfGuests);
        listOfGuestLV.setOnMouseClicked(event -> this.current = listOfGuestLV.getSelectionModel().getSelectedItem());

        sortChB.setOnAction(event -> changeList());

        addBtn.setOnAction(event -> add());
        evictBtn.setOnAction(event -> evict());
        update.setOnAction(event -> updateGuest());
        refresh.setOnAction(event -> changeList());

        long numberOfGuest = hotel.numberOfGuests();
        numberOfGuestsLbl.setText(String.valueOf(numberOfGuest));

        checkBtn.setOnAction(event -> {
            int price = hotel.getSum(current);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Считаем чек");

            alert.setHeaderText(null);
            alert.setContentText("Необходимо оплатить: " + price + " RUB");

            alert.showAndWait();
        });


    }

    private void changeList(){
        try {
            if (!allGuestsCB.isSelected() && sortChB.isSelected()) {
                hotel.sortGuests(new SortByDate());
                listOfGuests = FXCollections.observableArrayList(hotel.getCurrentGuests());
            }
            else if (sortChB.isSelected() && allGuestsCB.isSelected()) {
                listOfGuests = FXCollections.observableArrayList(hotel.sortGuests(new SortByDate()));
            } else if(!sortChB.isSelected() && !allGuestsCB.isSelected()){
                listOfGuests = FXCollections.observableArrayList(hotel.getCurrentGuests());
            }
            else {
                listOfGuests = FXCollections.observableArrayList(hotel.getGuests());
            }
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        listOfGuestLV.setItems(listOfGuests);
        long numberOfGuest = hotel.getCurrentGuests().size();
        numberOfGuestsLbl.setText(String.valueOf(numberOfGuest));
    }

    private void updateGuest(){
        UpdateGuest.set(this.current);
        Main.getNavigation().load("/front/sample/updatepages/updateGuest.fxml").show();
        changeList();
    }

    public void add(){
        Main.getNavigation().load("/front/sample/addPages/addGuest/addGuest.fxml").show();
        changeList();
    }

    private void evict(){
        hotel.evictGuest(this.current.getRoom().getId(),this.current);
        changeList();
    }
}
