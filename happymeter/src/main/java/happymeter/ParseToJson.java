package happymeter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

/* 
 * ALLOWS TO SAVE HAPINESS DATA TO JSON
 */

public class ParseToJson {

	// SPECIFY FILE
	static File json = new File("P:\\happinessJson.txt");

	public static void printToJson() throws IOException {

		JSONObject obj = new JSONObject();
		obj.put("Datestamp:", Main.date.toString());
		obj.put("Rate:", Main.newRate);
		obj.put("Comment:", Main.newComment);

		/*
		 * JSONArray exampletree = new JSONArray();
		 * exampletree.add("tree: branch1"); exampletree.add("tree: branch2");
		 * exampletree.add("tree: branch3"); obj.put("tree list", exampletree);
		 */

		try (FileWriter file = new FileWriter(json)) {
			file.write(obj.toJSONString());
			System.out.println("Works great! \n\n" + obj);
		}
	}

}
