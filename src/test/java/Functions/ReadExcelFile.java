package Functions;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ReadExcelFile {

    public ReadExcelFile() {

    }

    public static void main(String[] args) throws Exception {
        File src = new File("C:\\CajaPiuraCMAC2021\\target\\DatosExcel\\DatosCreditoEmpresarial.xlsx");

        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheetAt(0);
        String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
        System.out.println("Data from Excel is" + data0);
        String data1 = sheet1.getRow(0).getCell(1).getStringCellValue();
        System.out.println("Data from excel is" + data1);
        wb.close();

    }

}

   /*
    public void readExcel(String filepath, String sheetName) throws IOException {

        File file = new File(filepath);

        FileInputStream inputStream = new FileInputStream(file);
        //objeto donde se guarda el excel
        XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);

        XSSFSheet newSheet = newWorkBook.getSheet(sheetName);

        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();


        for (int i = 0; i <= rowCount; i++) {
            XSSFRow row = newSheet.getRow(i);

            for(int j=0; j<row.getLastCellNum();j++){
                System.out.printf(row.getCell(j).getStringCellValue()+"||");

            }

        }

    }

    public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {

        File file = new File(filepath);

        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        XSSFRow row = newSheet.getRow(rowNumber);

        XSSFCell cell = row.getCell(cellNumber);

        //System.out.println("first cell value is:" +firstCell.getStringCellValue());
        return cell.getStringCellValue();
    }



    */




