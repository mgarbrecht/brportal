package util.password;
 
import java.util.regex.*;
public class PasswordCheck {

	private static String PASSWORD_MIXED_CASE;
	private static String PASSWORD_MIN_LENGTH;
	private static String PASSWORD_MAX_LENGTH;
	private static String PASSWORD_NUMERIC;
	private static String PASSWORD_SPECIAL;
	private static String PASSWORD_STRENGTH;
	
	public PasswordCheck () {
		super();
		PASSWORD_MIXED_CASE = "1";
		PASSWORD_MIN_LENGTH = "8";
		PASSWORD_MAX_LENGTH = "30";
		PASSWORD_NUMERIC = "1";
		PASSWORD_SPECIAL = "1";
		PASSWORD_STRENGTH = "30";
	}
	
	public static boolean CheckPasswordStrength(String passwd) {
		int upper = 0, lower = 0, numbers = 0, special = 0, length = 0;
		int intScore = 0;
		String strVerdict = "none";
		Pattern p;
		Matcher m;
		if (passwd == null)
			return false;
		length = passwd.length();
		if (length < 5)  
			{
			intScore = (intScore + 3);
		} else if (length > 4 && passwd.length() < 8) // length between 5 and 7
			{
			intScore = (intScore + 6);
		} else if (
			length > 7 && passwd.length() < 16) // length between 8 and 15
			{
			intScore = (intScore + 12);
		} else if (length > 15) // length 16 or more
			{
			intScore = (intScore + 18);
		}
		// LETTERS 
		p = Pattern.compile(".??[a-z]");
		m = p.matcher(passwd);
		while (m.find()) // [verified] at least one lower case letter
			{
			lower += 1;
		}
		if (lower > 0) {
			intScore = (intScore + 1);
		}
		p = Pattern.compile(".??[A-Z]");
		m = p.matcher(passwd);
		while (m.find()) // [verified] at least one upper case letter
			{
			upper += 1;
		}
		if (upper > 0) {
			intScore = (intScore + 5);
		}
		// NUMBERS
		p = Pattern.compile(".??[0-9]");
		m = p.matcher(passwd);
		while (m.find()) // [verified] at least one number
			{
			numbers += 1;
		}
		if (numbers > 0) {
			intScore = (intScore + 5);
			if (numbers > 1) {
				intScore = (intScore + 2);
				if (numbers > 2) {
					intScore = (intScore + 3);
				}
			}
		}
		// SPECIAL CHAR
		p = Pattern.compile(".??[:,!,@,#,$,%,^,&,*,?,_,~]");
		m = p.matcher(passwd);
		while (m.find()) // [verified] at least one special character
			{
			special += 1;
		}
		if (special > 0) {
			intScore = (intScore + 5);
			if (special > 1) {
				intScore += (intScore + 5);
			}
		}
		// COMBOS
		if (upper > 0 && lower > 0) // [verified] both upper and lower case
			{
			intScore = (intScore + 2);
		}
		if ((upper > 0 || lower > 0)
			&& numbers > 0) // [verified] both letters and numbers
			{
			intScore = (intScore + 2);
		}
		if ((upper > 0 || lower > 0)
			&& numbers > 0
			&& special > 0) // [verified] letters, numbers, and special characters
			{
			intScore = (intScore + 2);
		}
		if (upper > 0 && lower > 0 && numbers > 0 && special > 0)			// [verified] upper, lower, numbers, and special characters
			{
			intScore = (intScore + 2);
		}
		if (intScore < 16) {
			strVerdict = "muito fraca";
		} else if (intScore > 15 && intScore < 25) {
			strVerdict = "fraca";
		} else if (intScore > 24 && intScore < 35) {
			strVerdict = "média";
		} else if (intScore > 34 && intScore < 45) {
			strVerdict = "forte";
		} else {
			strVerdict = "muito forte";
		}
		System.out.println(strVerdict);
		// Does it meet the password policy?
		try {
			int min = Integer.parseInt(PASSWORD_MIN_LENGTH);
			if (length < min)
				return false;
		} catch (Exception e) {
			;
		} // undefined
		try {
			int max = Integer.parseInt(PASSWORD_MAX_LENGTH);
			if (length > max)
				return false;
		} catch (Exception e) {
			;
		} // undefined
		try {
			int num = Integer.parseInt(PASSWORD_NUMERIC);
			if (numbers < num)
				return false;
		} catch (Exception e) {
			;
		} // undefined
		try {
			int mix = Integer.parseInt(PASSWORD_MIXED_CASE);
			if (upper < mix || lower < mix)
				return false;
		} catch (Exception e) {
			;
		} // undefined
		try {
			int str = Integer.parseInt(PASSWORD_STRENGTH);
			if (intScore < str)
				return false;
		} catch (Exception e) {
			;
		} // undefined
		try {
			int spec = Integer.parseInt(PASSWORD_SPECIAL);
			if (special < spec)
				return false;
		} catch (Exception e) {
			;
		} // undefined
		return true;
	}

	public static void main(String[] args) {

		String teste="Testess1";
		CheckPasswordStrength(teste);
	}
}
