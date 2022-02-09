package com.kushagra.tinyURL.service;

import com.kushagra.tinyURL.OutputPrinter;
import com.kushagra.tinyURL.constants.GlobalConstants;
import com.kushagra.tinyURL.exception.WrongTinyUrlExcpetion;
import com.kushagra.tinyURL.model.TinyUrlManager;
import com.kushagra.tinyURL.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TinyUrlService {
    private final TinyUrlManager tinyUrlManager;
    private final BufferedReader bufferedReader;
    private final OutputPrinter outputPrinter;

    public TinyUrlService(){
        this.tinyUrlManager = new TinyUrlManager();
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.outputPrinter = new OutputPrinter();
    }

    public void process() {
        String name,email,originalUrl,tinyUrl,alias=null;
        outputPrinter.printWelcomeMessage();
        while(true){
            try {
                outputPrinter.printInputCTA();
                int option = Integer.parseInt(bufferedReader.readLine());
                switch (option) {
                    case 1:
                        outputPrinter.printUserDetailsInputMessage();
                        name = bufferedReader.readLine();
                        email = bufferedReader.readLine();
                        tinyUrlManager.registerNewUser(name, email);
                        outputPrinter.printSuccessRegisterMessage();
                        outputPrinter.printMessage(GlobalConstants.SEPARATOR);
                        break;
                    case 2:
                        outputPrinter.printEmailInputMessage();
                        email = bufferedReader.readLine();
                        User user = tinyUrlManager.getUserDetails(email);
                        outputPrinter.printOriginalURLInputMessage();
                        originalUrl = bufferedReader.readLine();
                        outputPrinter.printAliasOptionMessage();
                        char aliasOption = bufferedReader.readLine().charAt(0);
                        if(aliasOption == 'Y'||aliasOption=='y'){
                            outputPrinter.printAliasInputMessage();
                            alias = bufferedReader.readLine();
                            if(alias.length() < 6){
                                alias = null;
                            }
                        }
                        if(alias != null)
                            tinyUrl = tinyUrlManager.generateTinyUrl(originalUrl, user, alias);
                        else
                            tinyUrl = tinyUrlManager.generateTinyUrl(originalUrl, user);
                        outputPrinter.printMessage(GlobalConstants.GENERATED_URL + tinyUrl);
                        outputPrinter.printMessage(GlobalConstants.SEPARATOR);
                        break;
                    case 3:
                        outputPrinter.printTinyUrlInputMessage();
                        tinyUrl = bufferedReader.readLine();
                        int baseUrlLength = GlobalConstants.BASE_URL.length();
                        int index = tinyUrl.indexOf(GlobalConstants.BASE_URL);
                        if(index==-1){
                            throw new WrongTinyUrlExcpetion();
                        }
                        String hashKey = tinyUrl.substring(index+baseUrlLength);
                        originalUrl = tinyUrlManager.getOriginalUrl(hashKey);
                        outputPrinter.printMessage(GlobalConstants.ORIGINAL_URL + originalUrl);
                        outputPrinter.printMessage(GlobalConstants.SEPARATOR);
                        break;
                    case 4:
                        outputPrinter.printExitMessage();
                        outputPrinter.printMessage(GlobalConstants.SEPARATOR);
                        System.exit(0);
                    default:
                        outputPrinter.printWrongInputMessage();
                        outputPrinter.printMessage(GlobalConstants.SEPARATOR);
                        break;
                }
            }
            catch(Exception e){
                outputPrinter.printMessage(e.getMessage());
                outputPrinter.printMessage(GlobalConstants.SEPARATOR);
            }
        }
    }
}
