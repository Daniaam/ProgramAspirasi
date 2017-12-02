
package tugasakhir;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author IlhamTaufiqurrahmanS
 */
public class FXMLDocumentController implements Initializable {

    
    @FXML
    private JFXTextField Linksubmit;
    @FXML
    private JFXTextArea taAspirasi;
    @FXML
    private TextField Nama;
    @FXML
    private TextField Absen;
    @FXML
    private TextField Hp;
    @FXML
    private TextField Kelas;
    @FXML
    private JFXButton submit;
    @FXML
    private JFXButton keluar;
    @FXML
    private TextField nisn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonSubmit (ActionEvent event) throws SQLException {
        
   
   Connection connection;
   PreparedStatement st;
        try{ 
             if(nisn.getText().length()!=0 && Nama.getText().length() !=0 && Absen.getText().length() !=0 && Hp.getText().length() !=0 && Kelas.getText().length() !=0 && taAspirasi.getText().length() !=0){
       connection =DriverManager.getConnection("jdbc:mysql://localhost/osmac?zeroDate TimeBehavior=convertToNull", "root", "");
    st=connection.prepareStatement("insert into tabel_aspirasi(nisn,nama,absen,kelas,no_hp,aspirasi) values(?,?,?,?,?,?)");
    st.setString(1,nisn.getText());
    st.setString(2,Nama.getText());
    st.setString(3,Absen.getText());
    st.setString(4,Kelas.getText());
    st.setString(5,Hp.getText());
    st.setString(6,taAspirasi.getText());
        
    st.execute();
        JOptionPane.showMessageDialog(null, "Tersimpan");
       
             }else if(nisn.getText().length()==0 || Nama.getText().length() ==0 || Absen.getText().length() ==0 || Hp.getText().length() ==0 || Kelas.getText().length() ==0 || taAspirasi.getText().length() ==0){
                 JOptionPane.showMessageDialog(null, "Mohon Isi Form Dengan Lengkap!!");
                 Nama.requestFocus();
             }  
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
   }
    }

    @FXML
    private void buttonKeluar(ActionEvent event) throws IOException {
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("login.fxml"));
        Scene scene =new Scene(fxmlLoader.load(),956,662);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
