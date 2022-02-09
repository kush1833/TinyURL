package com.kushagra.tinyURL;

import com.kushagra.tinyURL.constants.GlobalConstants;

public class OutputPrinter{
    public void printRedirectedUrl(final String msg){printMessage(msg);}
    public void printWelcomeMessage(){printMessage(GlobalConstants.WELCOME);}
    public void printInputCTA(){printMessage(GlobalConstants.INPUT_CTA);}
    public void printWrongInputMessage(){printMessage(GlobalConstants.WRONG_INPUT);}
    public void printTinyUrlInputMessage(){printMessage(GlobalConstants.TINY_URL_INPUT);}
    public void printUserDetailsInputMessage(){printMessage(GlobalConstants.USER_DETAILS_INPUT);}
    public void printSuccessRegisterMessage(){printMessage(GlobalConstants.SUCCESS_REGISTER);}
    public void printEmailInputMessage(){printMessage(GlobalConstants.EMAIL_INPUT);}
    public void printOriginalURLInputMessage(){printMessage(GlobalConstants.ORIGINAL_URL_INPUT);}
    public void printAliasOptionMessage(){printMessage(GlobalConstants.ALIAS_OPTION);}
    public void printAliasInputMessage(){printMessage(GlobalConstants.ALIAS_INPUT);}
    public void printExitMessage(){printMessage(GlobalConstants.EXIT_MESSAGE);}
    public void printMessage(final String msg){
        System.out.println(msg);
    }
}