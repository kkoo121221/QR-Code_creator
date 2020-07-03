package com.example.datastore_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    EditText qrcode_content;
    Button btn_sent;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_sent = (Button) findViewById(R.id.btn_sent);
        imageView = (ImageView) findViewById(R.id.imageView);
        qrcode_content = (EditText) findViewById(R.id.qrcode_content);

        btn_sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCode(v);
            }
        });
    }
    private void getCode(View view){
        BarcodeEncoder encoder = new BarcodeEncoder();
        try{
            Bitmap bit = encoder.encodeBitmap(qrcode_content.getText().toString(),
                    BarcodeFormat.QR_CODE,
                    280,280
                    );
            imageView.setImageBitmap(bit);
        }catch (WriterException e){
            e.printStackTrace();
        }
    }
}