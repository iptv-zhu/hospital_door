package hospital.door.mvp.view;

import android.os.Bundle;
import android.view.View;

import hospital.door.R;
import hospital.door.mvp.view.base.BaseActivity;

public class WelcomeActivity extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    public void loadData() {

    }

}
