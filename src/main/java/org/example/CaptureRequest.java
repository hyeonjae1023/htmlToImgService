package org.example;

public class CaptureRequest {
    private String sourceUrl;
    private Integer width;
    private Integer height;
    private Integer x;
    private Integer y;

    public String getSourceUrl() {
        return sourceUrl;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public CaptureRequest(String sourceUrl, Integer width, Integer height, Integer x, Integer y) {
        this.sourceUrl = sourceUrl;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }
}
