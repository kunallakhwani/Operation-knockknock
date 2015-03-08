package cse591.web.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class KnockSequence {

	public static String sequence = "";
	static int count = 0;
	public static String knock = "";
	public static int secret = 0;
	public static int flag=0;
	
	public void hashAndModulo(String username) {
		// TODO Auto-generated method stub

		String s = md5OfUserName(username);
		if (s.length() < 32) {
			int temp = 32 - (s.length());
			for (int i = 1; i <= temp; i++) {
				s = "0" + s;
			}

		}
		int[] outputDecimal = new int[10];

		System.out.println("success: " + s);
		if(sequence.length()==4){
			sequence="";
		}
		for (int i = 0; i < 4; i++) {
			System.out.println("substring: " + s.substring(i, i + 1));
			outputDecimal[i] = Integer.parseInt(s.substring(i, i + 1), 16);
			System.out.println("Decimal: " + outputDecimal[i]);
			sequence = sequence + Integer.toString(outputDecimal[i] % 4);
			System.out.println("Sequence" + sequence);
		}
		

	}

	public String md5OfUserName(String username) {
		// TODO Auto-generated method stubreturn null;
		MessageDigest md5 = null;

		try {
			md5 = MessageDigest.getInstance("MD5");
			// md5.update(username.getBytes(), 0, username.length());
			md5.update(username.getBytes());

			System.out.println("MD5: " + md5);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new BigInteger(1, md5.digest()).toString(16);
	}

	public void sequenceCheck(String knockCode) {

		knock = knock + knockCode;
		System.out.println("knock: " + knock);
		if (!sequence.equals("")) {
			if (knock.contains(sequence)) {
				System.out.println("Secret mode enabled!");
				secret = 1;
			}
		}

		/*
		 * for (int i = 0; i<=count; i++) { if (knock[i] == sequence[i]) {
		 * System.out.println("knock: " + knock[i] + " Sequence: " +
		 * sequence[i]); if(i==3){ secret=1;
		 * System.out.println("Secret mode enabled! " +secret); } } else {
		 * count=-1; System.out.println("Count: " + count); break; } } count++;
		 */

	}
}
