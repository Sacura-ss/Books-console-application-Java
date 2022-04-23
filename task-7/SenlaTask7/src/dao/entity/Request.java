package dao.entity;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Request extends AbstractEntity {
    Book book;
    boolean isCompleted;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Request: " + book + " " + isCompleted;
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeLong(getId());
        objectOutput.writeObject(getBook());
        objectOutput.writeBoolean(isCompleted());
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        setId(objectInput.readLong());
        setBook((Book)objectInput.readObject());
        setCompleted(objectInput.readBoolean());
    }
}
