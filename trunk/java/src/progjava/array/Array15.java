package progjava.array;

public class Array15 {
	public static void main(String[] args) {
		Thread[] threads = new Thread[2];
		Long[] longs = { Long.valueOf(1), Long.valueOf("2") };
		
		for (Long l : new Long[]{ Long.valueOf(1), Long.valueOf("2") })
			System.out.println(l);
		
		for (Thread thr : threads)
			System.out.println(thr);
	}
}
