package com.kushagra.tinyURL.model;

import com.kushagra.tinyURL.constants.GlobalConstants;
import com.kushagra.tinyURL.exception.UrlAlreadyExistsException;
import com.kushagra.tinyURL.exception.UrlNotFoundException;
import com.kushagra.tinyURL.exception.UserNotRegisteredException;

import java.util.HashMap;
import java.util.HashSet;

public class TinyUrlManager {
    private static HashMap<String, Url> tinyToOriginal = new HashMap<String, Url>();
    private static HashMap<String, User> emailToUser = new HashMap<String, User>();

    public static boolean checkIfExists(String hashId){
        return tinyToOriginal.containsKey(hashId);
    }
    public static void addHashKey(String hashId, Url urlObject){
        tinyToOriginal.put(hashId, urlObject);
    }
    public static boolean checkIfExistsUser(String email){
        return emailToUser.containsKey(email);
    }

    public User getUserDetails(String email) throws UserNotRegisteredException{
        boolean userExists = checkIfExistsUser(email);
        if(userExists){
            return emailToUser.get(email);
        }
        else{
            throw new UserNotRegisteredException();
        }
    }

    public String generateTinyUrl(String originalUrl, User user, String...alias) throws UrlAlreadyExistsException {
        Url url = new Url(originalUrl, user.getUserId(), alias);
        String endpoint = url.getHashId();
        StringBuffer tinyUrl = new StringBuffer(GlobalConstants.BASE_URL);
        tinyUrl.append(endpoint);
        tinyToOriginal.put(endpoint, url);
        return tinyUrl.toString();
    }

    public void registerNewUser(String name, String email){
        User newUser = new User(name, email);
        emailToUser.put(email, newUser);
    }

    public String getOriginalUrl(String hashId) throws UrlNotFoundException{
        boolean exists = TinyUrlManager.checkIfExists(hashId);
        if(exists){
            Url url = tinyToOriginal.get(hashId);
            return url.getOriginalUrl();
        }
        else{
            throw new UrlNotFoundException();
        }
    }
}