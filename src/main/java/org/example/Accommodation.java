package org.example;

public class Accommodation {
    int id ;
    String type;
    String bedType;
    Integer MAX_GUEST;
    String description;

    public Accommodation(int id, String type, String bedType, Integer MAX_GUEST, String description) {
        this.id = id;
        this.type = type;
        this.bedType = bedType;
        this.MAX_GUEST = MAX_GUEST;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public Integer getMAX_GUEST() {
        return MAX_GUEST;
    }

    public void setMAX_GUEST(Integer MAX_GUEST) {
        this.MAX_GUEST = MAX_GUEST;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
