package au.com.studyunsw.cryption.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Encoder to encode sensitive information<br/>
 * 
 * @author range-ubuntu
 * 
 */
public class InfoEncoder {
	private static final String SHA1_ALGORITHM = "sha1";
	private static final String MD5_ALGORITHM = "md5";
	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * SHA1 encode<br/>
	 * 
	 * @param input
	 *            input information
	 * @return SHA1 encoded string
	 */
	public String sha1Encode(String input) {
		String output = null;
		byte[] digested = msgDigest(input, SHA1_ALGORITHM);
		output = getFormattedText(digested);

		return output;
	}

	/**
	 * MD5 encode<br/>
	 * 
	 * @param input
	 *            input information
	 * @return MD5 encoded string
	 */
	public String md5Encode(String input) {
		String output = null;
		byte[] digested = msgDigest(input, MD5_ALGORITHM);
		output = getFormattedText(digested);

		return output;
	}

	/**
	 * Message digest using algorithms provided by Java<br/>
	 * 
	 * @param input
	 *            input string
	 * @param algorithm
	 *            algorithm for digest
	 * @return digested bytes array
	 */
	private byte[] msgDigest(String input, String algorithm) {
		byte[] digested = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(input.getBytes());
			digested = md.digest();
		} catch (NoSuchAlgorithmException e) {
			digested = null;
			e.printStackTrace();
		}
		return digested;
	}

	/**
	 * Convert a byte array to a hex string<br/>
	 * 
	 * @param input
	 *            input bytes
	 * @return encoded hex string
	 */
	private String getFormattedText(byte[] input) {
		StringBuilder builder = null;
		int length = input.length;
		builder = new StringBuilder(length * 2);

		for (int i = 0; i < length; ++i) {
			builder.append(HEX_DIGITS[(input[i] >> 4) & 0x0f]);
			builder.append(HEX_DIGITS[input[i] & 0x0f]);
		}

		return builder.toString();
	}

	public String base64Encode(String input) {
		return null;
	}

}
