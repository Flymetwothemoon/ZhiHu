package api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoriesDTO {
    /**
     * image_hue : 0x3b6436
     * title : 如果将 10 个蛹切开，并混合全部液体，还有可能发育出蝴蝶吗？
     * url : https://daily.zhihu.com/story/9754970
     * hint : 久见菌 · 3 分钟阅读
     * ga_prefix : 111107
     * images : ["https://pic1.zhimg.com/v2-55356fd33f3156469a088918e00af1dd.jpg?source=8673f162"]
     * type : 0
     * id : 9754970
     */

    @SerializedName("image_hue")
    public String imageHue;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;
    @SerializedName("hint")
    public String hint;
    @SerializedName("ga_prefix")
    public String gaPrefix;
    @SerializedName("type")
    public Integer type;
    @SerializedName("id")
    public Integer id;
    @SerializedName("images")
    public List<String> images;
}
