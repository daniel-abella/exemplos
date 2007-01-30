
public class NotifySemLock {
	public static void main(String[] args) {
		synchronized (Byte.class) {
			// No problem. If it enters here the thread
			// holds the lock of object Byte.class.
			// You will have problems with any other object!
			Byte.class.notify();
		}		
		
		// PROBLEM (IllegalMonitorStateException)
		// This thread does not holde the lock
		Byte.class.notify();
	}
}
