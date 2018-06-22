package com.reeching.sanitation.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.reeching.sanitation.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 修改页面
 */
public class AlterActivity extends AppCompatActivity {

    @Bind(R.id.top_finish)
    ImageView topFinish;
    @Bind(R.id.top_name)
    TextView topname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter);
        ButterKnife.bind(this);
        topname.setText("修改");

    }
}
