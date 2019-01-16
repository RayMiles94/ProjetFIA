package fst.lfi.lfi3;

public class fiaMVC {
	public static void main(String args[]){
		FiaModel model = new FiaModel();
		FiaView view = new FiaView();
		Fiacontroller controle = new Fiacontroller(model,view);
		view.setVisible(true);
	}
}
