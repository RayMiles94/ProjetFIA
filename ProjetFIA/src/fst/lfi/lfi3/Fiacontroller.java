/* 
 * Projet FIA : Les missionnaires et les cannibales
 * auteurs: jebri raouf , ben yahia haythem
 * 
 */
package fst.lfi.lfi3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Fiacontroller {
	private FiaModel model;
	private FiaView view;
	
	public Fiacontroller(FiaModel model,FiaView view){
		this.model  = model;
		this.view 	= view;
		this.view.Calculer(new Algorithme());
	}
	
	class Algorithme implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(model.Valid_K(view.getN(),view.getK())){
				model.setN(view.getN());
				model.setK(view.getK());
				view.setSoltion(model.SOLUTION(view.getN(),view.getK()));
			}
			else {
				JOptionPane.showMessageDialog(null, "k est strictement inférieur a N");
			}
			
		}
		
	}
}
