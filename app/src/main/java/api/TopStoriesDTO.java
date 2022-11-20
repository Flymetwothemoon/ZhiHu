package api;

import com.google.gson.annotations.SerializedName;

public class TopStoriesDTO {
    /**
     * image_hue : 0x3b6436
     * hint : 作者 / 久见菌
     * url : https://daily.zhihu.com/story/9754970
     * image : https://pic1.zhimg.com/v2-9441e70f7bda9085f1c82d182ed463e9.jpg?source=8673f162
     * title : 如果将 10 个蛹切开，并混合全部液体，还有可能发育出蝴蝶吗？
     * ga_prefix : 111107
     * type : 0
     * id : 9754970
     */

    @SerializedName("image_hue")
    public String imageHue;
    @SerializedName("hint")
    public String hint;
    @SerializedName("url")
    public String url;
    @SerializedName("image")
    public String image;
    @SerializedName("title")
    public String title;
    @SerializedName("ga_prefix")
    public String gaPrefix;
    @SerializedName("type")
    public Integer type;
    @SerializedName("id")
    public Integer id;
}
