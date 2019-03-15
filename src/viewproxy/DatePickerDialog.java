package viewproxy;
import android.app.*;
import static android.app.DatePickerDialog.OnDateSetListener;
import android.content.*;
import android.widget.*;
import android.view.*;
import java.util.*;

public abstract class DatePickerDialog implements OnDateSetListener, View.OnClickListener{
	protected void onShow(android.app.DatePickerDialog dpd){} // 按需实现。在这个对话框被显示之前调用。
	abstract protected void onDateSet(long time, int y, int m, int d) // 强制要求实现。仅在点击 “完成” 后调用一次
	public android.app.DatePickerDialog getDialog(){ return dpd; } // 如果需要额外操作对话框对象
	
	// 以上就是在外面能用的方法
	Calendar c=Calendar.getInstance();
	android.app.DatePickerDialog dpd;
	boolean receivedOnFinishSignal;
	public DatePickerDialog(Activity a, long time){
		init(a, time);
	}
	void init(Activity a, long time){
		c.setTimeInMillis(time);
		dpd=new android.app.DatePickerDialog(a, this,
			c.get(c.YEAR),
			c.get(c.MONTH),
			c.get(c.DAY_OF_MONTH)
		);
		onShow(dpd);
		dpd.show();
		dpd.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(this);
	}
	
	@Override public void onDateSet(DatePicker p,int y,int m,int d){
		if(!receivedOnFinishSignal) return;// 这个事件 mdzz 会调用两次
		receivedOnFinishSignal = false;
		c.set(y,m,d,0,0);
		onDateSet(c.getTimeInMillis(), y, m, d);
	}
	@Override public void onClick(View v){
		receivedOnFinishSignal=true;
		dpd.dismiss(); // 替换监听器之后竟然要手动 dismiss？
	}	
}
