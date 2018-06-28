package com.gamecodeschool.widgetexploration;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploration_layout);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton rbBeijing = (RadioButton) findViewById(R.id.radioButtonBeijing);
        RadioButton rbLondon = (RadioButton) findViewById(R.id.radioButtonLondon);
        RadioButton rbNewYork = (RadioButton) findViewById(R.id.radioButtonNewYork);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.button);
        final TextClock tClock = (TextClock) findViewById(R.id.textClock);
        final CheckBox cbTransparency = (CheckBox) findViewById(R.id.checkBoxTransparency);
        final CheckBox cbTint = (CheckBox) findViewById(R.id.checkBoxTint);
        final CheckBox cbReSize = (CheckBox) findViewById(R.id.checkBoxReSize);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        final WebView webView = (WebView) findViewById(R.id.webView);

        cbTransparency.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cbTransparency.isChecked()){
                    //Set some transparency
                    imageView.setAlpha(.1f);
                }else{
                    imageView.setAlpha(1f);
                }
            }
        });

        cbTint.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbTint.isChecked()){
                    //Checked so set some tint
                    imageView.setColorFilter(Color.argb(150, 255, 0,0));
                }else {
                    //No tint required
                    imageView.setColorFilter(Color.argb(0, 0, 0, 0));
                }
            }
        });

        cbReSize.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbReSize.isChecked()){
                    //It's checked so make it bigger
                    imageView.setScaleX(2);
                    imageView.setScaleY(2);
                }else{
                    //It's not checked make regular size
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                }
            }
        });

        //Now for the radio buttons
        //Uncheck all buttons
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb = (RadioButton) group.findViewById(checkedId);

                switch (rb.getId()) {

                    case R.id.radioButtonLondon:
                        tClock.setTimeZone("Europe/London");
                        break;

                    case R.id.radioButtonBeijing:
                        tClock.setTimeZone("Asia/Shanghai");
                        break;

                    case R.id.radioButtonNewYork:
                        tClock.setTimeZone("America/New_York");
                        break;

                }//End switch block
            }
        });

        //Let's listen for clicks on our regular Button. (Anonymous class)

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //We only handle one button
                //So no switching is required
                button.setText(editText.getText());
            }
        });

        //Make the webview display a page
        webView.loadUrl("http://www.cs.yale.edu/homes/tap/Files/hopper-story.html");

        webView.setVisibility(View.INVISIBLE);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    webView.setVisibility(View.VISIBLE);
                }else{
                    webView.setVisibility(View.INVISIBLE);
                }
            }
        });


    }
}
