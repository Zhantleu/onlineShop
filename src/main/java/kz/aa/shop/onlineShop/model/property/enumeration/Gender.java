package kz.aa.shop.onlineShop.model.property.enumeration;

public enum Gender {
    FAMALE("Женское"), MALE("Мужское");

    private String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
