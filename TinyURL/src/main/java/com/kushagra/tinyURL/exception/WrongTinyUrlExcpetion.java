package com.kushagra.tinyURL.exception;

import com.kushagra.tinyURL.constants.GlobalConstants;

public class WrongTinyUrlExcpetion extends Exception{
    public WrongTinyUrlExcpetion(){
        super(GlobalConstants.WRONG_TINY_URL);
    }
}
