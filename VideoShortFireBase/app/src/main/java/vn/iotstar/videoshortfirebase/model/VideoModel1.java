package vn.iotstar.videoshortfirebase.model;

import java.io.Serializable;

public class VideoModel1 implements Serializable {
    private String desc;
    private String title;
    private String url;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public VideoModel1() {

    }
}
