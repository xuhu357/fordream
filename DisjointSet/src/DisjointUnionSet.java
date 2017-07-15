
public class DisjointUnionSet {
	
	private int[] parent; 	// [required] for saving the parent info.
	private int[] rank;		// [required] for saving the tree height.
	private int size;
	
	public DisjointUnionSet(int size) {
		parent = new int[size];
		rank = new int[size];
		this.size = size;
		makeSet();
	}
	
	/**
	 * [required] Make initial set.
	 */
	public void makeSet(){
		for(int i=0; i<size; i++){
			parent[i] = i;
		}
	}
	
	/**
	 * [optional] Print the parent info.
	 */
	public void printParentInfo(){
		for(int i=0; i<size; i++){
			System.out.print(parent[i]+" ");
		}
		System.out.println();
	}

	/**
	 * [required] Find the root of the current number.
	 * 
	 * @param numToFind
	 * @return the root of the set
	 */
	public int find(int numToFind){
		if(parent[numToFind] == numToFind){ // If i is the parent of itself
			return numToFind;
			
		}else{	// Else if i is not the parent of itself
			int result = find(parent[numToFind]);
			
			parent[numToFind] = result; // cache the result.  
			
			return result;
		}
	}
	
	/**
	 * [required] To union the two number, make them belong to one set.
	 * @param i
	 * @param j
	 */
	public void union(int i, int j){
		
		int iRoot = find(i);
		int jRoot = find(j);
		
		if(iRoot == jRoot){
			return;
		}
		
		int irank = rank[iRoot];
		int jrank = rank[jRoot];
		
		if(irank < jrank){
			this.parent[iRoot] = jRoot;
			
		}else if(jrank < irank){
			this.parent[jRoot] = iRoot;
			
		}else{
			this.parent[iRoot] = jRoot;
			rank[jRoot]++;
		}
		
	}

}
