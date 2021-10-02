package com.longtraidep.androidtest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(RobolectricTestRunner.class)
public class DemoTest {
    private MainActivity mActivity;

    @Before
    public void setUp() throws Exception {
        mActivity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    @Test
    public void testViewStart() throws Exception {
        assertThat(mActivity.mButtonSum.getText().toString(), equalTo("Cộng"));
        assertThat(mActivity.mTextViewResult.getText().toString(), equalTo("Kết quả"));
    }

    @Test
    public void testClicking() throws Exception {
        // Test thử chức năng 1 + 1 = 2;
        mActivity.mButtonSum.performClick();
        assertThat(mActivity.mTextViewResult.getText().toString(), equalTo("2"));
    }
}
