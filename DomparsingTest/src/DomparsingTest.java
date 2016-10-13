
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class DomparsingTest {
	
	public static void main(String[] args) {
		try {
			
			// ����� �о���� xml���� ��ġ, ���� ���� ��ġ�� ����
			String filePath ="D:/WorkSpace/JAVASPACE/DomparsingTest/pubmed_sample1.xml";
			
			File fXmlFile = new File(filePath);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			// �Ʒ����� <PMID>�� ���� �Ǵ� �±� ������ �������� �Լ�, PMID������ �ִ� ������ ��� NodeList�� ����
			NodeList nList = doc.getElementsByTagName("PMID");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				 
				Node nNode = nList.item(temp);
		 
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				//PMID�� ���� ���
				System.out.println("Value: "+nNode.getTextContent());
				
			}
			
//			    <PubDate>
//            		<Year>2010</Year>   �̺κ� �ڵ带 �о���� �κ�
//            	</PubDate>
			NodeList pubdataList = doc.getElementsByTagName("PubDate");
			
			for (int temp = 0; temp < pubdataList.getLength(); temp++) {
				 
				Node nNode = pubdataList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					 
					Element eElement = (Element) nNode;
					// getTextContent() �̸��� Year�� �±�, <Year>2010</Year> ���� ������, �� 2010
//					Ȥ�� �Ӽ� ���� �������� ������ getAttribute()�Լ��� ���� ��.
					System.out.println("Pub date Years : " + eElement.getElementsByTagName("Year").item(0).getTextContent());
				}
				
				
			}
			
			//<Abstract> </Abstract>���̰��� �������� �κ�
			NodeList abstractList = doc.getElementsByTagName("Abstract");
			for(int i=0; i<abstractList.getLength(); i++){
				Node nNode = abstractList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					 
					Element eElement = (Element) nNode;
					//<AbstractText>������ �������� �κ�
					System.out.println("AbstractText : " + eElement.getElementsByTagName("AbstractText").item(0).getTextContent());
					
				}
			}
			
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
