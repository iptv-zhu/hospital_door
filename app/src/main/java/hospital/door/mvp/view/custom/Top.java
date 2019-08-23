package hospital.door.mvp.view.custom;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


import hospital.door.R;
import hospital.door.utils.Logs;
import hospital.door.utils.LtoDate;

public class Top extends BaseView {
    @ViewInject(R.id.time_hm)
    private TextView time_hm;
    @ViewInject(R.id.time_ymd)
    private TextView time_ymd;
    @ViewInject(R.id.time_e)
    private TextView time_e;
    private View view;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    long sys = System.currentTimeMillis();
                    time_hm.setText(LtoDate.Hm(sys));
                    time_ymd.setText(LtoDate.yMd(sys));
                    time_e.setText(LtoDate.E(sys));
                    handler.sendEmptyMessageDelayed(0, 1000);
                    break;
            }
        }
    };

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logs.e("onAttachedToWindow");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logs.e("onDetachedFromWindow");
    }

    public Top(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Logs.e("Top");
        view = LayoutInflater.from(context).inflate(R.layout.top, this);
        x.view().inject(this);
        handler.sendEmptyMessage(0);
    }
}
