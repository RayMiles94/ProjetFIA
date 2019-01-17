/* 
 * Projet FIA : Les missionnaires et les cannibales
 * auteurs: jebri raouf , ben yahia haythem
 * 
 */
package fst.lfi.lfi3;
import java.util.*;
class Node {
	public State Etat;
	public int f;
	public int g;
	public int h;
	public State getEtat() {
		return Etat;
	}
	public void setEtat(State etat) {
		Etat = etat;
	}
	public int getF() {
		return f;
	}
	public void setF(int f) {
		this.f = f;
	}
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
		
}