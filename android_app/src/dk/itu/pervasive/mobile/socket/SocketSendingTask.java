package dk.itu.pervasive.mobile.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import android.os.AsyncTask;
import android.util.Log;

import com.eclipsesource.json.JsonObject;

import dk.itu.pervasive.mobile.utils.Constants;

/**
 * @author Tony Beltramelli www.tonybeltramelli.com
 */
public class SocketSendingTask extends AsyncTask<String, Void, Void>
{
	public static String MESSAGE = "message";
	public static String IMAGE = "image";
	//
	private RequestDelegate _delegate;
	private Socket _socket;
	
	public SocketSendingTask(RequestDelegate delegate, Socket socket)
	{
		_delegate = delegate;
		_socket = socket;
	}
	
	@Override
	protected Void doInBackground(String... args)
	{
		if (args[0] == SocketSendingTask.MESSAGE)
		{
			_sendMessage(args[1]);
		} else if (args[0] == SocketSendingTask.IMAGE)
		{
			_sendImage(args[1]);
		}
		
		return null;
	}
	
	private void _sendImage(String imagePath)
	{
		Log.wtf("_sendImage", imagePath);
		
		try
		{
			File file = new File(imagePath);
	        
	        long fileSize = file.length();
	        if (fileSize > Integer.MAX_VALUE) {
	        	Log.wtf("_sendImage", "File is too large.");
	        }
	        
	        Log.wtf("_sendImage", "Sending image size : " + fileSize);
	        
	        byte[] bytes = new byte[(int) fileSize];
	        FileInputStream fis = new FileInputStream(file);
	        BufferedInputStream bis = new BufferedInputStream(fis);
	        BufferedOutputStream out = new BufferedOutputStream(_socket.getOutputStream());
	
	        int count;
	        while ((count = bis.read(bytes)) > 0)
	        {
	            out.write(bytes, 0, count);
	        }
	
	        out.flush();
	        //out.close();
	        fis.close();
	        bis.close();
	        
	        Log.wtf("_sendImage", "End sending");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void _sendMessage(String imagePath)
	{
		Log.wtf("_sendMessage", imagePath);
		
		JsonObject json = new JsonObject();
		json.add(Constants.Action.ACTION, Constants.Action.SEND);
		
		File imageFile = new File(imagePath);
		
		long fileSize = imageFile.length();
		if (fileSize > Integer.MAX_VALUE)
		{
			Log.wtf("_sendMessage", "File is too large.");
		}
		
		json.add(Constants.NAME, imageFile.getName());
		json.add(Constants.SIZE, fileSize);
		
		String jsonString = "[" + json.toString() + "] \n";
		
		Log.wtf("_sendMessage json", jsonString);
		
		try
		{
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(_socket.getOutputStream(), "UTF-16"));
			writer.write(jsonString);
			writer.flush();	
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onPostExecute(Void result)
	{
		_delegate.onRequestSendSuccess();
		
		super.onPostExecute(result);
	}
}