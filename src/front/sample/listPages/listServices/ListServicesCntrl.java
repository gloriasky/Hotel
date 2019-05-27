package front.sample.listPages.listServices;

import back.valadzko.kseniya.facade.Hotel;
import back.valadzko.kseniya.interfaces.model.IService;
import back.valadzko.kseniya.utills.comparators.SortByAlphabet;
import back.valadzko.kseniya.utills.comparators.SortServiceByPrice;
import front.sample.Main;
import front.sample.helpers.BaseController;
import front.sample.updatepages.UpdateService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListServicesCntrl extends BaseController implements Initializable {

    public Button btnBack;
    public Label numberOfServicesLbl;
    public ChoiceBox<ServiceSorters> sortCB;
    public ListView<IService> services;
    public Button addBtn;
    public Button update;
    public Button refresh;
    private IService current;

    private ObservableList<IService> listOfServices;
    private Hotel hotel = Hotel.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnBack.setOnAction(event -> Main.getNavigation().GoBack());

        List<IService> servicesList = hotel.getServices();
        numberOfServicesLbl.setText(String.valueOf(servicesList.size()));

        listOfServices = FXCollections.observableArrayList(servicesList);
        services.setItems(listOfServices);

        ObservableList<ServiceSorters> sorters = FXCollections.observableArrayList(ServiceSorters.values());
        sortCB.setItems(sorters);
        sortCB.setValue(ServiceSorters.NONE);
        sortCB.setOnAction(event -> sort());

        services.setOnMouseClicked(event -> this.current = services.getSelectionModel().getSelectedItem());

        update.setOnAction(event -> update());
        addBtn.setOnAction(event -> add());
        refresh.setOnAction(event -> sort());
    }

    public void sort(){
        ServiceSorters sorter = sortCB.getSelectionModel().getSelectedItem();
        if(sorter == ServiceSorters.NONE){
            listOfServices = FXCollections.observableArrayList(hotel.getServices());
        }
        else if(sorter == ServiceSorters.PRICE){
            listOfServices = FXCollections.observableArrayList(hotel.sortServices(new SortServiceByPrice()));
        }
        else{
            listOfServices = FXCollections.observableArrayList(hotel.sortServices(new SortByAlphabet()));
        }
        services.setItems(listOfServices);
        numberOfServicesLbl.setText(String.valueOf(listOfServices.size()));
    }
    public void update(){
        UpdateService.set(this.current);
        Main.getNavigation().load("/front/sample/updatepages/updateService.fxml").Show();
        sort();
    }

    public void add(){
        Main.getNavigation().load("/front/sample/addpages/addService/addService.fxml").Show();
        sort();
    }
}
