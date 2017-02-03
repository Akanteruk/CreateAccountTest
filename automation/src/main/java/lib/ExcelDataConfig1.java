package lib;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Tonia on 31.01.2017.
 */
public class ExcelDataConfig1
{
    HSSFWorkbook wb;
    HSSFSheet sheet1;
    public ExcelDataConfig1(String excelPath)
    {
        try
        {
            File scr= new File(excelPath);
            FileInputStream fis=new FileInputStream(scr);
            wb=new HSSFWorkbook(fis);
            sheet1 = wb.getSheetAt(0);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public String getData(String sheetName, int row, int column)
    {
        HSSFCell cell = sheet1.getRow(row).getCell(column);
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }

    public int getRowCount(int sheetIndex)
    {
        int row=wb.getSheetAt(sheetIndex).getLastRowNum();
        row=row+1;
        return row;
    }

}
