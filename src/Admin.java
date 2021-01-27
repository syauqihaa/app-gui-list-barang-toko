import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
// import javafx.fxml.FXML;
// import javafx.event.ActionEvent;
// import javafx.scene.control.TextField;
// import javafx.scene.control.PasswordField;

public class Admin extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = (Parent) fxml.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Admin Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }

    // @FXML
    // private TextField username;

    // @FXML
    // private PasswordField password;

    // ActionEvent event = new ActionEvent();

    // public void Login(ActionEvent event) throws Exception
    // {
    //     if(username.getText().equals("admin") && password.getText().equals("admin"))
    //     {
    //         FXMLLoader fxml = new FXMLLoader(getClass().getResource("ListBarang.fxml"));
    //         Parent root = (Parent) fxml.load();
    //         Stage primaryStage = new Stage();
    //         Scene scene = new Scene(root);
    
    //         primaryStage.setTitle("Dashboard Page");
    //         primaryStage.setScene(scene);
    //         primaryStage.show();

    //     }else{
    //         System.out.println("Error");
    //     }
    }