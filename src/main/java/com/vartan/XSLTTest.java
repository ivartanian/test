package com.vartan;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBResult;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.ObjectOutputStream;

/**
 * Created by super on 11/12/16.
 */
public class XSLTTest {

    public static void main(String[] args) throws TransformerException, JAXBException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        StreamSource transform = new StreamSource(XSLTTest.class.getResourceAsStream("/transform.xsl"));
        Transformer transformer = transformerFactory.newTransformer(transform);

        StreamSource xmlSource = new StreamSource(XSLTTest.class.getResourceAsStream("/data.xml"));
//        Result outputTarget = new StreamResult(new File("/tmp/xslt/test.html"));
        JAXBContext jaxbContext = JAXBContext.newInstance(Language.class);
        JAXBResult outputTarget = new JAXBResult(jaxbContext.createUnmarshaller());

        transformer.transform(xmlSource, outputTarget);

        Object result = outputTarget.getResult();
    }

}
