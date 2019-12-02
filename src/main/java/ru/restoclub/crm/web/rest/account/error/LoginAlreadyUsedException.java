package ru.restoclub.crm.web.rest.account.error;

import ru.restoclub.crm.web.rest.error.BadRequestAlertException;
import ru.restoclub.crm.web.rest.error.ErrorConstants;

public class LoginAlreadyUsedException extends BadRequestAlertException {

    private static final long serialVersionUID = 1L;

    public LoginAlreadyUsedException() {
        super(ErrorConstants.LOGIN_ALREADY_USED_TYPE, "Login name already used!", "userManagement", "userexists");
    }
}
