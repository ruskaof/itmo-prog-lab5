package com.ruskaof.client.commands;

import com.ruskaof.client.data.StudyGroup;
import com.ruskaof.client.utility.CollectionManager;

import java.util.StringJoiner;


public class PrintAscendingCommand extends Command {

    private final CollectionManager collectionManager;

    public PrintAscendingCommand(CollectionManager collectionManager) {
        super("print_ascending");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        StringJoiner output = new StringJoiner("\n\n");

        for (StudyGroup studyGroup : collectionManager.getMainData()) {
            output.add(studyGroup.toString());
        }

        return new CommandResult(false, output.toString());
    }
}
