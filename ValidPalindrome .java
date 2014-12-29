public class ValidPalindrome  {
	public boolean isPalindrome(String s) {
		s=s.toUpperCase();
		int len = s.length();
		if (len == 0)
			return true;
		int l, h;
		l = 0;
		h = len - 1;
		char low;
		char high;
		J: do {
			do {
				low = s.charAt(l++);
				if (l >= len)
					break J;
			} while (low<48||low>57&&low < 65 || low > 90 );
			do {
				high = s.charAt(h--);
				if (h < 0)
					break J;
			} while (high<48||high>57&&high < 65 || high > 90);
			if (low != high)
				return false;
		} while (l <= h);
		return true;
	}
}