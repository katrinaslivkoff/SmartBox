package smartbox;

import mvc.*;

public class RunCommand extends Command{
	public RunCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		Container container = (Container) model;
		String name = Utilities.ask("Component name?");
		try {
			container.launch(name);
		} catch (Exception e) {
			Utilities.error(e);
		}
	}
}

