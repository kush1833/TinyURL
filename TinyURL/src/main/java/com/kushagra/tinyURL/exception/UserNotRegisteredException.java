package com.kushagra.tinyURL.exception;

import com.kushagra.tinyURL.constants.GlobalConstants;

public class UserNotRegisteredException extends Exception{
    public UserNotRegisteredException(){
        super(GlobalConstants.USER_NOT_REGISTERED);
    }
}
