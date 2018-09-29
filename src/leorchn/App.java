package leorchn;

import android.app.*;
import android.content.*;
import leorchn.lib.*;

public class App extends Application implements Consts{
	public App(){
		super();
		c=getContext=this;
	}
	public void onCreate(){
		super.onCreate();
		System.out.println("----Application loaded");
	}
	static Context c, getContext; //支持多种写法
	public static Context getContext(){return c;}
}

