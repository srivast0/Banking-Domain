package netBanking;

import java.util.Random;

public class TransactionIDGenerator {

	public long generateID() { 
	    Random rnd = new Random();
	    char [] digits = new char[8];
	    digits[0] = (char) (rnd.nextInt(7) + '1');
	    for(int i=1; i<digits.length; i++) {
	        digits[i] = (char) (rnd.nextInt(8) + '0');
	    }
	    return Long.parseLong(new String(digits));
	}
}
