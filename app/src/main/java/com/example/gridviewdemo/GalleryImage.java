package com.example.gridviewdemo;

public class GalleryImage {
    private int ImgId;
    private String ImgName;
    private int ImgPic;

    public int getImgId() {
        return ImgId;
    }

    public void setImgId(int imgId) {
        ImgId = imgId;
    }

    public String getImgName() {
        return ImgName;
    }

    public void setImgName(String imgName) {
        ImgName = imgName;
    }

    public int getImgPic() {
        return ImgPic;
    }

    public void setImgPic(int imgPic) {
        ImgPic = imgPic;
    }

    public GalleryImage(int imgId, String imgName, int imgPic) {
        ImgId = imgId;
        ImgName = imgName;
        ImgPic = imgPic;
    }
}
