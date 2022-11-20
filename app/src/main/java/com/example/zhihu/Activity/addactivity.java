package com.example.zhihu.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zhihu.R;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

public class addactivity extends AppCompatActivity {
    public static final int CHOOSE_PHOTO = 1;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_addactivity);
        if (ActivityCompat.checkSelfPermission(addactivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(addactivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }





        imageView = (ImageView) findViewById(R.id.picture);
        openSysAlbum();
//        if(ContextCompat.checkSelfPermission(addactivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(addactivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
//        }
//        else{
//            openAlbum();
//        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        handleImageOnKitKat(data);
    }
    public static int ALBUM_RESULT_CODE = 0x999 ;
    private void openSysAlbum() {
        Intent albumIntent = new Intent(Intent.ACTION_PICK);
        albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(albumIntent, ALBUM_RESULT_CODE);
    }
    @TargetApi(value = 19)
    private void handleImageOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this, uri)) {
            // 如果是document类型的Uri，则通过document id处理
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1];
                // 解析出数字格式的id
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content: //downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            // 如果是content类型的Uri，则使用普通方式处理
            imagePath = getImagePath(uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            // 如果是file类型的Uri，直接获取图片路径即可
            imagePath = uri.getPath();
        }
        // 根据图片路径显示图片
        displayImage(imagePath);
        System.out.println(imagePath);
    }

    /**获取图片的路径*/
    @SuppressLint("Range")
    private String getImagePath(Uri uri, String selection) {
        String path = null;
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if(cursor != null){

            if(cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }


    /**展示图片*/
    private void displayImage(String imagePath) {
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        imageView.setImageBitmap(bitmap);
    }



//
//    private void openAlbum() {
//        Intent intent = new Intent("android.intent.action.GET_CONTENT");
//        intent.setType("image/*");
//        startActivityForResult(intent,CHOOSE_PHOTO);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode){
//            case 1:
//                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
//                    openAlbum();
//                }
//                else{
//                    Toast.makeText(this,"You denied the permission",Toast.LENGTH_SHORT).show();
//                }
//                break;
//            default:
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode){
//            case  CHOOSE_PHOTO:
//                    if(resultCode==RESULT_OK){
//                        if(Build.VERSION.SDK_INT>=19){
//                            handleImageOnKitKat(data);
//                            Log.d("GOOD",data.toString());
//                        }
//                        else{
//                        }
//                        break;
//                    }
//            default:
//                break;
//        }
//    }

    @Override
    public void finish() {
        super.finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //屏幕动画弹入效果切换，调用anim文件夹中创建的enteralpha（进入动画）和exitalpha（淡出动画）两个动画（注意：两个xml文件命名不能有大写字母）
        //如果想定义其他动画效果，只需要改变enteralpha和exitalpha两个文件
        this.overridePendingTransition(R.anim.enteralpha, R.anim.exitalpha);
    }
//    @TargetApi(19)
//    private void handleImageOnKitKat(Intent data){
//        String imagePath = null;
//        Uri uri = data.getData();
//        if(DocumentsContract.isDocumentUri(this,uri)){
//            String docId = DocumentsContract.getDocumentId(uri);
//            if("com.android.providers.media.documents".equals(uri.getAuthority())){
//                Log.d("GOOD","1");
//                String id =docId.split(":")[1];
//                String selection = MediaStore.Images.Media._ID +"="+id;
//                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
//
//            }else if("com.android.providers.downloads.documents".equals(uri.getAuthority())){
//                Log.d("GOOD","2");
//                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),Long.valueOf(docId));
//                imagePath = getImagePath(contentUri,null);
//            }
//        }
//        else if("content".equalsIgnoreCase(uri.getScheme())){
//            imagePath = getImagePath(uri,null);
//            Log.d("GOOD","3");
//        }
//        else if("file".equalsIgnoreCase(uri.getScheme())){
//            imagePath = uri.getPath();
//            Log.d("GOOD","4");
//        }
//        displayImage(imagePath);
//    }
//
//    private void displayImage(String imagePath) {
//        if(imagePath!=null){
//            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
//            picture.setImageBitmap(bitmap);
//        }
//        else{
//            Toast.makeText(this,"failed to get image",Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @SuppressLint("Range")
//    private String getImagePath(Uri externalContentUri, String selection) {
//        String path = null;
//        Cursor cursor = getContentResolver().query(externalContentUri,null,selection,null,null);
//        if(cursor!=null){
//
//            if(cursor.moveToFirst()){
//                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
//                Log.d("GOOD","HI"+path);
//            }
//            cursor.close();
//        }
//
//        return path;
//    }
}