package hospital.door.mvp.view.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import org.xutils.x;

import hospital.door.utils.Logs;

public class BaseView extends RelativeLayout {

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        x.view().inject(this);
        Logs.e("BaseView");
    }
}
