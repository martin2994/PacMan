import java.io.*;
import java.util.StringTokenizer;

public class IOTreatment {
	
	public static int[][] readMatrix(int [][]tab) throws IOException {
			File f = new File("matrix.txt");
			FileInputStream ips = new FileInputStream(f);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String currentLine;
			int width = Integer.parseInt(br.readLine().toString());
			int height = Integer.parseInt(br.readLine().toString());
			int gum = Integer.parseInt(br.readLine().toString());
			//int tab[][] = new int[height][width];
			int count=0;
			while ((currentLine=br.readLine())!=null){
				StringTokenizer currentChar = new StringTokenizer(currentLine);
				for (int i=0 ; currentChar.hasMoreTokens() ; i++){
					tab[i][count]=Integer.parseInt(currentChar.nextToken().toString());
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
			return tab;
	}

	public static int getWidth() throws IOException {
		File f = new File("matrix.txt");
		FileInputStream ips = new FileInputStream(f);
		InputStreamReader ipsr = new InputStreamReader(ips);
		BufferedReader br = new BufferedReader(ipsr);
		return Integer.parseInt(br.readLine().toString());
	}

	public static int getHeigth() throws IOException {
		File f = new File("matrix.txt");
		FileInputStream ips = new FileInputStream(f);
		InputStreamReader ipsr = new InputStreamReader(ips);
		BufferedReader br = new BufferedReader(ipsr);
		int width=Integer.parseInt(br.readLine().toString());
		return Integer.parseInt(br.readLine().toString()) ;
	}

	public static int getGum() throws IOException {
		File f = new File("matrix.txt");
		FileInputStream ips = new FileInputStream(f);
		InputStreamReader ipsr = new InputStreamReader(ips);
		BufferedReader br = new BufferedReader(ipsr);
		int width=Integer.parseInt(br.readLine().toString());
		int height=Integer.parseInt(br.readLine().toString());
		return Integer.parseInt(br.readLine().toString());
	}

}
