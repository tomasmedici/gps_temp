package com.example.gps_temp;

/**
 * Created by B004341 on 23-03-2017.
 */

public class Kopholder {
    //maerke
    int _id;
    String _brand;
    int _diameter;
    String _colour;

    //Empty constructor
    public Kopholder(){

    }
    //constructor
    public Kopholder(int id, String brand, int diameter, String colour){
        this._id = id;
        this._brand = brand;
        this._diameter = diameter;
        this._colour = colour;
    }

    //constructor
    public Kopholder(String brand, int diameter, String colour){
        this._brand = brand;
        this._diameter = diameter;
        this._colour = colour;
    }

    //getting ID
    public int getID() {
        return this._id;
    }
    //getting brand
    public String getBrand(){
        return this._brand;
    }
    //getting diameter
    public int getDiameter(){
        return this._diameter;
    }
    //getting colour
    public String getColour(){
        return this._colour;
    }
    //setting ID
    public void setID (int id){
        this._id = id;
    }
    //setting brand
    public void setBrand(String brand){
        this._brand = brand;
    }
    //setting diameter
    public void setDiameter(int diameter){
        this._diameter = diameter;
    }
    //setting colour
    public void  setColour(String colour){
        this._colour = colour;
    }
}
