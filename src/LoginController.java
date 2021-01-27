import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class LoginController{

    @FXML
    public void Login() throws Exception
    {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root = (Parent) loader.load();
            Stage primaryStage = new Stage();
            Scene scene = new Scene(root);
    
            primaryStage.setTitle("Dashboard Page");
            primaryStage.setScene(scene);
            primaryStage.show();
    }
}