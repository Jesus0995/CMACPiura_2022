package Functions;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteExcelFile {

    public WriteExcelFile() {
    }

    public void writeExcel(String filepath, String sheetName, String[] dataToWrite) throws IOException {
        File file = new File(filepath);

        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        //objeto de la hoja
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();//cantidad de filas que existen
        //objeto fila
        XSSFRow row = newSheet.getRow(0);

        XSSFRow newRow = newSheet.createRow(rowCount + 1);

        for (int i = 0; i < row.getLastCellNum(); i++) {
            XSSFCell newCell = newRow.createCell(i);
            newCell.setCellValue(dataToWrite[i]);

        }

        inputStream.close();
        //escribir informacion en el excel
        FileOutputStream outputStream = new FileOutputStream(file);

        newWorkbook.write(outputStream);
        outputStream.close();

    }

    //crear un valor en una celda especifica
    public void writeCellValue(String filepath, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException {

        File file = new File(filepath);

        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
        //crear fila, el numero de fila a acceder
        XSSFRow row = newSheet.getRow(rowNumber);
        //celda donde vamos a leer
        XSSFCell firstCell = row.getCell(cellNumber - 1);

        System.out.println("first cell value is:" + firstCell.getStringCellValue());

        XSSFCell nextCell = row.createCell(cellNumber);

        nextCell.setCellValue(resultText);

        System.out.println("nextcell value:" + nextCell.getStringCellValue());

        inputStream.close();
        //metodo para escribir la informacion
        FileOutputStream outputStream = new FileOutputStream(file);

        newWorkbook.write(outputStream);

        outputStream.close();


    }


}
