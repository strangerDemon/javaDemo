package entity.life;

import java.text.SimpleDateFormat;
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

    public String getFormatBuyDate(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return format.format(buyDate.getTime());
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public String getFormatSellDate(){
        if(sellDate==null)return "未出售";
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return format.format(sellDate.getTime());
    }
    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", buyDate=" + getFormatBuyDate() +
                ", sellDate=" + getFormatSellDate() +
                '}';
    }
}
