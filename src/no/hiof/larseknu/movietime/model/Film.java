package no.hiof.larseknu.movietime.model;

import java.time.LocalDate;

// En film "er en" produksjon, så derfor har vi satt at den extender Produksjon
// Vi får dermed med alle egenskapene fra Produksjon "gratis"

/**
 * Film er en klasse som representerer en film i en Film-app
 * Holder informasjon om tittel, beskrivelse, spilletid, utgivelsesdato, og URL for posteren
 * @author Lars Emil
 * @author Mikael Ås J
 */
public class Film extends Produksjon implements Comparable<Film> {

    private String posterURL;

    /**
     * Konstruktør for film
     * @param tittel tittel på filmen
     * @param beskrivelse beskrivelse for filmen
     * @param spilletid hvor lang filmen er
     * @param utgivelsesdato når filmen ble utgitt
     * @param regisor hvem som har regissert filmen
     */
    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, Person regisor) {
        // Kaller superkontruktøren (som tilhører Produksjon), vi "sender" da tittel, beskrivelse, spilletid, utgivelsesdato og regisor videre
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regisor);
    }

    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, Person regissor, String posterURL) {
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
        this.posterURL = posterURL;
    }

    public Film() {
        super();
        setUtgivelsesdato(LocalDate.now());
    }

    public String getPosterURL() {
        return posterURL;
    }
    /**
     * Redigerer toStringen til lesbar tekst
     * @return tittel og utgivelsesdato til en film
     */
    @Override
    public String toString() {
        // super - nøkkelordet her er strengt tatt ikke nødvendig, men det gjør det tydelig at metodene tilhører superklassen
        return super.getTittel() + (super.getUtgivelsesdato() != null ? " (" + super.getUtgivelsesdato().getYear() + ")" :"");// + (super.getSpilletid() > 0 ? super.getSpilletid() + " minutter" : "");
    }
    /**
     * En metode for å sammenlikne to titler for en film
     * @param sammenligningsFilm Fflmen som skal sammenlignes
     * @return tittelen på filmen
     */
    @Override
    public int compareTo(Film sammenligningsFilm) {
        // Vi sammenligner tittelen til filmene, som er en String. Så vi drar også nytte av String sin egen compareTo metode
        return this.getTittel().toLowerCase().compareTo(sammenligningsFilm.getTittel().toLowerCase());
    }
}
