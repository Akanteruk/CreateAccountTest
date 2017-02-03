import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Tonia on 30.01.2017.
 */
public class ExcelData{
    public static void main (String[] args) throws IOException {
        File scr= new File("c:\\Tools\\ExcelData\\TestData.xls");
        FileInputStream fis=new FileInputStream(scr);
        HSSFWorkbook wb=new HSSFWorkbook(fis);
        HSSFSheet sheet1=wb.getSheetAt(0);
        int rowcount=sheet1.getLastRowNum();
            for (int i=0;i<rowcount;i++) {
                String data0= sheet1.getRow(i).getCell(0).getStringCellValue();
            }
        wb.close();
    }
}

