/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 * FXML Controller class
 *
 * @author IlhamTaufiqurrahmanS
 */
public class AdminController extends javax.swing.JFrame implements Initializable {

    private ObservableList<tampil_data> data;
    @FXML
    private TableView<tampil_data> tabel_admin;
    @FXML
    private TableColumn<tampil_data, String> nisn_tabel;
    @FXML
    private TableColumn<tampil_data, String> nama_tabel;
    @FXML
    private TableColumn<tampil_data, String> absen_tabel;
    @FXML
    private TableColumn<tampil_data, String> hp_tabel;
    @FXML
    private TableColumn<tampil_data, String> kelas_tabel;
    @FXML
    private TableColumn<tampil_data, String> aspirasi_tabel;
    @FXML
    private TextField nisn;
    @FXML
    private TextField nama;
    @FXML
    private TextField absen;
    @FXML
    private TextField hp;
    @FXML
    private TextField kelas;
    @FXML
    private Button update;
    @FXML
    private Button hapus;
    @FXML
    private Button exit;
    @FXML
    private JFXTextArea taAspirasi;
    @FXML
    private JFXTextField cari;
    @FXML
    private Button search;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Tampil_Tabel();
    }

    @FXML
    private void button_Update(ActionEvent event) {
         Connection connection;
   PreparedStatement st;
        try {
            connection =DriverManager.getConnection("jdbc:mysql://localhost/osmac?zeroDate TimeBehavior=convertToNull", "root", "");
    st=connection.prepareStatement("UPDATE tabel_aspirasi SET nisn=?,nama=?,absen=?,kelas=?,no_hp=?,aspirasi=? WHERE nisn='"+nisn.getText()+"'");
    st.setString(1,nisn.getText());
    st.setString(2,nama.getText());
    st.setString(3,absen.getText());
    st.setString(4,kelas.getText());
    st.setString(5,hp.getText());
    st.setString(6,taAspirasi.getText());
     st.execute();
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Update!");
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
Tampil_Tabel();
    }

    @FXML
    private void button_Hapus(ActionEvent event) {
        Connection connection;
   PreparedStatement st;
        try {
            connection =DriverManager.getConnection("jdbc:mysql://localhost/osmac?zeroDate TimeBehavior=convertToNull", "root", "");
    st=connection.prepareStatement("DELETE FROM `tabel_aspirasi` WHERE nisn=?");
    st.setString(1,nisn.getText());

     st.execute();
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        nama.setText("");
        absen.setText("");
        hp.setText("");
        kelas.setText("");
        nisn.setText("");
        taAspirasi.setText("");
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
Tampil_Tabel();
        
    }

    @FXML
    private void button_Exit(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("login.fxml"));
        Scene scene =new Scene(fxmlLoader.load(),956,662);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

    }

    private void Tampil_Tabel() {

        Connection connection;
        PreparedStatement st;

        try {
            data = FXCollections.observableArrayList();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/osmac?zeroDate TimeBehavior=convertToNull", "root", "");
            st = connection.prepareStatement("SELECT * FROM tabel_aspirasi");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                data.add(new tampil_data(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }

        } catch (Exception e) {
        }
        nisn_tabel.setCellValueFactory(new PropertyValueFactory<>("nisn"));
        nama_tabel.setCellValueFactory(new PropertyValueFactory<>("nama"));
        absen_tabel.setCellValueFactory(new PropertyValueFactory<>("absen"));
        hp_tabel.setCellValueFactory(new PropertyValueFactory<>("hp"));
        kelas_tabel.setCellValueFactory(new PropertyValueFactory<>("kelas"));
        aspirasi_tabel.setCellValueFactory(new PropertyValueFactory<>("aspirasi"));
        tabel_admin.setItems(data);
    }

    @FXML
    private void tabel_klik(MouseEvent event) {
        tampil_data pl=tabel_admin.getItems().get(tabel_admin.getSelectionModel().getSelectedIndex());
        nama.setText(pl.getNama());
        absen.setText(pl.getAbsen());
        hp.setText(pl.getHp());
        kelas.setText(pl.getKelas());
        nisn.setText(pl.getNisn());
        taAspirasi.setText(pl.getAspirasi());
    }

    @FXML
    private void button_Search(ActionEvent event) {
        Connection connection;
        PreparedStatement st;

        try {
            if(cari.getText().length()==0){
                Tampil_Tabel();
            }else{
            data = FXCollections.observableArrayList();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/osmac?zeroDate TimeBehavior=convertToNull", "root", "");
            st = connection.prepareStatement("SELECT * FROM tabel_aspirasi where nisn='"+cari.getText()+"'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                data.add(new tampil_data(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
            }
        } catch (Exception e) {
        }
        nisn_tabel.setCellValueFactory(new PropertyValueFactory<>("nisn"));
        nama_tabel.setCellValueFactory(new PropertyValueFactory<>("nama"));
        absen_tabel.setCellValueFactory(new PropertyValueFactory<>("absen"));
        hp_tabel.setCellValueFactory(new PropertyValueFactory<>("hp"));
        kelas_tabel.setCellValueFactory(new PropertyValueFactory<>("kelas"));
        aspirasi_tabel.setCellValueFactory(new PropertyValueFactory<>("aspirasi"));
        tabel_admin.setItems(data);
        
    }

   
    
    
           
    
}                        

