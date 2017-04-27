package com.example.gps_temp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        // CRUD operations (Create,Read,Update,Delete)

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addKopholder(new Kopholder("Bodum", 10, "Red"));
        db.addKopholder(new Kopholder("Alvi", 9, "Blue"));
        db.addKopholder(new Kopholder("Ibis", 11, "Yellow"));
        db.addKopholder(new Kopholder("Stelton", 8, "Marone"));

        // Reading all kopholder
        Log.d("Reading: ", "Reading all kopholder..");
        List<Kopholder> kopholder = db.getAllKopholder();

        for (Kopholder kp : kopholder) {
            String log = "Id: " + kp.getID() +
                         " ,Brand: " + kp.getBrand() +
                         " ,Diameter: " + kp.getDiameter() +
                         " ,Colour: " + kp.getColour();
                               // Writing Kopholder to log
        Log.d("Brand: ", log);
        }

    }
}
