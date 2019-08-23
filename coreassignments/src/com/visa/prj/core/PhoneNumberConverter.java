package com.visa.prj.core;

/**
 * 
 * Alpha Phrase to Phone Number Converter
 * 
 * @author banu
 * 
 */
public class PhoneNumberConverter {

	/**
	 * Converts the given alpha phrase to the corresponding phone number.
	 * 
	 * @param input
	 *            Input will be an alpha phrase which represents a phone number.
	 *            The input may contain the spaces and the hyphen (-).
	 * @return Output is the phone number and it retains any space and hyphen
	 *         symbol from the input.
	 */
	public String convertPhoneNumber(String input) {
		StringBuilder builder = new StringBuilder();
		input.toUpperCase();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if((c >= 'A' && c<= 'Z')) {
				if (c=='A' || c=='B' || c== 'C')
		             builder.append('2');
				else if (c=='D' || c=='E' || c== 'F')
		             builder.append('3');
				else if (c=='G' || c=='H' || c== 'I')
		             builder.append('4');
				else if (c=='J' || c=='K' || c== 'L')
		             builder.append('5');
				else if (c=='M' || c=='N' || c== 'O')
		             builder.append('6');
				else if (c=='P' || c=='Q' || c== 'R' || c== 'S')
		             builder.append('7');
				else if (c=='T' || c=='U' || c== 'V')
		             builder.append('8');
				else if (c=='W' || c=='X' || c== 'Y' || c== 'Z')
		             builder.append('9');
			}
			else {
				builder.append(c);
			}
		}
		return builder.toString();
	}
}
