
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
			
			// 여기는 읽어들일 xml파일 위치, 실제 파일 위치로 변경
			String filePath ="D:/WorkSpace/JAVASPACE/DomparsingTest/pubmed_sample1.xml";
			
			File fXmlFile = new File(filePath);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			// 아래줄은 <PMID>로 시작 되는 태그 정보를 가져오는 함수, PMID하위에 있는 노드들은 모두 NodeList에 저장
			NodeList nList = doc.getElementsByTagName("PMID");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				 
				Node nNode = nList.item(temp);
		 
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				//PMID의 값을 출력
				System.out.println("Value: "+nNode.getTextContent());
				
			}
			
//			    <PubDate>
//            		<Year>2010</Year>   이부분 코드를 읽어오는 부분
//            	</PubDate>
			NodeList pubdataList = doc.getElementsByTagName("PubDate");
			
			for (int temp = 0; temp < pubdataList.getLength(); temp++) {
				 
				Node nNode = pubdataList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					 
					Element eElement = (Element) nNode;
					// getTextContent() 이름이 Year인 태그, <Year>2010</Year> 값을 가져옴, 즉 2010
//					혹시 속성 값을 가져오고 싶으면 getAttribute()함수를 쓰면 됨.
					System.out.println("Pub date Years : " + eElement.getElementsByTagName("Year").item(0).getTextContent());
				}
				
				
			}
			
			//<Abstract> </Abstract>사이것을 가져오는 부분
			NodeList abstractList = doc.getElementsByTagName("Abstract");
			for(int i=0; i<abstractList.getLength(); i++){
				Node nNode = abstractList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					 
					Element eElement = (Element) nNode;
					//<AbstractText>내용을 가져오는 부분
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
