package modelo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author afric
 */
public class VaultDAO {
    final File FILE;
    
    public VaultDAO(String ruta) {
         this.FILE = new File("/WEB-INF/vault.txt");
    }
    
    public boolean escribirEnFichero(RegistroPassword rpw) {
        try (FileOutputStream fos = new FileOutputStream(FILE, true);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(rpw);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<RegistroPassword> leerFichero() {
        try (FileInputStream fr = new FileInputStream(FILE);
                ObjectInputStream ois = new ObjectInputStream(fr)) {
            ArrayList<RegistroPassword> leido = new ArrayList<>();
            RegistroPassword rpw = null;
            
            rpw = (RegistroPassword) ois.readObject();
            while(rpw != null) {
                leido.add(rpw);
                rpw = (RegistroPassword) ois.readObject();
            }
            return leido;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
