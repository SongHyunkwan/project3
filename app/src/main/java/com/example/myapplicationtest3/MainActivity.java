package com.example.myapplicationtest3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    TextView text2;

    String textwin;
    ;

    int a = 48;
    int b = 32;

    int en1 = 500;
    int en2 = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.textView);
        text2 = (TextView) findViewById(R.id.textView2);
        text1.setText("" + en1);
        text2.setText("" + en2);

        Button bt1p = (Button) findViewById(R.id.button);
        Button bt1m = (Button) findViewById(R.id.button2);
        Button bt2p = (Button) findViewById(R.id.button3);
        Button bt2m = (Button) findViewById(R.id.button4);

        bt1p.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                en1 += a / 2;
                text1.setText("" + en1);
                checkmassage();
            }
        });
        bt1m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                en2 -= a;
                text2.setText("" + en2);
                checkmassage();
            }
        });
        bt2p.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                en2 += b / 2;
                text2.setText("" + en2);
                checkmassage();
            }
        });
        bt2m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                en1 -= b;
                text1.setText("" + en1);
                checkmassage();
            }
        });
    }

    public void checkmassage() {
        if (en1 < 0 || en2 < 0) {
            if (en1 < 0) {
                textwin = "You lose";
            } else if (en2 < 0) {
                textwin = "You win";
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Pokemon fight")
                    .setMessage(textwin)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            en1 = 500;
                            en2 = 400;
                            text1.setText("" + en1);
                            text2.setText("" + en2);
                        }
                    }).show();
        }

    }
}
