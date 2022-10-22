package com.jvmfrog.quickmath.ui.components;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.IdRes;

import com.google.android.material.button.MaterialButton;
import com.jvmfrog.quickmath.R;

public class KeyboardView extends LinearLayout implements View.OnClickListener {

    private MaterialButton button1, button2, button3, button4, button5,
            button6, button7, button8, button9, button0, buttonDecimal, buttonBackspace;

    private SparseArray<String> keyValues = new SparseArray<>();
    private InputConnection inputConnection;

    public KeyboardView(Context context) {
        this(context, null, 0);
    }

    public KeyboardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.keyboard, this, true);
        button1 = (MaterialButton) findViewById(R.id.t9_key_1);
        button1.setOnClickListener(this);
        button2 = (MaterialButton) findViewById(R.id.t9_key_2);
        button2.setOnClickListener(this);
        button3 = (MaterialButton) findViewById(R.id.t9_key_3);
        button3.setOnClickListener(this);
        button4 = (MaterialButton) findViewById(R.id.t9_key_4);
        button4.setOnClickListener(this);
        button5 = (MaterialButton) findViewById(R.id.t9_key_5);
        button5.setOnClickListener(this);
        button6 = (MaterialButton) findViewById(R.id.t9_key_6);
        button6.setOnClickListener(this);
        button7 = (MaterialButton) findViewById(R.id.t9_key_7);
        button7.setOnClickListener(this);
        button8 = (MaterialButton) findViewById(R.id.t9_key_8);
        button8.setOnClickListener(this);
        button9 = (MaterialButton) findViewById(R.id.t9_key_9);
        button9.setOnClickListener(this);
        button0 = (MaterialButton) findViewById(R.id.t9_key_0);
        button0.setOnClickListener(this);
        buttonDecimal = (MaterialButton) findViewById(R.id.t9_key_decimal);
        buttonDecimal.setOnClickListener(this);
        buttonBackspace = (MaterialButton) findViewById(R.id.t9_key_backspace);
        buttonBackspace.setOnClickListener(this);

        keyValues.put(R.id.t9_key_1, "1");
        keyValues.put(R.id.t9_key_2, "2");
        keyValues.put(R.id.t9_key_3, "3");
        keyValues.put(R.id.t9_key_4, "4");
        keyValues.put(R.id.t9_key_5, "5");
        keyValues.put(R.id.t9_key_6, "6");
        keyValues.put(R.id.t9_key_7, "7");
        keyValues.put(R.id.t9_key_8, "8");
        keyValues.put(R.id.t9_key_9, "9");
        keyValues.put(R.id.t9_key_0, "0");
        keyValues.put(R.id.t9_key_decimal, ".");
    }

    @Override
    public void onClick(View view) {
        if (inputConnection == null)
            return;

        if (view.getId() == R.id.t9_key_backspace) {
            CharSequence selectedText = inputConnection.getSelectedText(0);

            if (TextUtils.isEmpty(selectedText)) {
                inputConnection.deleteSurroundingText(1, 0);
            } else {
                inputConnection.commitText("", 1);
            }
        } else {
            String value = keyValues.get(view.getId());
            inputConnection.commitText(value, 1);
        }
    }

    public void setInputConnection(InputConnection ic) {
        inputConnection = ic;
    }
}