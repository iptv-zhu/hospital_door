package hospital.door.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import hospital.door.R;
import hospital.door.mvp.presenter.adapter.MainAdapter;
import hospital.door.mvp.view.base.BaseActivity;


@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.list)
    RecyclerView list;
    @ViewInject(R.id.btn1)
    Button btn1;
    @ViewInject(R.id.btn2)
    Button btn2;
    @ViewInject(R.id.btn3)
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }

    @Override
    public void loadData() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        list.setLayoutManager(staggeredGridLayoutManager);

        MainAdapter mainAdapter = new MainAdapter();
        list.setAdapter(mainAdapter);

    }

    @Event(type = View.OnClickListener.class, value = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn_1})
    private void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(MainActivity.this, Btn1Activity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(MainActivity.this, Btn2Activity.class));
                break;
            case R.id.btn3:
//                startActivity(new Intent(MainActivity.this, Btn3Activity.class));
                initKeyBoard();
                break;
        }
    }

    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    private Button btn_d, btn_b;
    private TextInputEditText password;
    private BottomSheetDialog dialog = null;

    private void initKeyBoard() {
        dialog = new BottomSheetDialog(this);
        dialog.setContentView(R.layout.keyboard);
        dialog.setCancelable(false);
        btn_0 = dialog.findViewById(R.id.btn_0);
        btn_0.setOnClickListener(new KeyCode());
        btn_1 = dialog.findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new KeyCode());
        btn_2 = dialog.findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new KeyCode());
        btn_3 = dialog.findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new KeyCode());
        btn_4 = dialog.findViewById(R.id.btn_4);
        btn_4.setOnClickListener(new KeyCode());
        btn_5 = dialog.findViewById(R.id.btn_5);
        btn_5.setOnClickListener(new KeyCode());
        btn_6 = dialog.findViewById(R.id.btn_6);
        btn_6.setOnClickListener(new KeyCode());
        btn_7 = dialog.findViewById(R.id.btn_7);
        btn_7.setOnClickListener(new KeyCode());
        btn_8 = dialog.findViewById(R.id.btn_8);
        btn_8.setOnClickListener(new KeyCode());
        btn_9 = dialog.findViewById(R.id.btn_9);
        btn_9.setOnClickListener(new KeyCode());
        btn_d = dialog.findViewById(R.id.btn_d);
        btn_d.setOnClickListener(new KeyCode());
        btn_b = dialog.findViewById(R.id.btn_b);
        btn_b.setOnClickListener(new KeyCode());
        password = dialog.findViewById(R.id.password);

        dialog.show();
    }

    private StringBuffer keyValue = new StringBuffer();

    //sb.deleteCharAt(sb.length() - 1);
    class KeyCode implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_0:
                    keyValue.append("0");
                    break;
                case R.id.btn_1:
                    keyValue.append("1");
                    break;
                case R.id.btn_2:
                    keyValue.append("2");
                    break;
                case R.id.btn_3:
                    keyValue.append("3");
                    break;
                case R.id.btn_4:
                    keyValue.append("4");
                    break;
                case R.id.btn_5:
                    keyValue.append("5");
                    break;
                case R.id.btn_6:
                    keyValue.append("6");
                    break;
                case R.id.btn_7:
                    keyValue.append("7");
                    break;
                case R.id.btn_8:
                    keyValue.append("8");
                    break;
                case R.id.btn_9:
                    keyValue.append("9");
                    break;
                case R.id.btn_d:
                    if (keyValue.length() > 0)
                        keyValue.deleteCharAt(keyValue.length() - 1);
                    break;
                case R.id.btn_b:
                    if (dialog != null)
                        dialog.dismiss();
                    break;
                default:
                    break;

            }
            password.setText(keyValue);
        }
    }

}
