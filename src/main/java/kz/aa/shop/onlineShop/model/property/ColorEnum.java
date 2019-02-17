package kz.aa.shop.onlineShop.model.property;

public enum ColorEnum {
    BLACK("Черный"), WHITE("Белый"), GREEN("Зеленый"), RED("Красный"), BLUE("Синий");

    private String label;

    ColorEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
