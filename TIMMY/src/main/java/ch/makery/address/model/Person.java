
package ch.makery.address.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class Person {

    private final StringProperty fornavn;
    private final StringProperty efternavn;
    private final StringProperty vejnavn;
    private final IntegerProperty postnummer;
    private final StringProperty by;
    private final ObjectProperty<LocalDate> fødselsdato;

    /**
     * Default constructor.
     */
    public Person() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param fornavn
     * @param efternavn
     */
    public Person(String fornavn, String efternavn) {
        this.fornavn = new SimpleStringProperty(fornavn);
        this.efternavn = new SimpleStringProperty(efternavn);

        // Some initial dummy data, just for convenient testing.
        this.vejnavn = new SimpleStringProperty("");
        this.postnummer = new SimpleIntegerProperty(9999);
        this.by = new SimpleStringProperty("");
        this.fødselsdato = new SimpleObjectProperty<>(LocalDate.now());
    }

    public String getFirstName() {
        return fornavn.get();
    }

    public void setFirstName(String fornavn) {
        this.fornavn.set(fornavn);
    }

    public StringProperty firstNameProperty() {
        return fornavn;
    }

    public String getLastName() {
        return efternavn.get();
    }

    public void setLastName(String efternavn) {
        this.efternavn.set(efternavn);
    }

    public StringProperty lastNameProperty() {
        return efternavn;
    }

    public String getStreet() {
        return vejnavn.get();
    }

    public void setStreet(String vejnavn) {
        this.vejnavn.set(vejnavn);
    }

    public StringProperty streetProperty() {
        return vejnavn;
    }

    public int getPostalCode() {
        return postnummer.get();
    }

    public void setPostalCode(int postnummer) {
        this.postnummer.set(postnummer);
    }

    public IntegerProperty postalCodeProperty() {
        return postnummer;
    }

    public String getCity() {
        return by.get();
    }

    public void setCity(String by) {
        this.by.set(by);
    }

    public StringProperty cityProperty() {
        return by;
    }

    public LocalDate getBirthday() {
        return fødselsdato.get();
    }

    public void setBirthday(LocalDate fødselsdato) {
        this.fødselsdato.set(fødselsdato);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return fødselsdato;
    }
}
