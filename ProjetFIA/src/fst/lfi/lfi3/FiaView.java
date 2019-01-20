/* 
 * Projet FIA : Les missionnaires et les cannibales
 * auteurs: jebri raouf , ben yahia haythem
 * 
 */
package fst.lfi.lfi3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FiaView extends JFrame {

	private JPanel contentPane;
	private JTextField number;
	JButton btnNewButton;
	private JTextField K;
	private JLabel lblK;
	JTextArea res;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FiaView() {
		setTitle("Les missionnaires et les cannibales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 515);
		contentPane = new JPanel();
		setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLesMissionnairesEt = new JLabel("Les missionnaires et les cannibales");
		lblLesMissionnairesEt.setBackground(Color.BLUE);
		lblLesMissionnairesEt.setBounds(10, 29, 309, 48);
		contentPane.add(lblLesMissionnairesEt);
		
		JLabel lblNewLabel = new JLabel("donner number deLes Missionnaires et Les Cannibales:");
		lblNewLabel.setBounds(10, 88, 460, 14);
		contentPane.add(lblNewLabel);
		
		number = new JTextField();
		number.setBounds(320, 85, 46, 20);
		contentPane.add(number);
		number.setColumns(10);
		
	    btnNewButton = new JButton("Calculer");
		
		btnNewButton.setBounds(478, 84, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblResultat = new JLabel("Resultat:");
		lblResultat.setBounds(10, 125, 181, 14);
		contentPane.add(lblResultat);
		
		K = new JTextField();
		K.setBounds(424, 85, 46, 20);
		contentPane.add(K);
		K.setColumns(10);
		
		lblK = new JLabel("K");
		lblK.setBounds(376, 88, 15, 14);
		contentPane.add(lblK);
		
		res = new JTextArea();
		res.setBounds(10, 150, 660, 316);
		contentPane.add(res);
		
		JScrollPane scrolltxt=new JScrollPane(res);
		scrolltxt.setBounds(10,150,660,300);
        contentPane.add(scrolltxt);
	}
	
	public void Calculer(ActionListener cal){
		btnNewButton.addActionListener(cal);
	}
	
	public int getN(){
		return  Integer.parseInt(number.getText().toString());
	}
	public int getK(){
		return  Integer.parseInt(K.getText().toString());
	}
	
	public void SET_SOLUTION(String solution){
		res.setText(solution);
	}

	public void setSoltion(String arg0) {
		res.setText(arg0);
		
	}
}
