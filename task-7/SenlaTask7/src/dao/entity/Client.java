package dao.entity;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

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

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeLong(getId());
        objectOutput.writeUTF(getFirstName());
        objectOutput.writeUTF(getSecondName());
        objectOutput.writeUTF(getEmail());
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        setId(objectInput.readLong());
        setFirstName(objectInput.readUTF());
        setSecondName(objectInput.readUTF());
        setEmail(objectInput.readUTF());
    }
}
