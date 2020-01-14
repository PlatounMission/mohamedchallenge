package momunity.com.platoun.models;

/**
 * Created by Mohamed Achref on 2020-01-10.
 */
public class Product {
    String discount;
    String image;
    String note;
    String name;
    String user;
    String soloPrice;
    String groupPrice;
    boolean like;


    public Product(String discount,String image, String note, String name, String user, String soloPrice, String groupPrice, boolean like) {
        this.discount = discount;
        this.image = image;
        this.note = note;
        this.name = name;
        this.user = user;
        this.soloPrice = soloPrice;
        this.groupPrice = groupPrice;
        this.like = like;
    }

    @Override
    public String toString() {
        return "Product{" +
                "discount='" + discount + '\'' +
                ", image='" + image + '\'' +
                ", note='" + note + '\'' +
                ", name='" + name + '\'' +
                ", user='" + user + '\'' +
                ", soloPrice='" + soloPrice + '\'' +
                ", groupPrice='" + groupPrice + '\'' +
                ", like=" + like +
                '}';
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSoloPrice() {
        return soloPrice;
    }

    public void setSoloPrice(String soloPrice) {
        this.soloPrice = soloPrice;
    }

    public String getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(String groupPrice) {
        this.groupPrice = groupPrice;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
