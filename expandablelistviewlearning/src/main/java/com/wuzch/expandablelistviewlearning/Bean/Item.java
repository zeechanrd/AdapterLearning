package com.wuzch.expandablelistviewlearning.Bean;

/**
 * Created by Administrator on 2016/11/6.
 */

public class Item {
    private int item_icon_Id;
    private String item_name;

    public Item(){

    }

    public Item(int item_icon_Id,String item_name){
        this.item_icon_Id=item_icon_Id;
        this.item_name=item_name;
    }

    public int getItem_icon_Id() {
        return item_icon_Id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_icon_Id(int item_icon_Id) {
        this.item_icon_Id = item_icon_Id;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
}
