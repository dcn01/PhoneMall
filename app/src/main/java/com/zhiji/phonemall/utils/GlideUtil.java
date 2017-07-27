package com.zhiji.phonemall.utils;

/**
 * 文件名：GlideUtil
 * 创建者：LLJ
 * 创建时间：2017/7/27
 * 描述：Glide封装
 */

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;

public class GlideUtil {

  /**
   * Glide特点
   * 使用简单，gradle中增加如下配置：compile 'com.github.bumptech.glide:glide:3.7.0'
   * 可配置度高，自适应程度高
   * 支持常见图片格式 Jpg png gif webp
   * 支持多种数据源：网络、本地、资源、Assets 等
   * Glide加载图片的大小默认是和ImageView的大小是一致的
   * 高效缓存策略：支持Memory和Disk图片缓存 默认Bitmap格式采用RGB_565内存使用至少减少一半
   * 生命周期集成：根据Activity/Fragment生命周期自动管理请求
   * 高效处理Bitmap：使用Bitmap Pool使Bitmap复用，主动调用recycle回收需要回收的Bitmap，减小系统回收压力
   * 这里默认支持Context，Glide支持Context,Activity,Fragment，FragmentActivity
   */

  //默认加载
  public static void showImage(Context context, String path, ImageView imageView) {
    Glide.with(context).load(path).into(imageView);
  }

  //加载指定大小
  public static void showImageSize(Context context, String path, int width, int height,
      ImageView imageView) {
    Glide.with(context).load(path).override(width, height).into(imageView);
  }

  //设置加载中以及加载失败图片
  public static void showImageLoading(Context context, String path, ImageView imageView,
      int loadingImage, int errorImage) {
    Glide.with(context).load(path).placeholder(loadingImage).error(errorImage).into(imageView);
  }

  //设置加载中以及加载失败图片并且指定大小
  public static void showImageLoadingSize(Context context, String path, int width, int height,
      ImageView imageView, int loadingImage, int errorImageView) {
    Glide.with(context).load(path).override(width, height).placeholder(loadingImage)
        .error(errorImageView).into(imageView);
  }

  /**
   * 加载圆角图片
   */
  public static void showRoundImage(Context context, ImageView imageView, String imageUrl,
      int loadingImage, int errorImage) {
    Glide.with(context)
        .load(imageUrl)
        .placeholder(loadingImage)
        .error(errorImage)
        .transform(new GlideRoundTransform(context))
        .into(imageView);
  }

  /**
   * 加载圆形图片
   */
  public static void loadCircleImage(Context context, ImageView imageView, String imageUrl,
      int loadingImage, int errorImageView) {
    Glide.with(context)
        .load(imageUrl)
        .placeholder(loadingImage)
        .error(errorImageView)
        .transform(new GlideCircleTransform(context))
        .into(imageView);
  }

  //设置跳过内存缓存
  public static void showImageSkipMemory(Context context, String path, ImageView imageView) {
    Glide.with(context).load(path).skipMemoryCache(true).into(imageView);
  }

  //设置下载优先级
  public static void showImagePriority(Context context, String path, ImageView imageView) {
    Glide.with(context).load(path).priority(Priority.NORMAL).into(imageView);
  }

  /**
   * 策略解说：
   * <p>
   * all:缓存源资源和转换后的资源
   * <p>
   * none:不作任何磁盘缓存
   * <p>
   * source:缓存源资源
   * <p>
   * result：缓存转换后的资源  默认的缓存策略
   */

  //设置缓存策略
  public static void showImageCacheStrategy(Context context, String path, ImageView imageView) {
    Glide.with(context).load(path).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
  }

  /**
   * api也提供了几个常用的动画：比如crossFade()
   */

  //设置加载动画
  public static void showImageAnim(Context context, String path, int anim,
      ImageView imageView) {
    Glide.with(context).load(path).animate(anim).into(imageView);
  }

  /**
   * 会先加载缩略图,在加载原图。
   */

  //设置缩略图支持 thumbnailSize参数代表缩略比例，比如 0.1f 代表缩略到10%
  public static void showImageThumbnail(Context context, String path, float thumbnailSize,
      ImageView imageView) {
    Glide.with(context).load(path).thumbnail(thumbnailSize).into(imageView);
  }

  /**
   * api提供了比如：centerCrop()、fitCenter()等
   */

  //设置动态转换
  public static void showImageCrop(Context context, String path, ImageView imageView) {
    Glide.with(context).load(path).centerCrop().into(imageView);
  }

  //设置动态GIF加载方式
  public static void showImageDynamicGif(Context context, String path, ImageView imageView) {
    Glide.with(context).load(path).asGif().into(imageView);
  }

  //设置静态GIF加载方式
  public static void showImageStaticGif(Context context, String path, ImageView imageView) {
    Glide.with(context).load(path).asBitmap().into(imageView);
  }

  //设置监听的用处 可以用于监控请求发生错误来源，以及图片来源 是内存还是磁盘

  //设置监听请求接口
  public static void showImageListener(Context context, String path, ImageView imageView,
      RequestListener<String, GlideDrawable> requstlistener) {
    Glide.with(context).load(path).listener(requstlistener).into(imageView);
  }

  //项目中有很多需要先下载图片然后再做一些合成的功能，比如项目中出现的图文混排

  //设置要加载的内容
  public static void showImageContent(Context context, String path,
      SimpleTarget<GlideDrawable> simpleTarget) {
    Glide.with(context).load(path).centerCrop().into(simpleTarget);
  }

  //清理磁盘缓存
  public static void GuideClearDiskCache(Context context) {
    //清理磁盘缓存 需要在子线程中执行
    Glide.get(context).clearDiskCache();
  }

  //清理内存缓存
  public static void GuideClearMemory(Context context) {
    //清理内存缓存  可以在UI主线程中进行
    Glide.get(context).clearMemory();
  }

  /**
   * 自定义的相关转换---->圆角图片 构造函数中第二个参数定义半径
   */
  public static class GlideRoundTransform extends BitmapTransformation {

    private float radius = 0f;//可以指定圆角半径

    public GlideRoundTransform(Context context) {
      this(context, 4);
    }

    public GlideRoundTransform(Context context, int dp) {
      super(context);
      this.radius = Resources.getSystem().getDisplayMetrics().density * dp;
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
      return roundCrop(pool, toTransform);
    }

    private Bitmap roundCrop(BitmapPool pool, Bitmap source) {
      if (source == null) {
        return null;
      }

      Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
      if (result == null) {
        result = Bitmap
            .createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
      }
      Canvas canvas = new Canvas(result);
      Paint paint = new Paint();
      paint.setShader(
          new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
      paint.setAntiAlias(true);
      RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
      canvas.drawRoundRect(rectF, radius, radius, paint);
      return result;
    }

    @Override
    public String getId() {
      return getClass().getName() + Math.round(radius);
    }
  }

  /**
   * 自定义的相关转换---->圆形图片
   */
  public static class GlideCircleTransform extends BitmapTransformation {

    public GlideCircleTransform(Context context) {
      super(context);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
      return circleCrop(pool, toTransform);
    }

    private static Bitmap circleCrop(BitmapPool pool, Bitmap source) {
      if (source == null) {
        return null;
      }

      int size = Math.min(source.getWidth(), source.getHeight());
      int x = (source.getWidth() - size) / 2;
      int y = (source.getHeight() - size) / 2;

      Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);

      Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
      if (result == null) {
        result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
      }

      Canvas canvas = new Canvas(result);
      Paint paint = new Paint();
      paint.setShader(
          new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
      paint.setAntiAlias(true);
      float r = size / 2f;
      canvas.drawCircle(r, r, r, paint);
      return result;
    }

    @Override
    public String getId() {
      return getClass().getName();
    }
  }

}