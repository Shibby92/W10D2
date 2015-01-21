import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

import javax.swing.JFileChooser;
/**
 * Vjezbanje Stream-a i file-ova sa dodatnim filechooser-om
 * @author harisarifovic
 *
 */
public class StreamReadWrite2 {
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
		//Kreiranje filechoosera  za otvaranje i spasavanje
		JFileChooser filePicker = new JFileChooser();
		//Koristenje separator metode da bi radio neovisno od OS-a
		filePicker.setCurrentDirectory(new File(System.getProperty("user.home")
				+ File.separator + "Documents" + File.separator + "workspace"));
		int open = filePicker.showOpenDialog(filePicker);
		//Sprijecava zatvaranje prozora sve dok ne otvori file koji zeli
		while (open != filePicker.APPROVE_OPTION) {
			open = filePicker.showOpenDialog(filePicker);
		}
		byte[] inputBuffer = new byte[10];
		OutputStream os;
		StringBuilder sb = new StringBuilder();
		String pickedFile = filePicker.getSelectedFile().getAbsolutePath();
		open = -1;
		//Trazi path za file u koji se treba sacuvati, sve dok ga ne nadje
		while (open != filePicker.APPROVE_OPTION) {
			open = filePicker.showSaveDialog(filePicker);
		}
		String pickedFile2 = filePicker.getSelectedFile().getAbsolutePath();
		FileInputStream fs = null;
		Reader is;
		FileOutputStream ofs;
		try {
			fs = new FileInputStream(pickedFile);
			is = new InputStreamReader(fs);
			BufferedReader bs = new BufferedReader(is);
			ofs = new FileOutputStream(pickedFile2, true);
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
