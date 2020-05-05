package simon.tsuki;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import simon.tuke.Tuke;
import simon.tsuki.Other.RoundBitmapEditor;


public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        /*可不写*/CommonEngine.MemoryCache.setMaxCache(10000);//设置最大占用内存
           /*按需求使用*/  Tuke.init(this);//Tsuki内部使用Tuke完成磁盘缓存
     /*可不写*/  Tsuki.setMaxThreadNum(5);//设置最大并发请求数，默认为3
        ImageView img=findViewById(R.id.mainImageView1);
        Tsuki.load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588610877519&di=360d0dfb09f4a57e4fa0b9273ed86eeb&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fbaike%2Fpic%2Fitem%2F7aec54e736d12f2e8bccddef45c2d56284356877.jpg")
     /*可不写*/   .setEdit(new RoundBitmapEditor(15))//图片处理，默认为把图片缩放为控件的宽高，这里提供了RoundBitmapEditor，可以进行圆角处理
     /*可不写*/  .setEngine(new CommonEngine(true,true))//设置图片加载引擎，默认使用的是CommonEngine，磁盘缓存，也可传入false关闭磁盘缓存
     /*可不写*/  .setErrorBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher))//设置错误时的占位图，默认为透明
        .setImg(img)
        .start();
        /*
        实现Tsuki.Editor接口，可以自定义图片处理
        实现Tsuki.Engine接口，可以自定义图片加载
        */
    }
}
