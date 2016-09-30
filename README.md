
#Randomizer

Annotation based library which is used to generate random data.
This library uses reflection to parse annotations set on fields of
model classes.This library makes it super easy to generate unlimited 
random data for proper testing of your application.it requires 
minimal code changes and no boilerplate code to generate random data.
You just have to specify annotations on fields.

## Features

* Primitive and Non Primitive fields can be annotated.
* Reference type of some other class can be annotated.
* Built in data is more than enough for all random data needs.
* Custom data generator can be set for random data type for field.
* Built in data generators can be reused to create custom data generator. 


# Supported Annotations

* @AppBundleID
* @AppName
* @AppVersion
* @Avatar
* @BooleanValue
* @City
* @CollectionDescriptor
* @ColorName
* @CompanyName
* @Country
* @CountryCode
* @CreditCardNumber
* @CreditCardType
* @Currency
* @CurrencyCode
* @CustomList
* @DateValue
* @DomainName
* @DummyImageUrl
* @Email
* @Encrypt
* @FileName
* @FirstName
* @Frequency
* @FullName
* @Gender
* @Guid
* @HexColor
* @IpAddressV4
* @IpAddressV6
* @Isbn
* @JobTitle
* @Language
* @LastName
* @Latitude
* @LinkedInSkill
* @Longitude
* @MacAddress
* @Mapping
* @MD5
* @MimeType
* @Money
* @Number
* @Paragraphs
* @Phone
* @Race
* @RowNumber
* @Sentences
* @Sequence
* @SHA1
* @SHA256
* @ShirtSize
* @SSN
* @State
* @StreetAddress
* @Suffix
* @Time
* @TimeZone
* @Title
* @TopLevelDomain
* @URL
* @Username
* @Words

Some of above annotations may have options to customize its behaviour.

```java
@DateValue( from = "01 Jan 2001",to = "31 Dec 2002" , customFormat = "dd MMM yyyy")
String dateOfBirth;

@Number(min = 20,max = 30,decimals = 0)
int age;
```    

#Code Examples

## Single class

```java
public class Person {

    @FullName
    String name;

    @DateValue( from = "01 Jan 2001",to = "31 Dec 2002" , customFormat = "dd MMM yyyy")
    String dateOfBirth;

    @Number(min = 20,max = 30,decimals = 0)
    int age;

    @Avatar(width = 100,height = 100,format = Avatar.Format.PNG)
    String profileAvatar;

    @Phone(country = Phone.Country.INDIA)
    @CollectionDescriptor(min = 1,max = 3)
    List<String> phones;
}
```

## class Using Class (one to one)

```
public class Student {

    @FullName
    public String name;

    @ReferenceRecord(clazz = Address.class)
    public Address address;
}
```
```java
@ReferencedRecord
public class Address {

    @StreetAddress
    public String streetAddress;

    @State
    public String state;
}
```
Please note *@ReferencedRecord* at *Address* class.This is required. 

## class using class (one to many)

```
public class Student {

    @FullName
    public String name;

    @ReferenceRecord(clazz = Address.class)
    @CollectionDescriptor(min = 1,max = 2)
    public List<Address> address;
    
}
```
```java
@ReferencedRecord
public class Address {

    @StreetAddress
    public String streetAddress;

    @State
    public String state;

}
```


## Using custom generator

```java
//Please note that it extends GenerationRule
public class CustomCreditCardNumberGenerator extends GenerationRule<CreditCardNumber,String> {

    public CustomCreditCardNumberGenerator(CreditCardNumber annotation, ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    //Will be called automatically to generate random data from source
    @Override
    public String generate() {
        return CARD_NUMBERS[getRandom().nextInt(CARD_NUMBERS.length)];
    }

    //Provide your own data
    private final String[] CARD_NUMBERS = {"0111-0666-9888-7666","0777-9453-5672-7765"};
}
```
```java
public class Person {

    @CreditCardNumber
    @CustomGenerator(generator = CustomCreditCardNumberGenerator.class)
    public String creditCardNumber;
}
```

## Using existing Generator with Custom Generator

```
//Please note that it extends DelegateGenerationRule rather than simple GenerationRule
public class CustomEmailGenerator extends DelegateGenerationRule<Email,String> {

    public CustomEmailGenerator(Email annotation, ProviderFactory providerFactory, GenerationRule<Email, String> mCoreGenerator) {
        super(annotation, providerFactory, mCoreGenerator);
    }

    @Override
    public String generate() {
        return getCoreRandomData().toUpperCase();
    }
}
```
```java
public class Person {

    @Email
    @CustomGenerator(generator = CustomEmailGenerator.class,delegate = EmailGenerator.class)
    @CollectionDescriptor(min = 2,max = 5)
    public List<String> emails;
}
```
Generator name follows convention Annotation name followed by Generator eg.
**Annotation = @Email
Generator = EmailGenerator**

# How to generate records ?

```java
Generator<Person> generator = new Generator<>(Person.class);
List<Person> persons = generator.generate(5);
```
Simply two lines :)

## For Android 

This project has been divided into two parts *jrandomizer* and *arandomizer* .
*arandomizer* simply contains wrapper class around **Generator** class that contains 
**AsyncTask** for async data generation for android.

```java
DroidGenerator<Person> generator = new DroidGenerator<>(Person.class);
List<Person> persons = generator.generate(5);
```
simply :)


##License

Copyright 2016 Info Edge India Limited

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
