import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 */
public final class HashAndSaltUtils {

	/**
	 * HashAndSaltUtils default constructor.<br>
	 */
	private HashAndSaltUtils() {

	}

	/**
	 * Method to hash with salt a value.<br>
	 * 
	 * @param salt
	 *            key for salt
	 * @param value
	 *            String
	 * 
	 * @return String
	 * 
	 * @throws NoSuchAlgorithmException
	 *             NoSuchAlgorithmException
	 */
	public static String hashMe(String salt, String value)
			throws NoSuchAlgorithmException {

		final String hash = getMD5(value);

		final String sha256 = getSha256(salt + hash);

		return sha256;
	}

	/**
	 * get a hash with algorithm Sha256.<br>
	 * 
	 * @param value
	 *            String
	 * 
	 * @return String
	 * 
	 * @throws NoSuchAlgorithmException
	 *             NoSuchAlgorithmException
	 */
	private static String getSha256(String value)
			throws NoSuchAlgorithmException {
		return hash("SHA-256", value);
	}

	/**
	 * get a hash with algorithm MD5.<br>
	 * 
	 * @param value
	 *            String
	 * 
	 * @return String
	 * 
	 * @throws NoSuchAlgorithmException
	 *             NoSuchAlgorithmException
	 */
	private static String getMD5(String value) throws NoSuchAlgorithmException {
		return hash("MD5", value);
	}

	/**
	 * get a hash with algorithm MD5 or Sha256.<br>
	 * 
	 * @param algorithm
	 *            String
	 * @param value
	 *            String
	 * 
	 * @return String
	 * 
	 * @throws NoSuchAlgorithmException
	 *             NoSuchAlgorithmException
	 */
	private static String hash(String algorithm, String value)
			throws NoSuchAlgorithmException {
		final MessageDigest md = MessageDigest.getInstance(algorithm);
		md.update(value.getBytes());

		final byte[] digest = md.digest();

		return convertByteToHex(digest);
	}

	/**
	 * convert Byte To Hex.<br>
	 * 
	 * @param byteData
	 *            byte[]
	 * 
	 * @return String
	 */
	private static String convertByteToHex(byte[] byteData) {

		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		return sb.toString();
	}

}
