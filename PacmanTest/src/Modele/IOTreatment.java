package Modele;
import java.io.*;
import java.util.StringTokenizer;

public class IOTreatment {

	/*
	 * Lis un fichier texte entré en paramètre pour en extraire la hauteur et la
	 * largeur de la matrice, le nombre de gommes et le remplissage du
	 * labyrinthe
	 */
	public static void readMatrix(String file_name) throws IOException {
		File f = new File(file_name);
		FileInputStream ips = new FileInputStream(f);
		InputStreamReader ipsr = new InputStreamReader(ips);
		BufferedReader br = new BufferedReader(ipsr);
		String currentLine;
		int width = Integer.parseInt(br.readLine().toString());
		int height = Integer.parseInt(br.readLine().toString());
		Modele.labyrinth = new int[width][height];
		Modele.gumGum = Integer.parseInt(br.readLine().toString());
		int count = 0;
		while ((currentLine = br.readLine()) != null) {
			StringTokenizer currentChar = new StringTokenizer(currentLine);
			for (int i = 0; currentChar.hasMoreTokens(); i++) {
				Modele.labyrinth[i][count] = Integer.parseInt(currentChar.nextToken().toString());
			}
			count++;
		}
		br.close();
	}
}