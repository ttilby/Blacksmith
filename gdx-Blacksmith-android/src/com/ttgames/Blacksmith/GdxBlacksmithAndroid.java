package com.ttgames.Blacksmith;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.ttgames.Blacksmith.Blacksmith;

public class GdxBlacksmithAndroid extends AndroidApplication {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        boolean useOpenGLES2 = false;
        
        initialize(new Blacksmith(), useOpenGLES2);
    }
}