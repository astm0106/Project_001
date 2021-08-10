package a001;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestApp001 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String jsonText = "{\"user_name\":\"zzz\",\"array\":[3,2,5,4,1]}";
		  //String jsonText = "[{\"key0\" : \"value0\"},{\"key1\" : \"value1\"}]";

		// . JSON オブジェクトに変換
					JSONParser parser = new JSONParser();
					JSONObject jsonObj;
					try {
						jsonObj = (JSONObject) parser.parse(jsonText);

						// . JSON オブジェクトから特性の属性を取り出す
						String use_name = (String) jsonObj.get("user_name");

						// 配列の取得
						if (jsonObj.get("array") != null) {
						    int[] array = (int[])jsonObj.get("array");
							for (int i = 0; i < array.length; i++) {
								// 配列の表示
								System.out.println(array[i]);

							}
						}
					} catch (ParseException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}








	}

}
