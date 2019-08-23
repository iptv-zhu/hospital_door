package hospital.door.mvp.view;

import android.os.Handler;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

import hospital.door.R;
import hospital.door.mvp.view.base.BaseActivity;

@ContentView(R.layout.activity_btn1)
public class Btn1Activity extends BaseActivity {

    @Override
    public void loadData() {
    }

    @Event(type = View.OnClickListener.class, value = {R.id.over_icon})
    private void OnClick(View view) {
        switch (view.getId()) {
            case R.id.over_icon:
                finish();
                break;
        }
    }

}
