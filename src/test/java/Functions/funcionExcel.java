package Functions;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class funcionExcel {

    // Ruta del archivo
    public static String rutaArchivos = "C:\\Proyectos\\Archivos";

    public String[][] LeerExcel(String Archivo, Integer Hoja) {
        try {
            File archivoExcel = new File(rutaArchivos +"\\" + Archivo);
            FileInputStream streamExcel = new FileInputStream(archivoExcel);
            // Obtenemos Libro
            XSSFWorkbook libroExcel = new XSSFWorkbook(streamExcel);
            // Obtenemos numero de Hoja
            XSSFSheet hojaExcel = libroExcel.getSheetAt(Hoja);

            Short numeroColumnas = hojaExcel.getRow(0).getLastCellNum();
            Integer numeroFilas = hojaExcel.getLastRowNum() + 1;
            String[][] contenidoExcel = new String[numeroFilas][numeroColumnas.intValue()];

            Integer fila = 0;
            Integer columna = 0;
            //Recorrer lineas
            Iterator<Row> lineasExcel = hojaExcel.iterator();
            while (lineasExcel.hasNext()){
                Row linea = lineasExcel.next();
                //Recorrer celdas de la linea
                Iterator<Cell> celdasExcel = linea.cellIterator();
                while (celdasExcel.hasNext()){
                    Cell celda = celdasExcel.next();
                    contenidoExcel[fila][columna] = celda.toString();
                    columna++;
                }
                fila++;
                columna = 0;
            }
            libroExcel.close();
            streamExcel.close();
            return contenidoExcel;

        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
            return  null;
        }
    }

    public Object LeerCeldaExcel(String Archivo, Integer Hoja, Integer Fila, Integer Columna){
        try {

            Object ValorCelda;

            File archivoExcel = new File(rutaArchivos +"\\" + Archivo);
            FileInputStream streamExcel = new FileInputStream(archivoExcel);
            // Obtenemos Libro
            XSSFWorkbook libroExcel = new XSSFWorkbook(streamExcel);
            // Obtenemos numero de Hoja
            XSSFSheet hojaExcel = libroExcel.getSheetAt(Hoja);

            XSSFCell celda = hojaExcel.getRow(Fila).getCell(Columna);

            switch (celda.getCellType()){
                case STRING:
                    ValorCelda = celda.getStringCellValue();
                    break;
                case NUMERIC:
                    ValorCelda = celda.getNumericCellValue();
                    break;
                default:
                    ValorCelda = celda.getRawValue().toString();
                    break;
            }

            libroExcel.close();
            streamExcel.close();
            return ValorCelda;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
