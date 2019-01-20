/* 
 * Projet FIA : Les missionnaires et les cannibales
 * auteurs: jebri raouf , ben yahia haythem
 * 
 */
package fst.lfi.lfi3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FiaModel {
	int N;
	int K;
	public FiaModel(){
		
	}
	
	public boolean Valid_K(int n,int k){
		return k<n? true : false;
	}
	
	public String SOLUTION(int i, int j){
		String message="";
		State initialState = new State (i, j, Position.LEFT, 0, 0);
		AStar astar = new AStar();
		State solution = astar.exec(initialState);
		if (null == solution) {
			System.out.print("\nNo solution found.");
		} else {
			System.out.println("\nSolution (cannibalLeft,missionaryLeft,boat,cannibalRight,missionaryRight): ");
			List<State> path = new ArrayList<State>();
			State state = solution;
			while(null!=state) {
				path.add(state);
				state = state.getParentState();
			}

			int depth = path.size() - 1;
			for (int a = depth; a >= 0; a--) {
				state = path.get(a);
				if (state.isGoal()) {
					message += state.toString();
				} else {
					message += state.toString() + " -> ";
				}
			}
			message += "\nDepth: " + depth;
		}
		return message;
	}
	
	public void setN(int n){
		this.N = n;
	}
	
	public void setK(int k){
		this.K = k;
	}
}
