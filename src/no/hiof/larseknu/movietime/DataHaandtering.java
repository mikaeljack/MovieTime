package no.hiof.larseknu.movietime;

import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import no.hiof.larseknu.movietime.model.Film;

import javax.swing.text.html.ImageView;

public class DataHaandtering {

    public static void skrivTilFil (ArrayList<Film> listemedfilmer, String path) {

        Gson gson = new Gson();
        String jsonFilmString = gson.toJson(listemedfilmer);

        try {
            BufferedWriter skriver = new BufferedWriter(new FileWriter(new File(path)));
            skriver.write(jsonFilmString);
            skriver.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Film> hentFil (String path) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Film[] filmer = null;
        Gson gson = gsonBuilder.create();

        try {
            BufferedReader lesFraFil = new BufferedReader(new FileReader(new File(path)));

            filmer = gson.fromJson(lesFraFil.readLine(), Film[].class);

        }
        catch (JsonIOException | IOException jioex) {
            MainJavaFX.mainJavaFX.visAlert("Feil filsti!");
        }

        if(filmer != null)
            return new ArrayList<>(Arrays.asList(filmer));

        return null;
    }


}
