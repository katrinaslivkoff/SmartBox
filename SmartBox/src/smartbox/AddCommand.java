package smartbox;

import mvc.*;

public class AddCommand extends Command{

	public AddCommand(Model model) {
		super(model);
	}
	
	@Override
	public void execute() {
		Container container = (Container) model;
		String name = Utilities.ask("Component name?");
		try {
			container.addComponent(name);
		} catch (Exception e) {
			Utilities.error(e);
		}
	}
}
