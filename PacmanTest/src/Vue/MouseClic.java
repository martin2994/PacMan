package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class MouseClic implements ActionListener {
	private String action;
	private JTextField name;
	private String input;

	public MouseClic() {
		this.action = "Nothing";
	}
	public MouseClic(JTextField _name){
		this.name=_name;
		this.input="";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Start":
			this.action = "Start";
			break;
		case "Options":
			this.action = "Options";
			break;
		case "About":
			this.action = "About";
			break;
		case "Quit":
			this.action = "Quit";
			break;
		case "Return to menu":
			this.action = "ReturnAbout";
			break;
		case "Easy":
			this.action = "Easy";
			break;
		case "Medium":
			this.action = "Medium";
			break;
		case "Hard":
			this.action = "Hard";
			break;
		}
		if(e.getSource() == name){
			input = e.getActionCommand();
		}
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String _action) {
		this.action = _action;
	}

}
