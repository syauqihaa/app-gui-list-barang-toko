import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Dashboard extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        AnchorPane root = fxml.load();
        primaryStage.setTitle("Dashboard Page");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
