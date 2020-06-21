package no.hiof.larseknu.movietime.model;

import java.time.LocalDate;
import java.util.ArrayList;

// Vi ønsker ikke å kunne lage egne objekter av Produksjon, og har derfor satt den til abstrakt

/**
 * Produksjon er en klasse som representerer både film og TVSerie.
 * Inneholder informasjon om tittel, berskrivelse, spilletid, utgivelsesdato, regissør og roller
 */
public abstract class Produksjon {
    private String tittel, beskrivelse;
    private int spilletid;
    private LocalDate utgivelsesdato;
    private Person regissor;
    private ArrayList<Rolle> rolleListe = new ArrayList<>();

    public Produksjon(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, Person regissor) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.spilletid = spilletid;
        this.utgivelsesdato = utgivelsesdato;
        this.regissor = regissor;
    }

    public Produksjon() {
        tittel = "";
        beskrivelse = "";
        spilletid = 0;
        utgivelsesdato = LocalDate.MIN;
        regissor = new Person();
    }

    /**
     * Legger til en rolle i en liste
     * @param enRolle rollen som blir spilt i en produksjon
     */
    public void leggTilEnRolle(Rolle enRolle) {
        rolleListe.add(enRolle);
    }

    /**
     * Legger til flere roller i en liste
     * @param rolleListe en liste med roller i en produksjon
     */
    public void leggTilMangeRoller(ArrayList<Rolle> rolleListe) {
        // Vi legger alle elementene fra rolleListen vi sender inn som parameter, til rolleListen som hører til denne produksjonen
        this.rolleListe.addAll(rolleListe);
    }


    public ArrayList<Rolle> getRolleListe() {
        // Vi lager en kopi av listen vi har, slik at den interne listen ikke kan manipuleres direkte utenfor klassen (innkapsling)
        return new ArrayList<>(rolleListe);
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }

    public Person getRegissor() {
        return regissor;
    }

    public void setRegissor(Person regissor) {
        this.regissor = regissor;
    }

    /**
     * Overrider teksten slik at man får en lesbar tekst
     * @return tittel og hvilket år produksjonen ble utgitt
     */
    @Override
    public String toString() {
        return tittel + " " + utgivelsesdato.getYear();
    }
}
