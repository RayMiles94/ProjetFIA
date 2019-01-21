/* 
 * Projet FIA : Les missionnaires et les cannibales
 * auteurs: jebri raouf , ben yahia haythem
 * 
 */
package fst.lfi.lfi3;

public class fiaMVC {
	public static void main(String args[]){
		FiaModel model = new FiaModel();
		FiaView view = new FiaView();
		@SuppressWarnings("unused")
		Fiacontroller controle = new Fiacontroller(model,view);
		view.setVisible(true);
	}
}
