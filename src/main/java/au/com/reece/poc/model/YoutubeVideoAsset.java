package au.com.reece.poc.model;

public class YoutubeVideoAsset extends Asset {
    public String thumbnail;
    public String youtubeVideoId;

    public YoutubeVideoAsset() {
    }

    public YoutubeVideoAsset(String title, String thumbnail, String youtubeVideoId) {
        super(title);
        this.thumbnail = thumbnail;
        this.youtubeVideoId = youtubeVideoId;
    }
}
