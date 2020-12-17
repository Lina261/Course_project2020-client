package Model;

public class Country {
    private int idCountry;
    private String country;


    public Country(int idCountry, String country) {
        this.idCountry = idCountry;
        this.country = country;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return country;
    }
}
