package ru.restoclub.crm.web.rest.account.error;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;
import ru.restoclub.crm.web.rest.error.ErrorConstants;

public class InvalidPasswordException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    public InvalidPasswordException() {
        super(ErrorConstants.INVALID_PASSWORD_TYPE, "Incorrect password", Status.BAD_REQUEST);
    }
}
