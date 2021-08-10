package a001;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonToValue {

	public static String getValue(String key,String jsonText) {
		// TODO 自動生成されたメソッド・スタブ
		//String jsonText = "{\"user_name\":\"zz\",\"array\":\"2-2\"}";
		String jsonKey = key;

		String result = null;
		int[] number = null;
//		System.out.println(jsonText);

		String regex_n01 = jsonKey + "\":.+?" + "(,|})";
		String regex_n02 = ":\".+\"";

		// String regex = "\"array\":.+?}" ;
		Pattern p_n01 = Pattern.compile(regex_n01);
		Pattern p_n02 = Pattern.compile(regex_n02);

		Matcher m_n01 = p_n01.matcher(jsonText);
		if (m_n01.find()) {

			String text_n01 = m_n01.group(0);
			System.out.println(text_n01);

			Matcher m_n02 = p_n02.matcher(text_n01);
			if (m_n02.find()) {
				String text_n02 = m_n02.group(0);
				System.out.println(text_n02);
				result = text_n02.substring(2,text_n02.length() -1);
				System.out.println(result);


			}

		}
		return result;
	}

}
