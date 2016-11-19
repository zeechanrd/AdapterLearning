package com.wuzch.listviewlearningdemo.bean;

/**
 * Created by Administrator on 2016/11/3.
 */

public class Data {
    private int imgid;
    private String title;
    private String contain;
    public Data(){

    }
    public Data(int imgid,String title,String contain){
        this.imgid=imgid;
        this.title =title;
        this.contain =contain;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public int getImgid() {
        return imgid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }

    public String getContain() {
        return contain;
    }
}
