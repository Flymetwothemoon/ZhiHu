package api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class api {

    /**
     * date : 20221111
     * stories : [{"image_hue":"0x3b6436","title":"如果将 10 个蛹切开，并混合全部液体，还有可能发育出蝴蝶吗？","url":"https://daily.zhihu.com/story/9754970","hint":"久见菌 · 3 分钟阅读","ga_prefix":"111107","images":["https://pic1.zhimg.com/v2-55356fd33f3156469a088918e00af1dd.jpg?source=8673f162"],"type":0,"id":9754970},{"image_hue":"0xb3a87d","title":"有哪些古代很重要的地理通道现在废弃了？是什么原因？","url":"https://daily.zhihu.com/story/9754962","hint":"李雷 · 1 分钟阅读","ga_prefix":"111107","images":["https://picd.zhimg.com/v2-6f25e430461f8716def7b38e03d20fac.jpg?source=8673f162"],"type":0,"id":9754962},{"image_hue":"0xb36854","title":"如果原始人进化的过程中，石头被用光了，是不是他们就结束了石器时代？","url":"https://daily.zhihu.com/story/9754973","hint":"螺旋真理 · 1 分钟阅读","ga_prefix":"111107","images":["https://picx1.zhimg.com/v2-3bd8f00eab9775c0fccdaa2348c474fb.jpg?source=8673f162"],"type":0,"id":9754973},{"image_hue":"0xa0ad5c","title":"奶牛为什么能一直产奶？","url":"https://daily.zhihu.com/story/9754982","hint":"郁练级 · 3 分钟阅读","ga_prefix":"111107","images":["https://picd.zhimg.com/v2-6c93d4690f860c08238e9cc95bedaea2.jpg?source=8673f162"],"type":0,"id":9754982},{"image_hue":"0x110b0f","title":"把木星的氢气和氦气全部加到太阳上，太阳的寿命会变长还是变短？","url":"https://daily.zhihu.com/story/9754988","hint":"太空僧 · 1 分钟阅读","ga_prefix":"111107","images":["https://picx1.zhimg.com/v2-2616eacebb2806c261b72b0b0a148028.jpg?source=8673f162"],"type":0,"id":9754988},{"image_hue":"0xb3897d","title":"瞎扯·如何正确地吐槽","url":"https://daily.zhihu.com/story/9754989","hint":"知乎日报 · 1 分钟阅读","ga_prefix":"111106","images":["https://pic1.zhimg.com/v2-da7828898e2afecb1767830527ccc424.jpg?source=8673f162"],"type":0,"id":9754989}]
     * top_stories : [{"image_hue":"0x3b6436","hint":"作者 / 久见菌","url":"https://daily.zhihu.com/story/9754970","image":"https://pic1.zhimg.com/v2-9441e70f7bda9085f1c82d182ed463e9.jpg?source=8673f162","title":"如果将 10 个蛹切开，并混合全部液体，还有可能发育出蝴蝶吗？","ga_prefix":"111107","type":0,"id":9754970},{"image_hue":"0xb3b3b3","hint":"作者 / 张益唐","url":"https://daily.zhihu.com/story/9754990","image":"https://picd.zhimg.com/v2-a526a04790d325e8966b4f5579762686.jpg?source=8673f162","title":"数学家张益唐攻克 Landau-Siegel 零点猜想相关论文发布，如何评价这一研究的成果及意义？","ga_prefix":"111017","type":0,"id":9754990},{"image_hue":"0x574738","hint":"作者 / 090811mario","url":"https://daily.zhihu.com/story/9754919","image":"https://pic1.zhimg.com/v2-e16c2f6fca61f42ea9d1034fc6c94530.jpg?source=8673f162","title":"北极出现过恐龙吗？","ga_prefix":"111007","type":0,"id":9754919},{"image_hue":"0x7d84b3","hint":"作者 / Victor Yeh","url":"https://daily.zhihu.com/story/9754884","image":"https://pica.zhimg.com/v2-edace03383226dd42950792a6156c242.jpg?source=8673f162","title":"为什么不能说 20℃ 是 10℃ 的两倍？","ga_prefix":"110907","type":0,"id":9754884},{"image_hue":"0xac7db3","hint":"作者 / 夏莫","url":"https://daily.zhihu.com/story/9754861","image":"https://picx1.zhimg.com/v2-6266e5506fda049b79ef6ca785e5818d.jpg?source=8673f162","title":"诺贝尔遗产只有 3100 万瑞典克朗，奖金怎么还没用完？","ga_prefix":"110807","type":0,"id":9754861}]
     */

    @SerializedName("date")
    public String date;
    @SerializedName("stories")
    public List<StoriesDTO> stories;
    @SerializedName("top_stories")
    public List<TopStoriesDTO> topStories;
}
