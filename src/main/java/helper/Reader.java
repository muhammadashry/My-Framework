package helper;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reader {
    private CSVReader csvReader;
    String[][] csvCell = new String[100][100];
    int j=0,i=0;
    private List<String[]> userData;
    private WebDriver driver;
    private FileInputStream fis = null;
    public Reader(WebDriver driver) {
    this.driver = driver;
    }

    public Object[][] getAllUsersCSVData(String CSV_PATH) throws IOException, CsvException {
            userData = new ArrayList<>();
            csvReader = new CSVReader(new FileReader(CSV_PATH));
            userData = csvReader.readAll();
            Iterator<String[]> ite = userData.iterator();
            csvCell = new String[userData.size()][userData.get(0).length];
            while (ite.hasNext()) {
                String[] data = ite.next();
                for (i = 0; i < data.length; i++) {
                    csvCell[j][i] = data[i];
                    System.out.println(data[i]);
                }
                j++;
            }
            return csvCell;
    }
        private JSONArray getAllUsersLocators (String JSON_PATH) throws IOException, ParseException {
                JSONParser jsonParser = new JSONParser();
                FileReader reader = new FileReader(JSON_PATH);
                //Read JSON file
                Object obj = jsonParser.parse(reader);
                JSONArray usersList = (JSONArray) obj;

                return usersList;
        }
    public String getLocatorsFromJsonFile(String keyword,String path) throws IOException, ParseException {
        JSONArray usersList= getAllUsersLocators(path);
        JSONObject jsonObject = (JSONObject) usersList.get(0);
        return (String) jsonObject.get(keyword);

    }

    public Object[][] getExcelData(String filePath) throws IOException
    {
        File srcFile = new File(filePath);
        fis = new FileInputStream(srcFile);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        int TotalNumberOfRows = (sheet.getLastRowNum()+1);
        int TotalNumberOfCols = 2;

        String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ;

        for (int i = 0; i < TotalNumberOfRows; i++)
        {
            for (int j = 0; j < TotalNumberOfCols; j++) {
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }
        System.out.println(arrayExcelData[0][0]);
        wb.close();
        return arrayExcelData;
    }
}
