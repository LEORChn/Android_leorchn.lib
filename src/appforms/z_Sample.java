package appforms;
import leorchn.lib.*;
import android.view.*;

public class z_Sample extends Activity1 implements ListView.OnListItemEventListener{
	@Override protected void oncreate() {
		
	}
	int hasinit;
	@Override protected boolean onIdle() {
		switch(hasinit){
			case 0:
				//setContentView(layout.);
				break;
			case 1:
				// todo
		}
		return hasinit++<9;
	}
	// 监听器区
	@Override public void onClick(View v) {
		switch(v.getId()){
			//case id.:
		}
	}

	@Override public void onListItemEvent(ListView lsv, View item, int index){
		// todo
	}
	// 监听器区 结束
	// 列表控制区
	class ListControl extends BaseAdapter1{
		public ListControl(ListView v){
			COUNT_OF_LAYOUT = ItemStyle.$VALUES.length;
			setListView(v);
			v.setOnListItemEventListener(z_Sample.this);
		}
		public ListControl setListView(ListView v){ v.setAdapter(this); return this; }
		public Bean newBean(){ Bean b=new Bean(); a.add(b); return b; }
		@Override protected View createView(int index, int style){ // style = bean.type
			View v=inflateView(((Bean)get(index)).layout.id);
			ViewGroup w=(ViewGroup)v;
			Holder h=new Holder();
			h.type=style;
			h.img=fv(w, 0); // todo
			v.setTag(h);
			return v;
		}
		@Override protected View setViewInfo(int index, View v, int style) {
			Holder h=(Holder)v.getTag();
			Bean b=get(index);
			// setText(h.title, b.title); // todo
			return v;
		}
	}
	class Bean implements BaseAdapter1.BaseBean{
		static final int TYPE_=0;
		// String title; // todo
		ItemStyle layout=ItemStyle.$VALUES[0]; // 创建 bean 时可以不明确其使用的子布局，但是需要至少有一个子布局
	}
	enum ItemStyle{ // 枚举所有子布局
		// todo
		;public final int id;
		ItemStyle(int layoutId){ id=layoutId; }
	}
	class Holder{
		int type;
		View img; // View title; // todo
	}
	// 列表控制区 结束
}