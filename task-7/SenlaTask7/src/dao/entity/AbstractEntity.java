package dao.entity;

import java.io.Externalizable;

public abstract class AbstractEntity implements Externalizable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }

}
