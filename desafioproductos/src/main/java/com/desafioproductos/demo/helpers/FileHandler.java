package com.desafioproductos.demo.helpers;

import com.desafioproductos.demo.exceptions.FileLoadException;
import com.desafioproductos.demo.exceptions.GenericException;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler {

    private static final String DELIMITER = ",";

    /**
     * Read the database file
     * @param dataBaseFileName file name
     * @return a list of list of strings
     * @throws FileLoadException when there is an error loading data base file
     */
    public static List<List<String>>  readDataBaseFile(String dataBaseFileName) throws GenericException {
        List<List<String>> records = new ArrayList<>();
        try {
            var resourceStream = new ClassPathResource(dataBaseFileName).getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(resourceStream));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileLoadException(e.getMessage());
        }

        return records;
    }

    /**
     * set the articles in memory list with the data got from database
     * @param dataBaseFileName file name
     * @param rows rows to add
     * @throws FileLoadException when there is an error loading data base file
     */
    public static void saveToDataBase(String dataBaseFileName, List<String> rows) throws GenericException {
        try {
            FileWriter writer = new FileWriter(new ClassPathResource(dataBaseFileName).getFile());
            for (var currentRow:rows) {
                writer.append(currentRow);
            }
            writer.flush();
            writer.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /*public FileInputStream fis = null;
    public FileOutputStream fos = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
    String xlFilePath;

    public ExcelApiTest(String xlFilePath) throws Exception
    {
        this.xlFilePath = xlFilePath;
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();
    }

    public boolean setCellData(String sheetName, String colName, int rowNum, String value)
    {
        try
        {
            int col_Num = -1;
            sheet = workbook.getSheet(sheetName);

            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName))
                {
                    col_Num = i;
                }
            }

            sheet.autoSizeColumn(col_Num);
            row = sheet.getRow(rowNum - 1);
            if(row==null)
                row = sheet.createRow(rowNum - 1);

            cell = row.getCell(col_Num);
            if(cell == null)
                cell = row.createCell(col_Num);

            cell.setCellValue(value);

            fos = new FileOutputStream(xlFilePath);
            workbook.write(fos);
            fos.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return  false;
        }
        return true;
    }
}*/

}
