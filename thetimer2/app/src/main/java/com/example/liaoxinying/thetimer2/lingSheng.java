package com.example.liaoxinying.thetimer2;

public class lingSheng {
    private String lingshengName;
    lingSheng(){
        this.lingshengName="linsheng2.mp3";
    }
    lingSheng(String name){
        this.lingshengName=name;
    }

    void setLingshengName(String lingshengName1){
        lingshengName=lingshengName1;
    }

    private String getLingShengName(){
        return lingshengName;
    }
}
