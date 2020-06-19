package smartbox;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;

public class ContainerFactory implements AppFactory {

	@Override
	public Model makeModel() {
		Container c = new Container(); 
		return c;
	}

	@Override
	public String[] getEditCommands() {
		String[] editCommands = {"Add", "Remove", "Run"};
		return editCommands; 
	}

	@Override
	public Command makeEditCommand(Model model, String type) {
		if(type == "Add") {
			return new AddCommand(model);
		}else if(type == "Remove") {
			return new RemCommand(model);
		}else if(type == "Run") {
			return new RunCommand(model);
		}
		return null;
	}

	@Override
	public String getTitle() {
		String titleString = "SmartBox"; 
		return titleString; 
	}

	@Override
	public String[] getHelp() {
		String[] cmmds = {"Add = add component", "Remove = remove component", 
				"Run = run the program"};
	return cmmds;
	}

	@Override
	public String about() {
		String aboutString = "SmartBox Version 1.0 Copyright 2020 by Katrina Slivkoff";
		return aboutString; 
	}

}
