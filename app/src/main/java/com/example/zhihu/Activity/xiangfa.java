package com.example.zhihu.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.zhihu.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.xiangfaViewpager2.Image;
import Adapter.xiangfaViewpager2.xiangfaviewpager2Adapter;

public class xiangfa extends AppCompatActivity {
private List<Image>mList = new ArrayList<>();
private List<Integer>picture = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_xiangfa);
        TextView textView = findViewById(R.id.xiangfa_text1);
        Intent intent = getIntent();
        String name = intent.getStringExtra("data");

        Log.d("1234567",name);
        if(name.equals("不愧是清华大佬,把Python整理成了漫画")){
            textView.setText("不愧是清华大佬，把Python整理成了漫画书大家好！我是子明！\n" +
                    "今天给大家分享一本由清华大佬整理的Python入门书《看漫画学Python》，这本书主要以漫画的形式讲解，通俗易懂，生动有趣。\n" +
                    "对于想学习编程的零基础外行小白、计算机相关专业大学生、正在从事软件开发的职场人，都很适合阅读和学习。\n" +
                    "内容总共16章，每一章都安排了“动动手”和“练一练”环节，对提升上手能力也很有帮助，把Python变成漫画书后，学习变的有趣又没那么难学了，对小白入门真的很友好\n");
        init();
            ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
            xiangfaviewpager2Adapter adapter = new xiangfaviewpager2Adapter(mList);
            viewPager2.setAdapter(adapter);
        }
        else if(name.equals("歌尔算是苹果踢出的第二大体量供应商,第一个是欧菲光")){
            textView.setText("歌尔算是苹果踢出的第2个大体量供应商，第1个是欧菲光。\n" +
                    "\n" +
                    "欧菲光是苹果的摄像头模组供应商，是苹果上百亿的大订单，也由此称为全球出货量第一的摄像头模组供应商。\n" +
                    "\n" +
                    "从盈利9个亿，到亏损接近19亿，至于为什么把欧菲光踢出，其实事态比歌尔事件发展得要更为缓慢。从一开始传出欧菲光被踢出传闻，但公司还发布声明否定了，离坐实还有一段时间。歌尔这回直接就是突然爆出一个大瓜，凉凉得非常迅速。\n" +
                    "\n" +
                    "为此我也专门去各大社区论坛看了看关于歌尔生产的AirPods反馈，确实有不少问题，但这些问题要说真正影响使用体验，对于一贯推崇中庸文化的国内消费者，倒也不是那么严重。\n" +
                    "\n" +
                    "可是苹果的质量管理原则可不是“差不多”，想要抱苹果大腿的厂商多的是，老厂商一旦犯错，无可弥补。\n");
            init1();
            ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
            xiangfaviewpager2Adapter adapter = new xiangfaviewpager2Adapter(mList);
            viewPager2.setAdapter(adapter);
        }
        else if(name.equals("大家觉得乔布斯和库克谁更牛?口说无凭,我们拿数据说话")){
            textView.setText("大家觉得乔布斯和库克谁更牛？\n" +
                    "口说无凭，我们拿数据说话。\n" +
                    "乔布斯执掌下的苹果，巅峰年营收达3658亿美元，当年，乔布斯过世以后，很多人都说苹果在走下坡路，但是让人没有想到的是，在库克的带领下，苹果不仅保住了手机行业的头把交椅，而且是越坐越稳，所以从商业的角度上看，库克是成功的。\n" +
                    "不过库克的苹果也失去了一些灵魂，比如让不少果粉至今都接受不了的刘海设计，相信如果库克在世的话，这个玩意儿一定会被丢进垃圾桶里面，还有就是臭名昭著的苹果消失术，比如iPhone7取消了耳机孔，iPhone X取消了指纹识别，iPhone12取消了附赠的充电头，iPhone13取消了包装塑封膜。库克为了一点利益，就可以不顾iPhone的体验。\n" +
                    "总结一下，库克是更成功的商人，乔布斯是更出色的产品经理。\n" +
                    "大家觉得乔布斯和库克谁更厉害呢？\n");
            init2();
            ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
            xiangfaviewpager2Adapter adapter = new xiangfaviewpager2Adapter(mList);
            viewPager2.setAdapter(adapter);
        }
        else if(name.equals("安卓系统和iOS系统区别，有这么大吗"+
                "请不要骗我")){
            textView.setText("安卓系统和iOS系统区别，有这么大吗\n" +
                    "请不要骗我\n");
            init3();
            ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
            xiangfaviewpager2Adapter adapter = new xiangfaviewpager2Adapter(mList);
            viewPager2.setAdapter(adapter);
        }
        else if(name.equals("苹果到了14这代已经彻底摆烂了")){
            textView.setText("苹果到了14这代已经彻底摆烂了……\n" +
                    "\n" +
                    "12最起码还变了个边框\n" +
                    "到了14这代外观都懒得变了……\n" +
                    "设计师已经摆烂了\n");
            init4();
            ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
            xiangfaviewpager2Adapter adapter = new xiangfaviewpager2Adapter(mList);
            viewPager2.setAdapter(adapter);
        }
    }
    private void init(){

        picture.add(R.mipmap.xiangfa_image_0);
        picture.add(R.mipmap.xiangfa_image_5);
        picture.add(R.mipmap.xiangfa_image_6);
        for(int i = 0;i<3;i++){
            Image image = new Image();
            image.image11 = picture.get(i);
            mList.add(image);
        }
    }
    private  void init1(){
        picture.add(R.mipmap.xiangfa_image_1);
        for(int i = 0;i<1;i++){
            Image image = new Image();
            image.image11 = picture.get(i);
            mList.add(image);
        }
    }
    private  void init2(){
        picture.add(R.mipmap.xiangfa_image_2);
        for(int i = 0;i<1;i++){
            Image image = new Image();
            image.image11 = picture.get(i);
            mList.add(image);
        }
    }
    private void init3(){
        picture.add(R.mipmap.xiangfa_image_3);
        for(int i = 0;i<1;i++){
            Image image = new Image();
            image.image11 = picture.get(i);
            mList.add(image);
        }
    }
    private void init4(){
        picture.add(R.mipmap.xiangfa_image_4);
        for(int i = 0;i<1;i++){
            Image image = new Image();
            image.image11 = picture.get(i);
            mList.add(image);
        }
    }
}