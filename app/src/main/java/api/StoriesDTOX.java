package api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoriesDTOX {
    /**
     * image_hue : 0x7d97b3
     * title : 瞎扯 · 如何正确地吐槽
     * url : https://daily.zhihu.com/story/9754911
     * date : 20221109
     * display_date : 11 月 9 日
     * images : ["https://picx1.zhimg.com/v2-151711f4dd2196487d8e27b29d3d75ba.jpg?source=8673f162"]
     * id : 9754911
     */

    @SerializedName("image_hue")
    public String imageHue;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;
    @SerializedName("date")
    public String date;
    @SerializedName("display_date")
    public String displayDate;
    @SerializedName("id")
    public Integer id;
    @SerializedName("images")
    public List<String> images;
}
