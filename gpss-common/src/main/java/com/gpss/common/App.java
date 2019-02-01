package com.gpss.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.gpss.common.exception.ReportInternalException;
import com.gpss.common.utils.Excel2003Utils;
import com.gpss.common.utils.IMappingParameter;

/**
 * Hello world!
 *
 */
public class App implements IMappingParameter
{
    public static void main( String[] args ) throws ReportInternalException, IOException
    {
        String sheetName = "测试Excel格式";
        String sheetTitle = "测试Excel格式";
        List<String> columnNames = new LinkedList<>();
        columnNames.add("日期-String");
        columnNames.add("日期-Date");
        columnNames.add("时间戳-Long");
        columnNames.add("客户编码");
        columnNames.add("整数");
        columnNames.add("带小数的正数");

        File file = new File("L:\\temp\\test.xls");
        OutputStream outputStream = new FileOutputStream(file);
        OutputStream outputStream2 = new FileOutputStream(file);
        InputStream inputStream = new FileInputStream(file);
        //写入标题--第二种方式
//        Excel2003Utils.writeExcelTitle("L:\\temp", "a", sheetName, columnNames, sheetTitle, false);
        
        List<List<Object>> objects = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            List<Object> dataA = new LinkedList<>();
            dataA.add("2016-09-05 17:27:25");
            dataA.add(new Date(1451036631012L));
            dataA.add(1451036631012L);
            dataA.add("000628");
            dataA.add(i);
            dataA.add(1.323 + i);
            objects.add(dataA);
        }
        try {
            //写入数据--第二种方式
//            Excel2003Utils.writeExcelData("L:\\temp", "a", sheetName, objects);
//            Excel2003Utils.writeExcelData(outputStream2, inputStream, sheetName, objects);

            //直接写入数据--第一种方式
//            Excel2003Utils.writeExcel("L:\\temp", "a", sheetName, columnNames, sheetTitle, objects, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
