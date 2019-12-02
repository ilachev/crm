package ru.restoclub.crm.web.rest.account.error;

import ru.restoclub.crm.web.rest.error.BadRequestAlertException;
import ru.restoclub.crm.web.rest.error.ErrorConstants;

public class EmailAlreadyUsedException extends BadRequestAlertException {

    private static final long serialVersionUID = 1L;

    public EmailAlreadyUsedException() {
        super(ErrorConstants.EMAIL_ALREADY_USED_TYPE, "Email is already in use!", "userManagement", "emailexists");
    }
}
