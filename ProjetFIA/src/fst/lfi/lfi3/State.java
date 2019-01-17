package fst.lfi.lfi3;

public class State {
	String label;
	int number_M_gauche,number_C_gauche;
	int number_M_droite,number_C_droite;
	boolean b;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getNumber_M_gauche() {
		return number_M_gauche;
	}
	public void setNumber_M_gauche(int number_M_gauche) {
		this.number_M_gauche = number_M_gauche;
	}
	public int getNumber_C_gauche() {
		return number_C_gauche;
	}
	public void setNumber_C_gauche(int number_C_gauche) {
		this.number_C_gauche = number_C_gauche;
	}
	public int getNumber_M_droite() {
		return number_M_droite;
	}
	public void setNumber_M_droite(int number_M_droite) {
		this.number_M_droite = number_M_droite;
	}
	public int getNumber_C_droite() {
		return number_C_droite;
	}
	public void setNumber_C_droite(int number_C_droite) {
		this.number_C_droite = number_C_droite;
	}
	public boolean isB() {
		return b;
	}
	public void setB(boolean b) {
		this.b = b;
	}
	public int getF() {
		return f;
	}
	public void setF(int f) {
		this.f = f;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	int f,h,g;
	
	public State() {
		
	}
	public State(String name, int mis_gauch,int can_gauch,boolean b,int mis_droite,int can_droite) {
		this.label = name;
		this.number_M_gauche=mis_gauch;
		this.number_C_gauche=can_gauch;
		this.number_M_droite=mis_droite;
		this.number_C_droite=can_droite;
	}
	
	public boolean isempty() {
		
	return false;
	}

}
