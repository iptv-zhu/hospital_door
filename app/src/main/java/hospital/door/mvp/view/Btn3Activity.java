package hospital.door.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

import hospital.door.R;
import hospital.door.mvp.view.base.BaseActivity;

@ContentView(R.layout.activity_btn3)
public class Btn3Activity extends BaseActivity {

    @Override
    public void loadData() {

    }

    @Event(type = View.OnClickListener.class, value = {R.id.over_huli})
    private void OnClick(View view) {
        switch (view.getId()) {
            case R.id.over_huli:
                finish();
                break;
        }
    }

}
