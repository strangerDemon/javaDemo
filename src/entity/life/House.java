package entity.life;

import java.util.Date;

public class House {
    private String address;
    private float area;
    private float price;
    private Date buyDate;
    private Date sellDate;

    public static House buyHouse(String address,float area, float price){
        House house=new House();
        house.address=address;
        house.area=area;
        house.price=price;
        house.buyDate=new Date();
        return house;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }
}
