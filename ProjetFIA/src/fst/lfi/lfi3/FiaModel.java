/* 
 * Projet FIA : Les missionnaires et les cannibales
 * auteurs: jebri raouf , ben yahia haythem
 * 
 */
package fst.lfi.lfi3;

public class FiaModel {
	int N;
	int K;
	public FiaModel(){
		
	}
	
	public boolean Valid_K(int n,int k){
		return k<n? true : false;
	}
	
	public String SOLUTION(int i, int j){
		AStar sol = new AStar(i,j);
		
		return sol.getsoltion();
		
	}
	
	public void setN(int n){
		this.N = n;
	}
	
	public void setK(int k){
		this.K = k;
	}
}
