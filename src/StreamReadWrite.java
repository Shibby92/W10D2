import java.io.*;

public class StreamReadWrite {
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
			fs = new FileInputStream("./File/nesto.txt");
			is = new InputStreamReader(fs);
			BufferedReader bs= new BufferedReader(is);
			ofs= new FileOutputStream("./File/nesto.txt",true);
			os = new DataOutputStream(ofs);
			int numRead = 0;
			String lineString="";
			while((lineString=bs.readLine())!= null){
				sb.append(lineString).append("\n");
		}
//				os.write(lineString.getBytes());
//				os.write("\n".getBytes());
			
//			while ((numRead = is.read(inputBuffer)) >= 0) {
//				sb.append(new String(inputBuffer));
//				cleanBuffer(inputBuffer, numRead);
//			}
			System.out.println("Citanje zavrseno!");
			String outputString = sb.toString();
			os.write(outputString.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Gotovo");
		}
	}

}
