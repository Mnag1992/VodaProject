package baseproject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static io.restassured.path.xml.XmlPath.CompatibilityMode.HTML;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParser;

public class TestAPIProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://www.vodafone.co.uk/";
		String response = RestAssured.given().log().all().get("mobile-broadband/pay-monthly-contracts/tablets/apple/ipad-pro-13-7th-gen").
				then().extract().response().asString();
		System.out.println("API response is success");
		System.out.println("API response is :"+response);
		
//		JsonPath jp = new JsonPath(response);
//		String device = jp.getString("_hydratedData.outstandingRequiredRequests");
//		System.out.println("Device name is :"+device);
		
		XmlPath htmlpath = new XmlPath(HTML, response);
		String s = htmlpath.getString("html.head.script[10]");
		System.out.println("Title name is :"+s);
		JSONObject  obj = new JSONObject (s);
		String pageName = obj.getString("name");
		System.out.println("Title name is :"+pageName);

	}

}
