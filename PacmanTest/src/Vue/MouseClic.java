package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class MouseClic implements ActionListener {
	private String action;
	private String name;
	private JComboBox jcmbType;
	private String level;

	public MouseClic() {
		this.action = "Nothing";
		this.name = "";
		this.level="All";
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Start":
			this.action = "Start";
			break;
		case "Options":
			this.action = "Options";
			break;
		case "Scoreboard" :
			this.action="Scoreboard";
			break;
		case "About":
			this.action = "About";
			break;
		case "Quit":
			this.action = "Quit";
			break;
		case "Next":
			this.action = "Next";
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
		case "Save":
			this.action = "Save";
			break;
		case "On/Off":
			this.action ="On/Off";
			break;
		}
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String _action) {
		this.action = _action;
	}

	public void setName(String _name) {
		this.name = _name;
	}

	public String getName() {
		return this.name;
	}

	public void setLevel(String _level) {
		this.level=_level;
	}
	
	public String getLevel(){
		return this.level;
	}

}
