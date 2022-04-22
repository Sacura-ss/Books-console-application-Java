package dao.entity;

public class Client extends Human {
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "email='" + email;
    }
}
