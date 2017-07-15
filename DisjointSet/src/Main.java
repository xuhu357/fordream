
public class Main {
	
	public static void main(String[] args) {
		
		int size=5;
		DisjointUnionSet dus = new DisjointUnionSet(size);
		
		dus.printParentInfo();
		dus.union(0, 2);
		dus.printParentInfo();
		dus.union(4, 2);
		dus.printParentInfo();
		dus.union(3, 1);
		dus.printParentInfo();
		
		if(dus.find(4) == dus.find(0)){
			System.out.println("4 and 0 are friends? =>Yes");
		}else{
			System.out.println("4 and 0 are friends? =>No");
		}
		
		if(dus.find(4) == dus.find(3)){
			System.out.println("4 and 3 are friends? =>Yes");
		}else{
			System.out.println("4 and 3 are friends? =>No");
		}
		
	}

}
