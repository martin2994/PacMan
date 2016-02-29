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
		Modele.totalGumGum=Modele.gumGum = Integer.parseInt(br.readLine().toString());
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
	
	
	/*
	 * Ecrase le fichier et en crée un nouveau
	 * avec le nouveau score à l'intérieur
	 */
	public static void put (String[][] current_score, int count, int score, String name, File current_file) throws IOException{
		FileWriter fw = new FileWriter (current_file);
		BufferedWriter output = new BufferedWriter(fw);
		String newLine = System.getProperty("line.separator");
		for (int i=0 ; i<count ; i++){
			output.write(current_score[i][0]+' '+current_score[i][1]+newLine);
			output.flush();
		}
		output.write(name+' '+score+newLine);
		output.flush();
		for (int i=count ; i<current_score.length-1 ; i++){
			output.write(current_score[i][0]+' '+current_score[i][1]+newLine);
			output.flush();
		}
		output.close();
	}
	
	/*
	 * Extrait les meilleurs scores d'un fichier pour les mettre dans un tableau
	 */
	public static String[][] extract (File f) throws IOException{
		String [][] current_score = new String[10][2];
		FileInputStream ips = new FileInputStream(f);
		InputStreamReader ipsr = new InputStreamReader(ips);
		BufferedReader br = new BufferedReader(ipsr);
		String currentLine;
		for (int i=0 ; i<current_score.length ; i++){
			if((currentLine = br.readLine()) != null){
				StringTokenizer currentChar = new StringTokenizer(currentLine);
				current_score[i][0] = currentChar.nextToken().toString();
				current_score[i][1] = currentChar.nextToken().toString();
			}
			else {
				current_score[i][0] = "AAA";
				current_score[i][1] = "000";
			}
		}
		return current_score;
	}
	
	public static String findFile (String file_name) {
		switch (file_name) {
		case("stage1.txt") :
			return "stage1HS.txt";
		case ("stage2.txt") :
			return "stage2HS.txt";
		case ("stage3.txt") :
			return "stage3HS.txt";
		default : 
			return file_name.substring(5)+"HS.txt";
		}
	}
}