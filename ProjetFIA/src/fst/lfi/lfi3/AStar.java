/* 
 * Projet FIA : Les missionnaires et les cannibales
 * auteurs: jebri raouf , ben yahia haythem
 * 
 */
package fst.lfi.lfi3;
import java.util.ArrayList;
import java.util.List;
public class AStar {
  
	int K;
	int N;
	String solution="";
	public AStar(int k,int n) {

		
		int K=k,N=n;
		ArrayList<Node> ouvert = new ArrayList<Node>();
		ArrayList<Node> ferme = new ArrayList<Node>();
		Node first = new Node();
		first.setEtat(new State("A",0,0,true,0,0));
		first.setF(0);
		first.setH(0);
		first.setG(0);
		ouvert.add(first);
		ferme.add(first);
		solution="Solution: \n";
		while(!goal_test(ouvert)) {
			rechercher(ouvert,ferme); 
			solution += "Ouvert:";
			int i=0;
			while(ouvert.size()>i){
				solution += "f:"+ouvert.get(i).getF()+" h:"+ouvert.get(i).getH()+" G:"+ouvert.get(i).getG();
				i++;
			}
			solution +="\n";
			solution += "ferme:\n";
			int j=0;
			while(ferme.size()>j){
				solution += "f:"+ferme.get(j).getF()+" h:"+ferme.get(j).getH()+" G:"+ferme.get(j).getG();
			}
		}
	}
	public boolean goal_test(ArrayList<Node> ouvert) {
		for (int i=0;i<ouvert.size();i++) {
			try {
			State etat = ouvert.get(i).getEtat();
				if ((etat.getNumber_M_droite()==this.N)&&(etat.getNumber_C_droite()==this.N)) return true;
			}
			catch(NullPointerException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//fonction pour selectionner le minimum apartir de ouvert voir les possibilité à partir de ce noeud et ensuite les mettre dans ouvert
	public void rechercher(ArrayList<Node> ouvert,ArrayList<Node> ferme) {
		int indice = chercher_min(ouvert);
			proceder(ouvert,ferme,indice);
				
	}
	



	public void proceder(ArrayList<Node> ouvert,ArrayList<Node> ferme,int indice) {
		
		if(!ouvert.isEmpty()){
			Node noeud = ouvert.get(indice);//etat don't la fonction f est minimum a partir de l'ensebme Ouvert
			Node courant = noeud;
			//cominer tout les possibilites possible d'un deplacement et ensuite verifier si c'est possible
			
			//il faut remplacer la condition dans la boucle !!!!
			//mettre la valeur de K!!!!
			
			for (int charge=1;charge<=3;charge++) { //remplacer 3 par la valeurs de K
				for (int miss=3;miss<=0;miss--) {	//remplacer 3 par la valeur de K ici
					if (verifier_possibilite(noeud,miss,charge-miss)) {
					//ajouter le noued a ouvert	
					add(ouvert,noeud);
					}
				
				}
				
				
			}
			remove(ferme,courant);
			//supprimer le noeud de ferme 
		}
		else {
			System.out.println("ouvert est vide");
			System.exit(1);
		}
		
	}
	
	public void add(ArrayList<Node> ouvert,Node element) {
		/* for(int i=0;i<ouvert.size();i++) {
			if (ouvert.get(i).getEtat().isempty())
				ouvert.add(element);
		} */ ouvert.add(element);
	}
	public void remove(ArrayList<Node> ferme ,Node element) {
		for (int i=0;i<ferme.size();i++) {
			if (ferme.get(i)==element)
				decaler(i,ferme);
		}
	}
	
	//reste a finir decaler
	public void decaler(int pos,ArrayList<Node> ferme) {
		for (int i =pos;i<ferme.size()-1;i++) {
			ferme.add(ferme.get(i+1));
		}
		State e = new State("empty", 0, 0,true, 0, 0);
		ferme.get(ferme.size()).setEtat(e);
	}
	
	public boolean verifier_possibilite(Node e,int Nmiss,int Ncann) {
		if (Ncann>Nmiss) return false;
		
		State s = e.getEtat();
		if (s.isB()==true) {
		int Mdroite = s.getNumber_M_droite() + Nmiss;
		int Cdroite = s.getNumber_C_droite() + Ncann;
		int Mgauche = s.getNumber_M_gauche() - Nmiss;
		int Cgauche = s.getNumber_C_gauche() - Ncann;
		if (Cdroite>Mdroite) return false;
		if (Cgauche>Mgauche) return false;
		Node aux = new Node();
		aux.setG(Nmiss+Ncann);//la fonction G est la charge du bateau
		aux.setF(e.getG()+1);
		aux.setH(e.getG()+1+Nmiss+Ncann);
		State et = new State();
		
		et.setNumber_C_droite(Cdroite);
		et.setNumber_M_droite(Mdroite);
		et.setNumber_C_gauche(Cgauche);
		et.setNumber_M_gauche(Mgauche);

		aux.setEtat(et);
		e=aux;
		}
			else {
				int Mdroite = s.getNumber_M_droite() - Nmiss;
				int Cdroite = s.getNumber_C_droite() - Ncann;
				int Mgauche = s.getNumber_M_gauche() + Nmiss;
				int Cgauche = s.getNumber_C_gauche() + Ncann;
				if (Cdroite>Mdroite) return false;
				if (Cgauche>Mgauche) return false;
				Node aux = new Node();
				aux.setG(Nmiss+Ncann);//la fonction G est la charge du bateau
				aux.setF(e.getG()+1);
				aux.setH(e.getG()+1+Nmiss+Ncann);
				State et = new State();
				
				et.setNumber_C_droite(Cdroite);
				et.setNumber_M_droite(Mdroite);
				et.setNumber_C_gauche(Cgauche);
				et.setNumber_M_gauche(Mgauche);

				aux.setEtat(et);
				e=aux;
			}

		return true;
	}
  /*
	private static void deplacer_droite(int com,State tab[],int pos,int k) {
		State e = new State();
		if ()
		e.number_M_gauche = tab[i].number_M_gauche - com;
		e.number_C_gauche = tab[i].number_C_gauche -(k- com);
		e.number_M_droite = tab[i].number_M_droite + com;
		e.number_C_droite = tab[i].number_C_droite + (k- com);
		e.b=false;
		tab[i+1] = e;
		
	}
	*/
	
	private int chercher_min(ArrayList<Node> ouvert) {
		int min=0;
		try {
		    min = ouvert.get(1).getF();
			for (int i=1;i<ouvert.size();i++) {
				int f = ouvert.get(i).getF();
				if(f<min) min = f;
				
			}
		}
		catch(IndexOutOfBoundsException e){
			
		}
		
		
		return min;
	}
	
	
	
	public String getsoltion()
	{   return this.solution;  }
}