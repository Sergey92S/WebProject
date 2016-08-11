/**
 * 
 */
package by.pvt.shmouradko.utils;

import java.util.regex.Pattern;

/**
 * @author Shmouradko Sergey
 *
 */
public class FormDataValidator {

	/**
	 * Только латинские или только русские буквы вплоть до 15-и символов <br/>
	 * Only latin or only russian letters up to 15 symbols
	 */
	public static final Pattern namePattern = Pattern.compile("(\\A[A-Z]?[a-z]{1,15}\\z)|(\\A[А-Я]?[а-я]{1,15}\\z)");

	/**
	 * Только латинские или только русские буквы вплоть до 15-и символов <br/>
	 * Only latin or only russian letters up to 15 symbols
	 */
	public static final Pattern surnamePattern = Pattern.compile("(\\A[A-Z]?[a-z]{1,15}\\z)|(\\A[А-Я]?[а-я]{1,15}\\z)");

	/**
	 * Латинские буквы, цифры, *, ! или ^,<br/>
	 * от 6-и до 15-и символов <br/>
	 * Latin letters, digits, *, ! or ^ at least 6<br/>
	 * symbols up to 15
	 */
	public static final Pattern passwordPattern = Pattern.compile("\\A[a-zA-Z0-9_\\*\\!\\^]{6,15}\\z");

	/**
	 * Пример: vasia.pupkin@gmail.com. <br/>
	 * Examples: vasia.pupkin@gmail.com.
	 */
	public static final Pattern loginPattern = Pattern.compile("\\A[a-z0-9\\.]{3,25}@[a-z\\.]{3,10}\\.{1}[a-z]{2,5}\\z");

	/**
	 * Только 4 цифры. <br/>
	 * Examples: 1111.
	 */
	public static final Pattern securitycodePattern = Pattern.compile("\\A[0-9]{4}\\z");

	/**
	 * Только 5 цифр <br/>
	 * Examples: 10000.
	 */
	public static final Pattern countPattern = Pattern.compile("\\A[0-9]{5}\\z");

	/**
	 * Только латинские или только русские буквы вплоть до 10-и символов <br/>
	 * Only latin or only russian letters up to 10 symbols
	 */
	public static final Pattern creditcardPattern = Pattern
			.compile("(\\A[A-Z]?[a-z]{1,10}\\z)|(\\A[А-Я]?[а-я]{1,10}\\z)");

	/**
	 * Только цифры вплоть до 4-х. <br/>
	 * Examples: 10000.
	 */
	public static final Pattern sumPattern = Pattern.compile("\\A[0-9]{1,4}\\z");
}
