package app.entity.cars;

import java.math.BigInteger;
import java.util.Date;

public class PassportData {
    private long id;
    private String vin;
    private String modelTS;
    private String typeTS;
    private String category;
    private Date yearOfBuild;
    private String modelOfEngine;
    private int eccoClass;
    private String numberOfEngine;
    private String numberOfChassis;
    private String numberOfBody;
    private String color;
    // в лошадинных силах
    private String powerOfEngine;
    private int volumeOfEngine;
    private int maxMass;
    private int maxMassWithout;
    private String builder;

    private String numberOfPassportTS;
    private Date dateOfPassportTS;
    private String placeOfissuanceOfPassportTS;

    private Owner owner;
    private BigInteger cost;
    //private Group group;
    private String regNumber;
    private String oldregNumber;
    private String certificateOfRegistration;
    private String placeOfregistration;
    private Date dateOfRegistration;
    private Date tempRegistration;

    private String typeOfBody; // сменить на енум
    private  int quantityOfPallet;
    private double lenghtOfBody;
    private double widhtOfBody;
    private double heightOfBody;
    private double volumeOfBody;


}
