package dk.itu.pervasive.mobile.utils;

import java.io.ByteArrayOutputStream;

import android.R.raw;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import dk.itu.pervasive.mobile.data.DataManager;
import dk.itu.pervasive.mobile.utils.dataStructure.URLInformation;

/**
 * @author Tony Beltramelli www.tonybeltramelli.com
 */
public class UString
{
	public static URLInformation getUrlInformation(String rawUrl)
	{
		if(rawUrl == null || rawUrl == "") return null;
		
		String ip = rawUrl.substring(0, rawUrl.indexOf(":"));
		int port = Integer.valueOf(rawUrl.substring(rawUrl.indexOf(":") + 1, rawUrl.indexOf("/") != -1 ? rawUrl.indexOf("/") : rawUrl.length()));
		
		return new URLInformation(ip, port);
	}
	
	public static String imageToBase64(String imagePath)
	{
		Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
		bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
		byte[] byteArray = byteArrayOutputStream.toByteArray();
		
		return Base64.encodeToString(byteArray, Base64.DEFAULT);
	}
}