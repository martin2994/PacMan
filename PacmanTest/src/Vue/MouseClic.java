package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseClic implements ActionListener {
	private String action;

	public MouseClic() {
		this.action = "Nothing";
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
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String _action) {
		this.action = _action;
	}

}
