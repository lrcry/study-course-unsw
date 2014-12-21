package au.com.studyunsw.cryption.utils.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import au.com.studyunsw.cryption.utils.InfoEncoder;

public class TestInfoEncoder {
	private static final String PWD = "8df92dfs92fjg9210gh";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testSha1Encode() {
		String encoded = new InfoEncoder().sha1Encode(PWD);
		assert encoded != null;
		
		System.out.println(encoded);
		System.out.println("length = " + encoded.length());
	}

	@Test
	public void testMd5Encode() {
		String encoded = new InfoEncoder().md5Encode(PWD);
		assert encoded != null;
		
		System.out.println(encoded);
		System.out.println("length = " + encoded.length());
	}

}
