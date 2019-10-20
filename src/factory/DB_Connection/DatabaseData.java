package factory.DB_Connection;

public enum DatabaseData {

    URL("jdbc:mysql://localhost:3306/Factory"),
    USER("root"), PASSWORD(" ");



   private String name;

     DatabaseData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
