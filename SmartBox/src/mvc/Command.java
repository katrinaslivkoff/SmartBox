package mvc;

public abstract class Command {
	protected Model model;
	
	public Command(Model model) {
		super();
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "command.model = " + model;
	}

	public abstract void execute();
	
}

