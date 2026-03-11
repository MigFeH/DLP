package errorhandler;

import ast.tipos.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private static ErrorHandler instance;
    private static List<ErrorType> errors;

    private ErrorHandler() {
        errors = new ArrayList<>();
    }

    public static ErrorHandler getInstance() {
        if (instance == null) {
            instance = new ErrorHandler();
        }
        return instance;
    }

    public void addError(ErrorType error) {
        errors.add(error);
    }

    public void showErrors(PrintStream stream) {
        for(ErrorType error : errors) {
            stream.println(error);
        }
    }

    public boolean anyError() {
        return !errors.isEmpty();
    }

}
