package org.gdgyangon.kanaung;

import android.content.ClipboardManager;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by trhura on 10/22/14.
 */
public class UnicodeView extends TextView {
    private static final String TAG = "Kanaung";

    public UnicodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setVerticalScrollBarEnabled(true);
        setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    protected void onWindowVisibilityChanged (int visibility) {
        ClipboardManager manager = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        CharSequence copiedText = manager.getText();
        if (copiedText == null) return;

        switch (visibility) {
            case VISIBLE:
                setText(Converter.zg12uni51(copiedText.toString()));
                break;

            case INVISIBLE:
                setText(R.string.nothing_copied);
                break;
        }
    }

}
