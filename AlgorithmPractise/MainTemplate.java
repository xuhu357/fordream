import java.util.Scanner;


public class MainTemplate {
	int ROW;
	int COL;
	
	char valueChar[][];
	int valueInt[][];
	String valueStr[][];
	
	public MainTemplate(int row, int col) {
		this.ROW = row;
		this.COL = col;
		
		valueChar = new char[row][col];
		valueInt = new int[row][col];
		valueStr = new String[row][col];
	}
	
	public void inputDataStr(){
		Scanner sc = new Scanner(System.in);
		ROW = sc.nextInt();
		COL = sc.nextInt();
		
		for(int row=0; row<ROW; row++){
			valueStr[row] = sc.next().split(" ");
		}
		
		sc.close();
	}
	
	public void inputDataChar(){
		Scanner sc = new Scanner(System.in);
		ROW = sc.nextInt();
		COL = sc.nextInt();
		
		for(int row=0; row<ROW; row++){
			valueChar[row] = sc.next().toCharArray();
		}
		
		sc.close();
	}
	
	public void inputDataInt(){
		Scanner sc = new Scanner(System.in);
		ROW = sc.nextInt();
		COL = sc.nextInt();
		
		for(int row=0; row<ROW; row++){
			for(int col=0; col<COL; col++){
				valueInt[row][col] = sc.nextInt();
			}
			
		}
		
		sc.close();
	}
	
	public void printData(){
		for(int row =0; row<ROW; row++){
			for(int col =0; col<COL; col++){
				System.out.print(valueChar[row][col]+" ");
			}
			System.out.println();
		}
	}
	
	

}
