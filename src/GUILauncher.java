

import javax.swing.JFrame;

public class GUILauncher {
	public static void main(String[] args) {
		
		KnockOutGUI KnockOutGame = new KnockOutGUI();
		KnockOutGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		KnockOutGame.setSize(450, 450);
		KnockOutGame.setVisible(true);
		
	}
}