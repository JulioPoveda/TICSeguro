package com.japg.ticseguro.model;

public class Picture
{
    private String picture;
    private String userName;
    private String time;
    private String like_number = "0 días";

    public Picture(String picture, String userName, String time, String like_number)
    {
        this.picture = picture;
        this.userName = userName;
        this.time = time;
        this.like_number = like_number;
    }

    public String getPicture()
    {
        return picture;
    }

    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getLikeNumber()
    {
        return like_number;
    }

    public void setLikeNumber(String like_number)
    {
        this.like_number = like_number;
    }
}
