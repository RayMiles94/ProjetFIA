/* 
 * Projet FIA : Les missionnaires et les cannibales
 * auteurs: jebri raouf , ben yahia haythem
 * 
 */
package fst.lfi.lfi3;
import java.util.ArrayList;
import java.util.List;
public class AStar {
  
	// ok
	public static void main(String args[]) {
		int K=3,N=5;
		List<Node> ouvert = new ArrayList<>();
		List<Node> ferme = new ArrayList<>();
		Node e1=new Node("A",5,5,true,0,0);
		ouvert.add(e1);	
	}
	//il faut verifier que e1 n'appartient pas a la liste des ferme sinon on la supprime
	public void chercher_ouvert(Node e1,List<Node> liste_ouverte,List<Node> liste_ferme,int k,int n) {
		for (int charge=1;charge<=k;charge++) {
			for (int miss=k;miss<=0;miss--) {
				//verifier si on peut deplacer missionnaires et cannibales : miss et charge-miss
				if (verifier_possibilite(e1,miss,charge-miss)){
					Node aux = new Node();
					//reste a verifier le noeud aux...
					aux.setLabel(e1.getLabel());//incremente le nom de label ancien ...
					aux.setNumber_C_gauche(e1.getNumber_C_gauche()-(charge-miss));
					aux.setNumber_M_gauche(e1.getNumber_M_gauche()-miss);
					aux.setNumber_C_droite(e1.getNumber_C_droite()+miss);
					aux.setNumber_M_droite(e1.getNumber_M_droite()+miss);
					aux.setB(false);
					liste_ouverte.add(aux);
					
				}
		}
		
	}
	//supprimer le noeud de l'ensemble ouvert apres calculer ses noeud suivants
		liste_ouverte.remove(e1);
		liste_ferme.add(e1);
		
		
		
}
	public boolean verifier_possibilite(Node e,int Nmiss,int Ncann) {
		if (Ncann>Nmiss) return false;
		int Mdroite = e.number_M_droite + Nmiss;
		int Cdroite = e.number_C_droite + Ncann;
		int Mgauche = e.number_M_gauche - Nmiss;
		int Cgauche = e.number_C_droite - Ncann;
		if (Cdroite>Mdroite) return false;
		if (Cgauche>Mgauche) return false;
		return true;
	}
	
  /*
	private static void deplacer_droite(int com,Node tab[],int pos,int k) {
		Node e = new Node();
		if ()
		e.number_M_gauche = tab[i].number_M_gauche - com;
		e.number_C_gauche = tab[i].number_C_gauche -(k- com);
		e.number_M_droite = tab[i].number_M_droite + com;
		e.number_C_droite = tab[i].number_C_droite + (k- com);
		e.b=false;
		tab[i+1] = e;
		
	}
	*/
}
