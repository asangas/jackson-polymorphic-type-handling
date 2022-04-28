package com.github.asangas.jacksonpoc.model;

import java.util.ArrayList;
import java.util.List;

public class Assets {

    public List<Asset> assets;

    public Assets() {
        this.assets = new ArrayList<>();
    }

    public void add(Asset asset) {
        this.assets.add(asset);
    }
}
