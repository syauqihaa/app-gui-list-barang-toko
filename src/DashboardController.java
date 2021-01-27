import java.net.URL;
import java.util.ResourceBundle;
// import com.mysql.jdbc.*;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

public class DashboardController implements Initializable{
    


    public TextField tfId;

    public TextField tfNama;

    public TextField tfHarga;

    public TextField tfPersediaan;


    public TableView<Dashboards> tvBarang = new TableView<>();

    public TableColumn<Dashboards, Integer> colId = new TableColumn<>();

    public TableColumn<Dashboards, String> colNama = new TableColumn<>();

    public TableColumn<Dashboards, Integer> colHarga = new TableColumn<>();

    public TableColumn<Dashboards, Integer> colPersediaan = new TableColumn<>();

    public Button btnTambah;
    public Button btnHapus;
    public Button btnUbah;

    Connection connection = null;

    public void Aksi(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == btnTambah)
        {
            Tambah();
        }else if(actionEvent.getSource() == btnUbah)
        {
            Ubah();
        }else if(actionEvent.getSource() == btnHapus)
        {
            Hapus();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        showBarang();
    }

    public Connection getConnection()
    {
        String user = "root";
        String password = "";
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/listBarang",user,password);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return connection;
    }

    public ObservableList<Dashboards> getBarangList()
    {
        ObservableList<Dashboards> ListBarang = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM barang";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Dashboards dashboards;
            while(rs.next())
            {
                dashboards = new Dashboards(rs.getInt("id"),rs.getString("nama"),rs.getInt("harga"),rs.getInt("persediaan"));
                ListBarang.add(dashboards);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListBarang;
    }

    public void showBarang()
    {
        ObservableList<Dashboards> list = getBarangList();

        colId.setCellValueFactory(new PropertyValueFactory<Dashboards, Integer>("id"));
        colNama.setCellValueFactory(new PropertyValueFactory<Dashboards, String>("nama"));
        colHarga.setCellValueFactory(new PropertyValueFactory<Dashboards, Integer>("harga"));
        colPersediaan.setCellValueFactory(new PropertyValueFactory<Dashboards, Integer>("persediaan"));

        tvBarang.setItems(list);
    }

    public void Tambah()
    {
        Connection connection = getConnection();
        PreparedStatement stmt;

        try {
            stmt = connection.prepareStatement("INSERT INTO barang VALUES(?,?,?,?)");
            stmt.setInt(1, Integer.parseInt(tfId.getText()));
            stmt.setString(2, tfNama.getText());
            stmt.setInt(3, Integer.parseInt(tfHarga.getText()));
            stmt.setInt(4, Integer.parseInt(tfPersediaan.getText()));
            int i = stmt.executeUpdate();
            System.out.println(i);
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        showBarang();
    }

    public void Hapus()
    {
        Connection connection = getConnection();
        PreparedStatement stmt;

        try {
            stmt = connection.prepareStatement("DELETE FROM barang WHERE id=?");
            stmt.setInt(1,Integer.parseInt(tfId.getText()));

            int i = stmt.executeUpdate();
            System.out.println(i);

        } catch (Exception e) {
            e.printStackTrace();
        }
        showBarang();
    }

    public void Ubah()
    {
        Connection connection = getConnection();
        PreparedStatement stmt;

        try {
            stmt = connection.prepareStatement("UPDATE barang SET nama=?,harga=?,persediaan=? WHERE id=?");
            stmt.setInt(4, Integer.parseInt(tfId.getText()));
            stmt.setString(1, tfNama.getText());
            stmt.setInt(2, Integer.parseInt(tfHarga.getText()));
            stmt.setInt(3, Integer.parseInt(tfPersediaan.getText()));
            int i = stmt.executeUpdate();
            System.out.println(i);
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        showBarang();      
    }
}
