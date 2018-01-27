package commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;
import subsystems.AutoController;

public abstract class AutoCommand extends Command {
	public boolean running;
	private int commandPriority;
	protected AutoController controller= Robot.driveSystem.getAutoController();
	
	protected AutoCommand() {
		commandPriority = 5;
	}
	
	protected AutoCommand(int priority) {
		commandPriority = priority;
	}
	
	public int getPriority() {
		return commandPriority;
	}
}
