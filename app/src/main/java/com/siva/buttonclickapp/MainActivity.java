package com.siva.buttonclickapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    //    private Button button;
    private TextView textView;
    //    private int numTimesClicked = 0;
    private static final String TAG = "MainActivity";
    private final String TEXT_CONTENTS = "TextContents"; // to keep the contents of the textview even when we change the orientation. To keep the saved String(text)in textview.


    @Override
    protected void onCreate(Bundle savedInstanceState) {  // Bundle is an object that can be used to pass data around within the android framework. Bundle contains a list of Key Value pairs.
        Log.d(TAG, "onCreate: in");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.editText);
        userInput.setText("");  // To keep the contents of teh text view even when we change the orientation of the mobile phone.
        Button button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(""); // setText replaces all the previous text to the new text; set will set the value & get will retrieve the value.
        textView.setMovementMethod(new ScrollingMovementMethod()); // this method is added to scroll the textView

        View.OnClickListener ourOnClickListener = new View.OnClickListener() {  // View is an interface here; we create a new object for the method OnClickListener.
            @Override
            public void onClick(View view) {
//                numTimesClicked = numTimesClicked + 1;
//                String result = "The button got tapped " + numTimesClicked + " time";
//                if (numTimesClicked != 1){
//                    result += "s";  // result = result + "s"
//                }
//                result = result + "\n";
//                textView.append(result); // we are calling the append method to add a line of text to that text view.
                Editable e = userInput.getText();
                String result = userInput.getText().toString(); // toString is to make it as a String; if we don't use toString it will show an error.
                result = result + "\n";
                textView.append(result);
                userInput.setText(""); // To keep the contents of teh text view even when we change the orientation of the mobile phone.
            }
        };
        button.setOnClickListener(ourOnClickListener); // we call onClickListener method whenever that button is clicked.
        Log.d(TAG, "onCreate: out");

    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
//        String savedString = savedInstanceState.getString(TEXT_CONTENTS);  // to keep the contents of the textview even when we change the orientation.
//        textView.setText(savedString); // to keep the contents of the textview even when we change the orientation.
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS)); // shortcut to create a separate variable.
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(TEXT_CONTENTS, textView.getText().toString());
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        Log.d(TAG, "onResume: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }
}