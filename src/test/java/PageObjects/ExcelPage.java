package PageObjects;

import Functions.funcionExcel;

public class ExcelPage {

    private funcionExcel objExcel = new funcionExcel();

    public String[][] LeerArchivoExcel(String arg0, Integer hoja) {
        String[][] datosExcel = objExcel.LeerExcel(arg0, hoja);
        return datosExcel;
    }
}