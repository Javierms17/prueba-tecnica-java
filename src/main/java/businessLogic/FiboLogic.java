package businessLogic;

public class FiboLogic {
	public static long resolveFibo(int pos) {
		if (pos <= 1) {
		       return pos;
			}
			
			long prev = 0;
			long current = 1;
			
			for (int i = 2; i <= pos; i++) {
			    long next = prev + current;
			    prev = current;
			    current = next;
			}
			
			return current;
	}
}
