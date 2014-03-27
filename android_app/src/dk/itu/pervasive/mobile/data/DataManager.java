package dk.itu.pervasive.mobile.data;

import android.app.Activity;
import android.preference.PreferenceManager;
import android.util.Log;


/**
 * @author Tony Beltramelli www.tonybeltramelli.com
 */
public class DataManager
{
	public static final String PREF_KEY_SAVE = "save";
	public static final String PREF_KEY_USERNAME = "username";
	public static final String PREF_KEY_SURFACE_ADDRESS = "surfaceAddress";
	public static final String PREF_KEY_STICKER_ID = "stickerID";
	
	private static DataManager _instance = null;
	
	private Activity _context;
	private String _username = "";
	private String _surfaceAddress = "";
	private String _stickerID = "";
	
	private DataManager()
	{
	}
	
	public static DataManager getInstance()
	{
		if (_instance == null)
		{
			_instance = new DataManager();
		}
		
		return _instance;
	}
	
	public void saveData()
	{
		_username = PreferenceManager.getDefaultSharedPreferences(_context).getString(PREF_KEY_USERNAME, "");
		_surfaceAddress = PreferenceManager.getDefaultSharedPreferences(_context).getString(PREF_KEY_SURFACE_ADDRESS, "");
		_stickerID = PreferenceManager.getDefaultSharedPreferences(_context).getString(PREF_KEY_STICKER_ID, "");
		
		Log.wtf("save data", _username + ", " + _surfaceAddress + ", " + _stickerID);	
	}
	
	public String getUsername()
	{
		return _username;
	}
	
	public String getSurfaceAddress()
	{
		return _surfaceAddress;
	}
	
	public String getStickerID()
	{
		return _stickerID;
	}
	
	public void setContext(Activity context)
	{
		_context = context;
		
		saveData();
	}
}
