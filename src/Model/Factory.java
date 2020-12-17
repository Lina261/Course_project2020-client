package Model;

public class Factory {
    private int idFactory;
    private String factoryName;

    private int idUser;

    private String directorSurname;
    private String login;
    private String countryName;
    private String factoryAddress;

    public Factory(int idFactory, String factoryName,  String directorSurname, String login, String country, String factoryAddress) {
        this.idFactory = idFactory;
        this.factoryName = factoryName;

        this.directorSurname = directorSurname;
        this.login = login;
        this.countryName = country;
        this.factoryAddress = factoryAddress;
    }

    public Factory() {

    }

    public int getIdFactory() {
        return idFactory;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setIdFactory(int idFactory) {
        this.idFactory = idFactory;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }



    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }



    public String getDirectorSurname() {
        return directorSurname;
    }

    public void setDirectorSurname(String directorSurname) {
        this.directorSurname = directorSurname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    @Override
    public String toString() {
        return factoryName;
    }
}
