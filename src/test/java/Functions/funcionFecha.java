package Functions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class funcionFecha {

    Date fechaSistema = new Date();

    public String devolverFechaActual() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = formatoFecha.format(fechaSistema);
        return fechaActual;
    }

}
