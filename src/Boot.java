

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;

public class Boot {

	private MainFrame mainFrame;
	public Boot() {
		try {
			this.mainFrame = new MainFrame();
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					mainFrame.setVisible(true);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null,ex);
		}
		new Boot();
	}
}
