package com.example.two_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.two_activity.SecondActivity.EXTRA_REPLY;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.Message";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int TEXT_REQUEST = 1;



    private EditText mMessageEditText;
    private TextView mreplytextheader;
    private TextView mreplyHeadtextView;
    private TextView mReplyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        mreplyHeadtextView = findViewById(R.id.text_header_reply);
        mReplyView = findViewById(R.id.text_message_reply);





    }

    public void launchSecondActivity(View view){
        Log.d("button_clicked", "button_clicked");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent, TEXT_REQUEST);



    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==  TEXT_REQUEST)
        {
            if(resultCode == RESULT_OK){
                String reply =data.getStringExtra(EXTRA_REPLY) ;
              mreplyHeadtextView.setVisibility(View.VISIBLE);
              mReplyView.setText(reply);
              mReplyView.setVisibility(View.VISIBLE);
              
        }
        }



    }
}
