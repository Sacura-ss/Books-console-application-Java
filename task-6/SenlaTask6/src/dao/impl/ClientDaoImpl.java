package dao.impl;

import dao.ClientDao;
import dao.entity.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientDaoImpl extends AbstractDaoImpl<Client>
        implements ClientDao{

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    private boolean checkEmail(String enteredEmail) {
        Matcher mather = VALID_EMAIL_ADDRESS_REGEX.matcher(enteredEmail);
        return mather.matches();
    }

    @Override
    protected void updateFields(Client oldEntity, Client newEntity) {
        oldEntity.setFirstName(newEntity.getFirstName());
        oldEntity.setSecondName(newEntity.getSecondName());
        if (checkEmail(newEntity.getEmail()))
            oldEntity.setEmail(newEntity.getEmail());
    }

    @Override
    public boolean changeEmailById(Long id, String email) {
        Client client = (Client) getById(id);
        if (checkEmail(email)) {
            client.setEmail(email);
            return true;
        }
        return false;
    }

    @Override
    public void changeFirstNameById(Long id, String firstName) {
        Client client = getById(id);
        client.setFirstName(firstName);
    }

    @Override
    public void changeSecondNameById(Long id, String secondName) {
        Client client = getById(id);
        client.setSecondName(secondName);
    }

    @Override
    public String exportToLine(Long id) {
        Client client = getById(id);
        String line = "";
        StringBuilder builder = new StringBuilder();
        builder.append(client.getId());
        builder.append(',');
        builder.append(client.getFirstName());
        builder.append(',');
        builder.append(client.getSecondName());
        builder.append(',');
        builder.append(client.getEmail());
        builder.append('\n');
        line = builder.toString();
        return line;
    }
}
