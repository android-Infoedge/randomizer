package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Password;
import com.infoedge.jrandomizer.providers.PasswordProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import java.util.concurrent.ThreadLocalRandom;


public class PasswordGenerator extends GenerationRule<Password,String> {

    //Password generator type
    public static final int ALPHA = 0;
    public static final int ALPHA_NUMERIC = 1;
    public static final int ALPHA_SPECIAL_CHAR = 2;
    public static final int ALPHA_NUMERIC_SPECIAL_CHAR = 3;

    private int minLength;
    private int maxLength;
    private int generatorType;

    private PasswordProvider mProvider;

    public PasswordGenerator(Password annotation, ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(PasswordProvider.class, String[].class);
        minLength = annotation.minLength();
        maxLength = annotation.maxLength();
        generatorType = annotation.type().getPasswordType();
    }

    @Override
    public String generate() {
        String[] passwordType = mProvider.provide();
        String passwordCharacters = passwordType[generatorType];
        int passwordLength = ThreadLocalRandom.current().nextInt(minLength,maxLength+1);
        String password=passwordType[ALPHA].charAt(getRandom().nextInt(passwordType[ALPHA].length())) + "";

        while(passwordLength>1){
            int randomIndex = getRandom().nextInt(passwordCharacters.length());
            password+=passwordCharacters.charAt(randomIndex);
            passwordLength--;
        }
        return password;
    }



}
