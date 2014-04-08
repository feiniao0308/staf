package com.bn.automation.scripts;

import com.bn.automation.staf.anno.STAFScript;
import com.bn.automation.staf.anno.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by fdkzv on 4/8/14.
 */
@STAFScript
public class Ribbon {

    @Test
    public void main(){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("xml/co.xml");
        SAXBuilder builder = new SAXBuilder();
        //System.out.println("inputStream = " + inputStream);
        Document doc = null;
        try {
            doc = (Document) builder.build(inputStream);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("doc = " + doc.toString());
        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        String value = outputter.outputString(doc);
        System.out.println("value = " + value);


        try
        {
            FileInputStream file = new FileInputStream(new File("CO.xlsx"));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "t");
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }




        /*HttpClient client = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
        HttpPost post = new HttpPost("http://tqaevfng01.bnqa.bn-dev.com:8080/RibbonService/sendMessage/ATG/atg.customer_order");
        String xml = value;
        HttpEntity entity = null;
        try {
            entity = new ByteArrayEntity(xml.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        post.setEntity(entity);
        HttpResponse response = null;
        try {
            response = client.execute(post);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("result = " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println("completed");

    }
}
