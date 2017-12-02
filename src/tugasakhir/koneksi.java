package tugasakhir;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



/**
 *
 * @author SMK TELKOM
 */
public class koneksi {
    Connection koneksi;
    public Connection getConnection(){
        try {
           koneksi=DriverManager.getConnection("jdbc:mysql://localhost/osmac","root","");
           JOptionPane.showMessageDialog(null,"Koneksi Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi ke database GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        return koneksi;
    }
}
