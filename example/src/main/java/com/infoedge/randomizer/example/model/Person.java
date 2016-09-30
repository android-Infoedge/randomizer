package com.infoedge.randomizer.example.model;

import com.infoedge.jrandomizer.annotations.Avatar;
import com.infoedge.jrandomizer.annotations.CollectionDescriptor;
import com.infoedge.jrandomizer.annotations.CreditCardNumber;
import com.infoedge.jrandomizer.annotations.CustomGenerator;
import com.infoedge.jrandomizer.annotations.DateValue;
import com.infoedge.jrandomizer.annotations.Email;
import com.infoedge.jrandomizer.annotations.FullName;
import com.infoedge.jrandomizer.annotations.Number;
import com.infoedge.jrandomizer.annotations.Phone;
import com.infoedge.jrandomizer.generators.EmailGenerator;
import com.infoedge.randomizer.example.CustomCreditCardNumberGenerator;
import com.infoedge.randomizer.example.CustomEmailGenerator;

import java.util.List;

/**
 * Created by gagandeep on 12/8/16.
 */

public class Person {

    @Email
    @CustomGenerator(generator = CustomEmailGenerator.class,delegate = EmailGenerator.class)
    @CollectionDescriptor(min = 2,max = 5)
    public List<String> emails;
}
