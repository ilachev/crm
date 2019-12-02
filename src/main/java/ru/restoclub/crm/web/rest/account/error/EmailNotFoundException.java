package ru.restoclub.crm.web.rest.account.error;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;
import ru.restoclub.crm.web.rest.error.ErrorConstants;

public class EmailNotFoundException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    public EmailNotFoundException() {
        super(ErrorConstants.EMAIL_NOT_FOUND_TYPE, "Email address not registered", Status.BAD_REQUEST);
    }
}
