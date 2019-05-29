package front.sample;

import back.valadzko.kseniya.facade.Hotel;
import front.sample.helpers.Navigation;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    private static Navigation navigation;
    private static Hotel hotel = Hotel.getInstance();

    public static Navigation getNavigation()
    {
        return navigation;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        navigation = new Navigation(primaryStage);

        primaryStage.setTitle("Электронный администратор");
        primaryStage.show();
        primaryStage.setResizable(false);

        Main.getNavigation().load("/front/sample/start/sample.fxml").show();
    }


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        hotel.end();
        super.stop();
    }

}
