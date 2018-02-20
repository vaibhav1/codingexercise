/**
 * 
 */
package com.vaibhav1.codingexercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vaibhav
 *
 */
public class DataValidation {

	public static String validate(String input) {
		input = input.replaceAll("~\\|", "|").replaceAll("~~", "~");
		String output = "";
		int noOfRecords = 0;
		int noOfFields = 0;
		int noOfEmptyValues = 0;
		String lastField = "format_error";

		String[] lines = input.split("~n");
		noOfRecords = lines.length - 1;

		String fieldNames = lines[0];
		String[] fields = fieldNames.split("\\|");

		int maxLength = Integer.MIN_VALUE;
		List<String> uniqueNames = new ArrayList<String>();
		for (int i = 1; i < lines.length; i++) {

			String[] values = lines[i].split("\\|");
			if (values.length > maxLength) {
				maxLength = values.length;
			}

			if (values.length <= 1 || (values.length >= 2 && values[1].isEmpty())) {
				return "0:0:0:format_error";
			}

			uniqueNames.add(values[1]);

		}

		noOfFields = maxLength - 1;

		for (int j = 1; j < lines.length; j++) {
			String[] values = lines[j].split("\\|");
			int emptyFields = noOfFields - values.length + 1;
			noOfEmptyValues += emptyFields;
		}

		boolean isUniqueName = findUnique(uniqueNames);
		if (!isUniqueName) {
			return "0:0:0:format_error";
		}

		String lastFieldName = fields[fields.length - 1];
		int _num = maxLength - fields.length;
		if (_num > 0) {
			lastField = lastFieldName + "_" + _num;
		} else {
			lastField = lastFieldName;
		}

		output = noOfRecords + ":" + noOfFields + ":" + noOfEmptyValues + ":" + lastField;
		return output;
	}

	/**
	 * Finds if all names in specified list are unique
	 * 
	 * @param uniqueNames
	 * @return
	 */
	private static boolean findUnique(List<String> uniqueNames) {
		for (int i = 0; i < uniqueNames.size(); i++) {
			int j = i + 1;
			if (j < uniqueNames.size() && uniqueNames.get(i).equalsIgnoreCase(uniqueNames.get(j))) {
				return false;
			}
		}
		return true;
	}

	public static void validateData(String str) {
		if (str.contains("~~~"))
			System.out.println("0:0:0:format_error");
		str = str.replaceAll("~\\|", "|");
		str = str.replaceAll("~~", "~");

		String[] s = str.split("~n");
		int output1 = 0;
		if (str.charAt(str.length() - 2) == '~' && str.charAt(str.length() - 1) == 'n')
			output1 = s.length - 1;
		else
			output1 = s.length;

		int output2 = 0, count1 = 0;
		for (int i = 0; i < s[1].length(); i++)
			if (s[1].charAt(i) == '|')
				count1++;
		output2 = count1 - 1;

		int flag = 0;
		int output3 = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == '~' && str.charAt(i + 1) == 'n') {
				flag = 1;
				continue;
			}
			if (flag == 1) {
				if (str.charAt(i) == '|' && str.charAt(i + 1) == '|')
					output3++;
			}
		}

		int output4 = 0, flag1 = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == '~' && str.charAt(i + 1) == 'n') {
				flag1 = 1;
				continue;
			}
			if (flag1 == 0) {
				if (str.charAt(i) == '|')
					output4++;
			}
		}
		String output5 = str.substring(s[0].lastIndexOf('|', s[0].lastIndexOf('|') - 1) + 1, s[0].lastIndexOf('|'))
				+ "_" + (output2 - (output4 - 1));
		System.out.println(output1 + ":" + output2 + ":" + output3 + ":" + output5);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "|name|address|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie|annie@test.com|~n|Zoe|~n";

//		System.out.println(validate(input));
		validateData(input);

	}

}
