package Model;

public class OtherUser {
    protected  Integer idUser;
    protected  String name;
    protected  String login;
    protected  String password;
    protected  Integer role;



    public OtherUser(Integer idUser, String name, String login, String password, Integer role) {
        this.idUser = idUser;
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public OtherUser() {

    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
