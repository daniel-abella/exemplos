
public class WaitSemLock {
	public static void main(String[] args) {
		try {
			//synchronized (Byte.class) {
				Byte.class.wait(3000);
				System.out.println("Esperei, ninguém me avisou...z");
			//}			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
