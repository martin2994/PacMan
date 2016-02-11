package Modele;
import java.io.*;
import java.util.StringTokenizer;

public class IOTreatment {

	/*
	 * Lis un fichier texte entr� en param�tre pour en extraire la hauteur et la
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
	 * Enregistre les meilleurs scores dans un fichier
	 */
	public static void saveHighScore(int score, String file_name) throws IOException {
		System.out.println("saveHighScore");
		String name = "BOWSER";
		String [][] current_score = new String[10][2];
		File current_file = new File("HighScore.txt");
		current_score=extract(current_file);
		if (Integer.parseInt(current_score[9][1]) < score){
			int count=0;
			while(Integer.parseInt(current_score[count][1]) > score){
				count++;
			}
			put(current_score, count, score, name, current_file);
		}
	}
	
	
	/*
	 * Ecrase le fichier et en cr�e un nouveau
	 * avec le nouveau score � l'int�rieur
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
}