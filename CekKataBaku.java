import java.io.*;

public class CekKataBaku {

	private CekKataBaku(String id) {
		StringBuilder bangun = new StringBuilder();
		BufferedReader baca = null;
		String baris = null;
		String [] hasil = {"Hallo", "Hi", "Hy"};;

		try {
			baca = new BufferedReader(new FileReader(id));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {

			while (true) {
				baris = baca.readLine();
				if (baris == null)
					break;
				if (baris.startsWith("#:"))
					bangun = new StringBuilder();
					bangun.append(baris+"\n");
				if (baris.startsWith("msgstr") && baris.matches(".*\\b("+hasil[0].toString()+")\\b.*") )
					System.out.println(">> Salah! Seharusnya Dalam Bahasa Baku Indonesia adalah Halo <<\n"+bangun.toString());
				if (baris.startsWith("msgstr") && baris.matches(".*\\b("+hasil[1].toString()+")\\b.*") )
					System.out.println(">> Salah! Seharusnya Dalam Bahasa Baku Indonesia adalah Hai <<\n"+bangun.toString());
				if (baris.startsWith("msgstr") && baris.matches(".*\\b("+hasil[2].toString()+")\\b.*") )
					System.out.println(">> Salah! Seharusnya Dalam Bahasa Baku Indonesia adalah Hai <<\n"+bangun.toString());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			baca.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {

		new CekKataBaku(args[0]);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("File tidak ditemukan.\n");
		}
}
}