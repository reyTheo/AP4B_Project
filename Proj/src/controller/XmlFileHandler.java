package controller;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlFileHandler {
    private Document doc;

    public void loadXmlFile(String filePath) throws Exception {
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            throw new Exception("Failed to load XML file: " + e.getMessage(), e);
        }
    }

    public void saveXmlFile(String filePath) throws Exception {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
        } catch (Exception e) {
            throw new Exception("Failed to save XML file: " + e.getMessage(), e);
        }
    }

    public void addPoint(String num, String x, String y) throws Exception {
        try {
            Element newPoint = doc.createElement("point");
            newPoint.setAttribute("num", num);
            newPoint.setAttribute("x", x);
            newPoint.setAttribute("y", y);

            NodeList pointsNodeList = doc.getElementsByTagName("points");
            Node pointsNode = pointsNodeList.item(0);
            pointsNode.appendChild(newPoint);
        } catch (Exception e) {
            throw new Exception("Failed to add point: " + e.getMessage(), e);
        }
    }

    // Function used to find the num maximum in the XML file to use it in the addPoint function and update the num when adding a point on the map 
    public String findMaxNum() throws Exception {
        try {
            NodeList pointList = doc.getElementsByTagName("point");
            int maxNum = Integer.MIN_VALUE;

            for (int i = 0; i < pointList.getLength(); i++) {
                Element pointElement = (Element) pointList.item(i);
                String numStr = pointElement.getAttribute("num");
                int num = Integer.parseInt(numStr);

                if (num > maxNum) {
                    maxNum = num;
                }
            }
            return String.valueOf(maxNum);
        } catch (Exception e) {
            throw new Exception("Failed to find maximum num: " + e.getMessage(), e);
        }
    }
}

