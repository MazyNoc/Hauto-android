package nu.annat.autohome;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {

	private static Preferences instance = new Preferences();
	private SharedPreferences prefs;

	public static void init(Context context) {
		instance.prefs = PreferenceManager.getDefaultSharedPreferences(context);
	}

	public static String getLastPageId() {
		return instance.prefs.getString("pageId", null);
	}

	public static void setLastPageId(String id) {
		instance.prefs.edit().putString("pageId", id).apply();
	}
}
