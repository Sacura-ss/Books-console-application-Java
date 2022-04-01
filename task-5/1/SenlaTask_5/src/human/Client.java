package human;

import human.Human;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client extends Human {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    String email = "";

    private boolean checkEmail(String enteredEmail) {
        Matcher mather = VALID_EMAIL_ADDRESS_REGEX.matcher(enteredEmail);
        return mather.matches();
    }

    public Client(String firstName, String secondName, String email) {
        super(firstName, secondName);
        if(checkEmail(email))
            this.email = email;
        else {
            System.out.println("Invalid mail");
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
