package smartbox;

import mvc.*;

public class RemCommand extends Command{
	public RemCommand(Model model) {
		super(model);
	}
	
	@Override
	public void execute() {
		Container container = (Container) model;
		String name = Utilities.ask("Component name?");
		try {
			container.remComponent(name);
		} catch (Exception e) {
			Utilities.error(e);
		}
	}
}
