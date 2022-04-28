package com.github.asangas.jacksonpoc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "format", defaultImpl = UnknownFormatAsset.class)
@JsonSubTypes( {
        @JsonSubTypes.Type(value = PDFAsset.class, name = "PDF"),
        @JsonSubTypes.Type(value = YoutubeVideoAsset.class, name = "YOUTUBE_VIDEO"),
})
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Asset {
    public String title;

    public Asset() {
    }

    public Asset(String title) {
        this.title = title;
    }
}
