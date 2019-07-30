package com.viksaa.autofit.et;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.autofit.et.lib.AutoFitEditText;
import com.autofit.et.lib.AutoFitEditTextUtil;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private AutoFitEditText mAutoFitEditText;
    private CoordinatorLayout mRootView;
    private SeekBar mLetterSpacingSeekBar;
    private SeekBar mLineSpacingSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(mToolbar);
        mToolbar = findViewById(R.id.toolbar);
        mAutoFitEditText = findViewById(R.id.rET);
        mRootView = findViewById(R.id.root);
        mLetterSpacingSeekBar = findViewById(R.id.letter_spacing_seek_bar);
        mLineSpacingSeekBar = findViewById(R.id.line_spacing_seek_bar);

        initAutoFitEditText();

        mLineSpacingSeekBar.setOnSeekBarChangeListener(new SimpleOnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mAutoFitEditText.setLineSpacing(progress, 1f);
            }
        });

        mLetterSpacingSeekBar.setOnSeekBarChangeListener(new SimpleOnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mAutoFitEditText.setLetterSpacing(progress/100f);
            }
        });
    }


    public void initAutoFitEditText() {

        mAutoFitEditText.setEnabled(true);
        mAutoFitEditText.setFocusableInTouchMode(true);
        mAutoFitEditText.setFocusable(true);
        mAutoFitEditText.setEnableSizeCache(false);
        //might cause crash on some devices
//        mAutoFitEditText.setMovementMethod(null);
        // can be added after layout inflation;
        mAutoFitEditText.setMaxHeight(330);
        //don't forget to add min text size programmatically
        mAutoFitEditText.setMinTextSize(1f);

        AutoFitEditTextUtil.setNormalization(this, mRootView, mAutoFitEditText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static abstract class SimpleOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) { }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) { }
    }
}
