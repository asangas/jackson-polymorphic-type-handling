package com.github.asangas.jacksonpoc.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.asangas.jacksonpoc.model.Assets;
import com.github.asangas.jacksonpoc.model.PDFAsset;
import com.github.asangas.jacksonpoc.model.UnknownFormatAsset;
import com.github.asangas.jacksonpoc.model.YoutubeVideoAsset;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssetTest {
    @Test
    public void testSerialise() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Assets assets = new Assets();
        assets.add(new PDFAsset("Tech Warranty", "/path/to/warranty.pdf"));
        assets.add(new YoutubeVideoAsset("Installation", "/path/to/thumbnail.pdf", "x2323jih2983y23"));

        String json = objectMapper.writeValueAsString(assets);
        assertThat(json, is("{\"assets\":["
                + "{\"format\":\"PDF\",\"title\":\"Tech Warranty\",\"path\":\"/path/to/warranty.pdf\"},"
                + "{\"format\":\"YOUTUBE_VIDEO\",\"title\":\"Installation\",\"thumbnail\":\"/path/to/thumbnail.pdf\",\"youtubeVideoId\":\"x2323jih2983y23\"}"
                + "]}"));
    }

    @Test
    public void testDeSerialise() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String json = "{\"assets\":["
                + "{\"title\":\"Tech Warranty\",\"format\":\"PDF\",\"path\":\"/path/to/warranty.pdf\"},"
                + "{\"title\":\"Installation\",\"format\":\"YOUTUBE_VIDEO\",\"thumbnail\":\"/path/to/thumbnail.pdf\",\"youtubeVideoId\":\"x2323jih2983y23\"},"
                + "{\"title\":\"Installation\",\"format\":\"CAD\", \"path\": \"/path/to/cad.dwg\"}"
                + "]}";

        Assets assets = objectMapper.readValue(json, Assets.class);
        assertThat(assets.assets.size(), is(3));
        assertThat(assets.assets.get(0) instanceof PDFAsset, is(true));
        assertThat(((PDFAsset)assets.assets.get(0)).path, is("/path/to/warranty.pdf"));

        assertThat(assets.assets.get(1) instanceof YoutubeVideoAsset, is(true));
        assertThat(((YoutubeVideoAsset)assets.assets.get(1)).thumbnail, is("/path/to/thumbnail.pdf"));
        assertThat(((YoutubeVideoAsset)assets.assets.get(1)).youtubeVideoId, is("x2323jih2983y23"));

        assertThat(assets.assets.get(2) instanceof UnknownFormatAsset, is(true));
    }
}