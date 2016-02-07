package com.bn.automation.staf.util;

import com.bn.automation.staf.core.STAFRunner;
import com.bn.automation.staf.helpers.STAFConstant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class HTMLGenerator {

	public void convertXML(){
		try {
			String path = System.getProperty("user.dir");
			
	        TransformerFactory tFactory=TransformerFactory.newInstance();

	        //Source xslDoc=data StreamSource(path+"/src/test/resources/stylesheet/StafStylesheet.xsl");
	        //Source xmlDoc=data StreamSource(path+"/target/STAFlog.xml");
	        Source xslDoc=new StreamSource(path+"/src/main/resources/log/DefaultStylesheet2.xsl");
	        //Source xmlDoc=new StreamSource(path+"/target/test.xml");


            Source xmlDoc=new StreamSource(STAFRunner.getInfo().get("xml_log_path").toString());
           // Source xmlDoc=new StreamSource(path+"/testlog.xml");
            File theDir = new File("STAFLog\\HTML");

            // if the directory does not exist, create it
            if (!theDir.exists()) {
                System.out.println("creating directory: " + theDir);
                boolean result = theDir.mkdir();

                if(result) {
                    System.out.println("DIR created");
                }
            }


	        //String outputFileName=path+"/reports/Staflog.html";
           // String outputFileName=STAFRunner.getInfo().get(STAFConstant.USER_DIR)+"\\STAFLog\\HTML\\STAFLog_"+STAFRunner.getInfo().get(STAFConstant.START_TIME)+".html";
            String outputFileName=STAFRunner.getInfo().get("html_log1").toString();


	        OutputStream htmlFile=new FileOutputStream(outputFileName);
	        Transformer trasform=tFactory.newTransformer(xslDoc);
	        trasform.transform(xmlDoc, new StreamResult(htmlFile));
	    }
	    catch (FileNotFoundException e) 
	    {
	        e.printStackTrace();
	    }
	    catch (TransformerConfigurationException e) 
	    {
	        e.printStackTrace();
	    }
	    catch (TransformerFactoryConfigurationError e) 
	    {
	        e.printStackTrace();
	    }
	    catch (TransformerException e) 
	    {
	        e.printStackTrace();
	    }
	}

}
