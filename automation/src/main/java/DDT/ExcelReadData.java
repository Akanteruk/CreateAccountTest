package DDT;

import lib.ExcelDataConfig1;

/**
 * Created by Tonia on 31.01.2017.
 */
public class ExcelReadData
{
    public static void main (String[] args)
    {
        ExcelDataConfig1 excel = new ExcelDataConfig1("c:\\Tools\\ExcelData\\TestData.xls");
        System.out.println(excel.getData("sheetName", 0,0));

    }
}
