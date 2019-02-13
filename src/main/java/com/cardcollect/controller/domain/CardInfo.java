package com.cardcollect.controller.domain;

public class CardInfo {
    private int id;
    private int bagid;
    private String cardname;
    private int cardnum;
    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBagid() {
        return bagid;
    }

    public void setBagid(int bagid) {
        this.bagid = bagid;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public int getCardnum() {
        return cardnum;
    }

    public void setCardnum(int cardnum) {
        this.cardnum = cardnum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
