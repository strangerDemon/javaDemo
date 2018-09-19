package entity.life;

import java.util.Date;


public class GirlFriend extends Person {
    private Date debutDate;
    private Date fallInLoveDate;
    private Date overDate;
    private Date marryDate;

    public Date getDebutDate() {
        return debutDate;
    }

    public void setDebutDate(Date debutDate) {
        this.debutDate = debutDate;
    }

    public Date getFallInLoveDate() {
        return fallInLoveDate;
    }

    public void setFallInLoveDate(Date fallInLoveDate) {
        this.fallInLoveDate = fallInLoveDate;
    }

    public Date getOverDate() {
        return overDate;
    }

    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }

    public Date getMarryDate() {
        return marryDate;
    }

    public void setMarryDate(Date marryDate) {
        this.marryDate = marryDate;
    }
}
