package dao.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client extends Human{
    String email = "";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
