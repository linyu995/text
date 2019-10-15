package o2o.com.artisan.o2o.Excel;

import o2o.com.artisan.o2o.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;

public class ExcelTest extends BaseTest {

   /* public static void main(String[]args) throws FileNotFoundException {
        parseExcel("C:\\nga_adminboundaries_tabulardata.xlsx");

    }*/

/*
    private static void parseExcel(String path) throws FileNotFoundException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        File file = new File(path);
        FileInputStream fis = null;
        Workbook workBook = null;
        if(file.exists()){
            try{
                fis=new FileInputStream(file);
                workBook=WorkbookFactory.create(fis);
                int numberofsheets=workBook.getNumberOfSheets();
                for(int s=0;s<numberofsheets;s++){
                    Sheet sheetAt = workBook.getSheetAt(s);
                    *//**
                     * 获取表名
                     *//*
                    String sheetName=sheetAt.getSheetName();
                    *//**
                     * 获取
                     *//*


                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }



    }*/

}
