package lib;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Tonia on 31.01.2017.
 */
public class ExcelDataConfig
{
    HSSFWorkbook wb;

    public ExcelDataConfig(String excelPath)
    {
        try
        {
            File scr= new File(excelPath);
            FileInputStream fis=new FileInputStream(scr);
            wb = new HSSFWorkbook(fis);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public String getData(String sheetName, int row, int column)
    {
        HSSFSheet sheet = wb.getSheet(sheetName);
        HSSFCell cell = sheet.getRow(row).getCell(column);
        cell.setCellType(CellType.STRING);

        return cell.getStringCellValue();
    }

    public int getRowCount(String sheetName)
    {
        int row = wb.getSheet(sheetName).getLastRowNum();
        row = row + 1;
        return row;
    }
}
