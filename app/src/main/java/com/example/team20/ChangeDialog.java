package com.example.team20;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ChangeDialog extends Dialog {
    private TextView txt;
    private Button btn_f;
    private Button btn_s;
    private Intent intent;

    public ChangeDialog(@NonNull Context context, String contents, String btn_txt_f, String btn_txt_s) {
        super(context);
        setContentView(R.layout.activity_two_dialog_y);

        txt = findViewById(R.id.txt);
        txt.setText(contents);
        btn_f = findViewById(R.id.btn_f);
        btn_f.setText(btn_txt_f);
        btn_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btn_s = findViewById(R.id.btn_s);
        btn_s.setText(btn_txt_s);
        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }
}
