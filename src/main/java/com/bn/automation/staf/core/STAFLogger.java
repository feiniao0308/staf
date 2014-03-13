package com.bn.automation.staf.core;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class STAFLogger {
	String path = System.getProperty("user.dir");

	
	
	public void closeStafLog(){
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(path + "/target/test.xml", true)));
			out.println("</Events>");
			out.flush();
			out.close();
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void convertXMLToHTML(){
		try {
			
	        TransformerFactory tFactory=TransformerFactory.newInstance();

	        //Source xslDoc=data StreamSource(path+"/src/test/resources/stylesheet/StafStylesheet.xsl");
	        //Source xmlDoc=data StreamSource(path+"/target/STAFlog.xml");
	        Source xslDoc=new StreamSource(path+"/src/test/resources/stylesheet/DefaultStylesheet2.xsl");
	        Source xmlDoc=new StreamSource(path+"/target/test.xml");
	      

	        String outputFileName=path+"/reports/Staflog.html";

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
	
	public void openStafReport() throws IOException{
		File htmlFile = new File(path+"/reports/Staflog.html");
		Desktop.getDesktop().browse(htmlFile.toURI());
	}

}
