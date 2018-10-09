package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;
    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public String toString() {
        return "ID заявки: " + this.getId() + System.lineSeparator() +
                "Имя заявки: " + this.getName() + System.lineSeparator() +
                "Создана: " + this.getCreated() + System.lineSeparator();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getCreated() {
        return created;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public String[] getComments() {
        return comments;
    }
}
