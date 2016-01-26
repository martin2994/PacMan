import java.io.*;
import java.util.StringTokenizer;

public class IOTreatment {
	
	public static void readMatrix(String file_name) throws IOException {
			File f = new File(file_name);
			FileInputStream ips = new FileInputStream(f);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String currentLine;
			int width = Integer.parseInt(br.readLine().toString());
			int height = Integer.parseInt(br.readLine().toString());
			Modele.labyrinth=new int[width][height];
			Modele.gumGum = Integer.parseInt(br.readLine().toString());
			//int tab[][] = new int[height][width];
			int count=0;
			while ((currentLine=br.readLine())!=null){
				StringTokenizer currentChar = new StringTokenizer(currentLine);
				for (int i=0 ; currentChar.hasMoreTokens() ; i++){
					Modele.labyrinth[i][count]=Integer.parseInt(currentChar.nextToken().toString());
				}
				count++;
			}
			/*for (int i=0 ; i<height ; i++){
				for (int j=0 ; j<width ; j++){
					System.out.print(tab[i][j]+" ");
				}
				System.out.println();
			}*/
			br.close();
	}
}