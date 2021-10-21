package Functions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class funcionExcepciones {

    public void logError(String detalleError,Exception Error){
        System.out.println(LocalDateTime.now().toString()+" - "+ detalleError + " - "+ Error.getMessage());
        registraTXT(LocalDateTime.now().toString()+" - "+ detalleError + " - "+Error.getMessage());
    }

    public void registraTXT (String mensaje) {
        Date Date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("ddMMyyyy");
       // String ruta = "target/pantallazo/"+fecha.format(Date)+"_pantalla.jpg";
        String ruta = "target\\LogErrores\\"+fecha.format(Date)+"LogError.txt";
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            String data = mensaje;
            File file = new File(ruta);
            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data );
            bw.write( "\r \n");
            //  System.out.println("información agregada!");
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
