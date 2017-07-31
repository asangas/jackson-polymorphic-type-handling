package au.com.reece.poc.model;

public abstract class FileAsset extends Asset {
    public String path;

    public FileAsset() {
    }

    public FileAsset(String title, String path) {
        super(title);
        this.path = path;
    }
}
