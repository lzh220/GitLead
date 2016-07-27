package lzh.dongruan.com.gitlead.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lzh.dongruan.com.gitlead.R;

/**
 * Created by lzh220 on 2016/7/26.
 */
public class LeadActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.btnEnter)
    Button btnEnter;
    @Bind(R.id.buttonBar)
    LinearLayout buttonBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        btnEnter.setOnClickListener(this);
    }

    @OnClick({R.id.btnLogin, R.id.btnEnter})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                break;
            case R.id.btnEnter:
                Intent intent=new Intent(this, Home.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
