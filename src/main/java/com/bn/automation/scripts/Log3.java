package com.bn.automation.scripts;

import com.bn.automation.staf.core.STAFLogger;

/**
 * Created by fdkzv on 3/20/14.
 */
public class Log3 {
    public static void main(String[] args) {
        new STAFLogger().logResult("file.xml", "12", "hello", "world", "pass", "1.0s");
        new STAFLogger().logResult("file.xml", "12", "hello", "world", "pass", "1.0s");
        new STAFLogger().logResult("file.xml", "12", "hello", "world", "pass", "1.0s");
        new STAFLogger().logResult("file.xml", "12", "hello", "world", "pass", "1.0s");
        new STAFLogger().logResult("file.xml", "12", "hello", "world", "pass", "1.0s");
        new STAFLogger().logResult("file.xml", "12", "hello", "world", "pass", "1.0s");
        new STAFLogger().logResult("file.xml", "12", "hello", "world", "pass", "1.0s");
        new STAFLogger().logResult("file.xml", "12", "hello", "world", "pass", "1.0s");







       /* try {

            Element company = new Element("company");
            Document doc = new Document(company);
           // doc.setRootElement(company);

            Element staff = new Element("staff");
            staff.setAttribute(new Attribute("id", "1"));
            staff.addContent(new Element("firstname").setText("yong"));
            staff.addContent(new Element("lastname").setText("mook kim"));
            staff.addContent(new Element("nickname").setText("mkyong"));
            staff.addContent(new Element("salary").setText("199999"));

            doc.getRootElement().addContent(staff);

            Element staff2 = new Element("staff");
            staff2.setAttribute(new Attribute("id", "2"));
            staff2.addContent(new Element("firstname").setText("low"));
            staff2.addContent(new Element("lastname").setText("yin fong"));
            staff2.addContent(new Element("nickname").setText("fong fong"));
            staff2.addContent(new Element("salary").setText("188888"));

            doc.getRootElement().addContent(staff2);

            // new XMLOutputter().output(doc, System.out);
            XMLOutputter xmlOutput = new XMLOutputter();

            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("file.xml"));

            Element staff3 = new Element("staff");
            staff3.setAttribute(new Attribute("id", "2"));
            staff3.addContent(new Element("firstname").setText("low"));
            staff3.addContent(new Element("lastname").setText("yin fong"));
            staff3.addContent(new Element("nickname").setText("fong fong"));
            staff3.addContent(new Element("salary").setText("188888"));

            doc.getRootElement().addContent(staff3);

            XMLOutputter xmlOutput2 = new XMLOutputter();

            // display nice nice
            xmlOutput2.setFormat(Format.getPrettyFormat());
            xmlOutput2.output(doc, new FileWriter("file.xml"));

            System.out.println("File Saved!");
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }*/
    }
}
