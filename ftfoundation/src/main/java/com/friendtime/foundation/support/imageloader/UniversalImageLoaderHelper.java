package com.friendtime.foundation.support.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.friendtime.foundation.support.imageloader.cache.disc.naming.Md5FileNameGenerator;
import com.friendtime.foundation.support.imageloader.core.DisplayImageOptions;
import com.friendtime.foundation.support.imageloader.core.ImageLoader;
import com.friendtime.foundation.support.imageloader.core.ImageLoaderConfiguration;
import com.friendtime.foundation.support.imageloader.core.assist.QueueProcessingType;
import com.friendtime.foundation.support.imageloader.core.listener.ImageLoadingListener;

/**
 * 
 * @author xuxiaobin
 * Universal-Image-Loader工具类
 *
 */
public class UniversalImageLoaderHelper {
	
	private final String TAG = UniversalImageLoaderHelper.class.getSimpleName();

	private static Object block = new Object();
	private static UniversalImageLoaderHelper instance;
	private final static int Size_Max = 1024;
	
	private ImageLoader imageLoader = ImageLoader.getInstance();
	private boolean init;
	
	private UniversalImageLoaderHelper() {

	}
	
	public static UniversalImageLoaderHelper getDefault() {
		if (instance == null) {
			synchronized (block) {
				if (instance == null) {
					instance = new UniversalImageLoaderHelper();
				}
			}
		}
		return instance;
	}
	
	/**
	 * 初始化缓存
	 * @param context
	 */
	public void init(Context context) {
		if (!init) {
			init = true;
			ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
			.threadPriority(Thread.NORM_PRIORITY - 2)
			.denyCacheImageMultipleSizesInMemory()
			.diskCacheFileNameGenerator(new Md5FileNameGenerator())
			.diskCacheSize(50 * Size_Max * Size_Max) // 50 Mb
			.tasksProcessingOrder(QueueProcessingType.LIFO)
			.writeDebugLogs() // Remove for release app
			.build();
			// Initialize ImageLoader with configuration.
			ImageLoader.getInstance().init(config);
		}
	}

	public boolean isInit() {
		return init;
	}
	
	/**
	 * 动态加载图片 (Android-Universal-Image-Loader v1.9.3)
	 * @param context
	 * @param imageView
	 * @param imageUrl
	 */
	public final void loadImageUrl(final Context context, ImageView imageView, String imageUrl,
			ImageLoadingListener listener) {
		loadImageUrl(context, imageView, imageUrl, listener, 0);
	}

	public final void loadImageUrl(final Context context, ImageView imageView, String imageUrl,
			ImageLoadingListener listener, int roundRect) {
		loadImageUrl(context, imageView, imageUrl, listener, roundRect, false);
	}
	
	/**
	 * 
	 * 动态加载图片 (Android-Universal-Image-Loader v1.9.3)
	 * @param context
	 * @param imageView
	 * @param imageUrl
	 * @param listener
	 * @param roundRect > 0 则图片做圆角处理  
	 */
	public final void loadImageUrl(final Context context, ImageView imageView, String imageUrl,
			ImageLoadingListener listener, int roundRect, boolean needReDownload) {
		if (!init) {
			throw new IllegalAccessError("You need init befor load image!");
		}
		DisplayImageOptions options = null;
		if (roundRect > 0) {
			options = new DisplayImageOptions.Builder(roundRect)
//			.showImageOnLoading(0)
//			.showImageForEmptyUri(0)
//			.showImageOnFail(0)
			.cacheInMemory(true)
			.cacheOnDisk(true)
			.considerExifParams(true)
			.bitmapConfig(Bitmap.Config.RGB_565)
			.build();
		} else {
			options = new DisplayImageOptions.Builder()
//			.showImageOnLoading(0)
//			.showImageForEmptyUri(0)
//			.showImageOnFail(0)
			.cacheInMemory(true)
			.cacheOnDisk(true)
			.considerExifParams(true)
			.bitmapConfig(Bitmap.Config.RGB_565)
			.build();
		}
		
		//LogProxy.i(TAG, "image url = " + imageUrl);
		try {
			imageLoader.displayImage(imageUrl, imageView, options, listener, needReDownload);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void cancelLoadingImage(ImageView imageView) {
		imageLoader.cancelDisplayTask(imageView);
	}

	public void clearCache() {
		imageLoader.clearDiskCache();
		imageLoader.clearMemoryCache();
	}

}
