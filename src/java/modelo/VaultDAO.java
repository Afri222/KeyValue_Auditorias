package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.servlet.ServletContext;

/**
 *
 * @author afric
 */
public class VaultDAO {
    
    final File FILE;

    public VaultDAO(ServletContext context) {
        String rutaFisica = context.getRealPath("/WEB-INF/vault.txt");
        this.FILE = new File(rutaFisica);
        /* La ruta no la encuentra bien por algo de NetBeans, en mi caso lo creó y escribió en otra carpeta diferente a donde yo había creado el archivo de texto desde el IDE.
        Para ver exactamente dónde está dejo sin comentar el System.out.println(); para que en la línea de comandos salga la ruta y puedas comprobarlo.
        Es muy robable que tengas que cambiar la ruta para la lectura también, esta vez expresamente en el código.
        Recuerda que según el sistema operativo, IDE, etc tendrás que poner "\", "\\", o "/". */
    }

    public VaultDAO(ServletContext context, String ruta) { // ServletContext context, 
        if (ruta != null) {
            this.FILE = new File (ruta);
            System.out.println("imprime la ruta " + ruta);
        } else {
            String rutaFisica = context.getRealPath(ruta);
            this.FILE = new File(rutaFisica);
            System.out.println("imprime la ruta fisica " + rutaFisica);
        }
    }

    public boolean escribirEnFichero(RegistroPassword rpw) {
        ArrayList<RegistroPassword> lista = leerFichero();
        if (lista == null) {
            lista = new ArrayList<>();
        }
        lista.add(rpw);
        System.out.println("Escribe en el archivo ubicado en: " + FILE.getAbsolutePath());
        try (FileOutputStream fos = new FileOutputStream(FILE, true); // el true corrompe el archivo cada 2x3; habría que leer, añadir en memoria y sobreescribir
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(rpw);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<RegistroPassword> leerFichero() {

        if (!FILE.exists() || FILE.length() == 0) {
            return new ArrayList<>();
        }

        /* try (FileInputStream fr = new FileInputStream(FILE);             // "C:\\Users\\afric\\OneDrive\\Documentos\\NetBeansProjects\\KeyValue_Audiotorias\\build\\web\\WEB-INF\\vault.txt"
                ObjectInputStream ois = new ObjectInputStream(fr)) {
            ArrayList<RegistroPassword> leido = new ArrayList<>();
            RegistroPassword rpw = null;

            rpw = (RegistroPassword) ois.readObject();
            while (rpw != null) {
                leido.add(rpw);
                rpw = (RegistroPassword) ois.readObject();
            }
            return leido; */
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            return (ArrayList<RegistroPassword>) ois.readObject();
        
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
