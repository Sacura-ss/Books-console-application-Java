package dao.impl;

import dao.ClientDao;
import dao.entity.Client;

import java.util.Scanner;
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
    public void importFromLine(String line) {
        Client client = new Client();
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");
        int index = 0;
        while (scanner.hasNext()) {
            String data = scanner.next();
            if (index == 0)
                client.setId(Long.parseLong(data));
            else if (index == 1)
                client.setFirstName(data);
            else if (index == 2)
                client.setSecondName(data);
            else if (index == 3)
                client.setEmail(data);
            index++;
        }
        index = 0;
        create(client);
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
