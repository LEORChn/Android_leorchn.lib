package leorchn.lib;
import android.widget.*;
import android.view.*;
import java.util.*;

public abstract class BaseAdapter1 extends BaseAdapter{
	public BaseAdapter1 setListView(ListView v){ v.setAdapter(this); return this; }
	
	protected static int COUNT_OF_LAYOUT;
	protected ArrayList<BaseBean> a = new ArrayList<>();
	public void clear(){ a.clear(); refresh(); }
	public void refresh(){ notifyDataSetChanged(); }
	public <T extends BaseBean> T get(int p){ return (T)a.get(p); }
	@Override public int getCount(){ return a.size(); }
	@Override public Object getItem(int p){ return null; }
	@Override public long getItemId(int p){ return 0; }
	@Override public int getViewTypeCount() { return COUNT_OF_LAYOUT; }
	@Override public int getItemViewType(int position){ return a.get(position).type; }
	@Override public View getView(int index, View v, ViewGroup root){
		int style=a.get(index).type;
		if(v==null) v = createView(index, style);
		return setViewInfo(index, v, style);
	}
	protected abstract View createView(int index, int style);
	protected abstract View setViewInfo(int index, View v, int style);
	
	public interface BaseBean{
		int type;
	}
}
