package com.kushagra.tinyURL.exception;

import com.kushagra.tinyURL.constants.GlobalConstants;

public class UrlNotFoundException extends Exception{
    public UrlNotFoundException(){
        super(GlobalConstants.URL_NOT_FOUND);
    }
}
