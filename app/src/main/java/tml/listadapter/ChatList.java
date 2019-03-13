package tml.listadapter;

public class ChatList {
    private String title;
    private String subtitle;
    private String date;
    private String imgURL;

    public ChatList(String title, String subtitle,  String date, String imgURL) {
        this.title = title;
        this.subtitle = subtitle;
        this.date = date;
        this.imgURL = imgURL;
    }

    public ChatList(String title, String subtitle,  String date) {
        this.title = title;
        this.subtitle = subtitle;
        this.date = date;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
