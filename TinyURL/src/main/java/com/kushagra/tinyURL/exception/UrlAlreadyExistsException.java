package com.kushagra.tinyURL.exception;

import com.kushagra.tinyURL.constants.GlobalConstants;

public class UrlAlreadyExistsException extends Exception{
    public UrlAlreadyExistsException() {
        super(GlobalConstants.KEY_ALREADY_EXISTS);
    }
}
