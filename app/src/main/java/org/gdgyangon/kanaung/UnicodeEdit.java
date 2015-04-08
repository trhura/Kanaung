package org.gdgyangon.kanaung;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by yemyatthu on 4/8/15.
 */
public class UnicodeEdit extends EditText{

  public UnicodeEdit(Context context,AttributeSet attrs) {
    super(context,attrs);
    setVerticalScrollBarEnabled(true);
    setMovementMethod(new ScrollingMovementMethod());
  }

  @Override protected void onTextChanged(CharSequence text, int start, int lengthBefore,
      int lengthAfter) {
    super.onTextChanged(Converter.zg12uni51(text.toString()), start, lengthBefore, lengthAfter);
  }
}
