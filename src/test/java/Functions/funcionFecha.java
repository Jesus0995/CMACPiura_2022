package Functions;

import java.text.SimpleDateFormat;
import java.util.Date;


public class funcionFecha {

    Date fechaSistema = new Date();
    funcionExcepciones objError = new funcionExcepciones();

    public String devolverFechaActual() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = formatoFecha.format(fechaSistema);
        return fechaActual;
    }

    public String FormatoFecha(String Fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date valorFecha;
        try {
            valorFecha = formatoFecha.parse(Fecha);
        }catch (Exception Error){
            objError.logError("Fecha ingresada no válida, aplicando fecha actual", Error);
            valorFecha = new Date();
        }
        String fechaValida = formatoFecha.format(valorFecha);
        return fechaValida;
    }

}
