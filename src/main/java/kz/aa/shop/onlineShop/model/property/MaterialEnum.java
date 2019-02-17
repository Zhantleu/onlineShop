package kz.aa.shop.onlineShop.model.property;

public enum MaterialEnum {
    COTTON("Хлопок"),
    WOOL("Шерсть");

    private String label;

    MaterialEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
