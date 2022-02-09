package com.kushagra.tinyURL.model;

import com.kushagra.tinyURL.constants.GlobalConstants;
import com.kushagra.tinyURL.exception.UrlAlreadyExistsException;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Url {
    private String originalUrl;
    private Date createdAt;
    private Date expirationAt;
    private int userId;
    private String hashId;

    public Url(String originalUrl, int userId, String...hashId) throws  UrlAlreadyExistsException{
        this.originalUrl = originalUrl;
        this.userId = userId;
        this.hashId = generateHashId(originalUrl, hashId);
    }

    public String getHashId(){
        return this.hashId;
    }

    public String getOriginalUrl(){
        return this.originalUrl;
    }

    private String generateHashId(String originalUrl, String...hash) throws UrlAlreadyExistsException{
        String generatedHash;
        if(hash.length==0){
            StringBuilder key = new StringBuilder();
            Random random = new Random();
            for(int i=0; i < GlobalConstants.KEY_LENGTH; i++){
                key.append(GlobalConstants.KEY_VALUES.charAt(random.nextInt(GlobalConstants.KEY_VALUES.length())));
            }
            generatedHash = key.toString();
        }
        else{
            if(TinyUrlManager.checkIfExists(hash[0])){
                throw new UrlAlreadyExistsException();
            }
            generatedHash = hash[0];
        }
        return generatedHash;
    }
}