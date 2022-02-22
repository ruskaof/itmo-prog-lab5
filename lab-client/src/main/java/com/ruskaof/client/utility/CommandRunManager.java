package com.ruskaof.client.utility;

import com.ruskaof.client.commands.Command;
import com.ruskaof.client.commands.CommandResult;

public class CommandRunManager {
    private final CommandManager commandManager;
    private final HistoryManager historyManager;

    public CommandRunManager(CommandManager commandManager, HistoryManager historyManager) {
        this.commandManager = commandManager;
        this.historyManager = historyManager;
    }

    public CommandResult runCommand(String name, String arg) {
        CommandResult commandResult = null;
        for (Command command : commandManager.getCommands()) {
            if (command.getName().equals(name)) {
                commandResult = command.execute(arg);
                historyManager.addNote(command.getName());
                break;
            }
        }
        if (commandResult == null) {
            return new CommandResult(false, false, "This command was not found. Please use \"help\" to know about available commands");
        }
        return commandResult;
    }
}
