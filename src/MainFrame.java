import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextArea;

import bsh.EvalError;
import bsh.Interpreter;

import com.xintegrator.xutil.ui.DefaultMainFrame;
import com.xintegrator.xutil.ui.DefaultPanel;


public class MainFrame extends DefaultMainFrame {

	private static final long serialVersionUID = 1L;
	JButton okButton = new JButton("OK");
	JTextArea beanShell;
	DefaultPanel beanShellPanel;
	public int i = 10;
	
	public MainFrame() {
		super();
		this.addButtonInToolBar(okButton);
		try {
			this.addPanel(getMainPanel(), BorderLayout.CENTER);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EvalError e) {
			e.printStackTrace();
		}
		this.beanShellPanel.updateUI();
	}

	
	private DefaultPanel getMainPanel() throws FileNotFoundException, IOException, EvalError {
		if (beanShellPanel == null) {
			beanShellPanel = new DefaultPanel();
			beanShellPanel.setLayout(new BorderLayout());
			beanShell = new JTextArea();
			beanShell.setText("import javax.swing.JOptionPane;\n" +
					"JOptionPane.showMessageDialog(null, \"Ops..\");");
			this.okButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						
						new Interpreter().eval(beanShell.getText().toString());
					} catch (EvalError e1) {
						e1.printStackTrace();
					}
				}
				
			});
			//beanShell.setBounds(30, 10, 200, 100);
			beanShellPanel.add(beanShell,BorderLayout.CENTER);
		}
		return beanShellPanel;
	}			
	private int getI()  {
		return i;
	}
}
