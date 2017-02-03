package DDT;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Tonia on 31.01.2017.
 */
public class ExcelRead {
    public static void main (String[] args) throws IOException {
        File scr= new File("c:\\Tools\\ExcelData\\TestData.xls");
        FileInputStream fis=new FileInputStream(scr);
        HSSFWorkbook wb=new HSSFWorkbook(fis);
        HSSFSheet sheet1=wb.getSheetAt(0);
        String data0= sheet1.getRow(0).getCell(0).getStringCellValue();
        System.out.println("Data from Excel is"+data0);
        String data1= sheet1.getRow(0).getCell(1).getStringCellValue();
        System.out.println("Data from Excel is"+data1);
        wb.close();
        }

}
