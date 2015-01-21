import java.io.*;

/**
 * Vjezbanje Stream-a i file-ova
 * 
 * @author harisarifovic
 *
 */
public class StreamReadWrite {
	/**
	 * Cisti buffer do tacke mijenjanja, da ne bi cistio prostor koji uopste
	 * nije iskoristen za unos
	 * 
	 * @param buffer
	 *            Niz byte-ova
	 * @param numRead
	 *            Broj promjena u buffer-u
	 */
	private static void cleanBuffer(byte[] buffer, int numRead) {
		for (int i = 0; i < numRead; i++) {
			buffer[i] = 0;
		}
	}

	public static void main(String[] args) {

		byte[] inputBuffer = new byte[10];
		OutputStream os;
		StringBuilder sb = new StringBuilder();
		FileInputStream fs = null;
		Reader is;
		FileOutputStream ofs;
		try {
			// upisivanje u isti file
			fs = new FileInputStream("./File/nesto.txt");
			is = new InputStreamReader(fs);
			BufferedReader bs = new BufferedReader(is);
			ofs = new FileOutputStream("./File/nesto.txt", true);
			os = new DataOutputStream(ofs);
			int numRead = 0;
			String lineString = "";
			while ((lineString = bs.readLine()) != null) {
				sb.append(lineString).append("\n");
			}
			System.out.println("Citanje zavrseno!");
			String outputString = sb.toString();
			os.write(outputString.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Gotovo");
		}
	}

}
