package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseClic implements ActionListener {
	private String action;
	private String name;
	private String level;
	private String delete;

	public MouseClic() {
		this.action = "Nothing";
		this.name = "";
		this.level = "All";
		this.delete = "All";
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Start":
		case "Options":
		case "Scoreboard":
		case "About":
		case "Quit":
		case "Next":
		case "Easy":
		case "Medium":
		case "Hard":
		case "Delete":
		case "Save":
		case "On/Off":
			this.action = e.getActionCommand();
			break;
		case "Return to menu":
			this.action = "ReturnAbout";
			break;
		default:
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
		this.level = _level;
	}

	public String getLevel() {
		return this.level;
	}

	public void setDelete(String _delete) {
		this.delete = _delete;
	}

	public String getDelete() {
		return this.delete;
	}

}
