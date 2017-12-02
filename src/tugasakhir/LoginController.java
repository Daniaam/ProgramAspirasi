
package tugasakhir;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author IlhamTaufiqurrahmanS
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField userlogin;
    @FXML
    private Button masuk;
    @FXML
    private JFXPasswordField passlogin;
    @FXML
    private TextField userdaftar;
    @FXML
    private PasswordField passdaftar;
    @FXML
    private PasswordField pass2;
    @FXML
    private Button daftar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonMasuk(ActionEvent event) throws SQLException {
        String user=userlogin.getText();
        String pass=passlogin.getText();
        Connection connection;
        PreparedStatement st;
        try {
             connection = DriverManager.getConnection("jdbc:mysql://localhost/osmac?zeroDate TimeBehavior=convertToNull", "root", "");
            st = connection.prepareStatement("SELECT * FROM `login` WHERE `username` = ? AND `password` = ?");
            st.setString(1, userlogin.getText());
            st.setString(2, passlogin.getText());
            ResultSet result = st.executeQuery();
            if (result.next()) {
                JOptionPane.showMessageDialog(null, "Login Berhasil!");
                ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        Scene scene =new Scene(fxmlLoader.load(),724,614);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        
            } else if(user.contains("admin") && pass.contains("admin")){
                JOptionPane.showMessageDialog(null, "Welcome Admin !!");
                ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("admin.fxml"));
        Scene scene =new Scene(fxmlLoader.load(),794,647);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
                }  else {
                JOptionPane.showMessageDialog(null, "Username atau Password Salah!");
                userlogin.setText("");
                userlogin.requestFocus();
                passlogin.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal!");
        }
    }
    @FXML
    private void buttonDaftar(ActionEvent event) {
        
   Connection connection;
   PreparedStatement st;
        try{ 
            if(userdaftar.getText().length()!=0 && passdaftar.getText().length() !=0 && pass2.getText().length() !=0 ){
       connection =DriverManager.getConnection("jdbc:mysql://localhost/osmac?zeroDate TimeBehavior=convertToNull", "root", "");
    st=connection.prepareStatement("insert into login(username,password) values(?,?)");
    st.setString(1,userdaftar.getText());
    st.setString(2,passdaftar.getText());
     pass2.getText();
       
        st.execute();
        JOptionPane.showMessageDialog(null, "Anda Telah Terdaftar!! \nSilahkan Login");
        userdaftar.setText("");
        passdaftar.setText("");
        pass2.setText("");
            }
            else if(userdaftar.getText().length()==0 || passdaftar.getText().length() ==0 || pass2.getText().length() ==0){
                 JOptionPane.showMessageDialog(null, "Mohon Isi Data Dengan Lengkap!!");
                  userdaftar.requestFocus();
                  pass2.requestFocus();
                  passdaftar.requestFocus();
            }
            
        
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
   }
    }
    
}
