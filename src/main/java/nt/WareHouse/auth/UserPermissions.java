package nt.WareHouse.auth;

public enum UserPermissions {
    CREATE("CREATE"),
    DELETE("DELETE"),
    UPDATE("UPDATE"),
    READ_BY_ID("READ_BY_ID"),
    READ_BY_PARAM("READ_BY_PARAM"),
    READ("READ");

    private final String name;


    UserPermissions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
