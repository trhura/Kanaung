package org.gdgyangon.kanaung;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;

/**
 * Created by yemyatthu on 4/8/15.
 */
public class PopupViewHelper implements View.OnClickListener {
  Context mContext;
  UnicodeEdit mUnicodeEdit;
  UnicodeView mUnicodeView;
  ImageButton mEditButton;
  boolean inEditMode;
  public PopupViewHelper(Context context){
    mContext = context;
  }

  public View getPopUpView(){
    View view = View.inflate(mContext,R.layout.popup_view,null);
    mUnicodeEdit = (UnicodeEdit) view.findViewById(R.id.unicode_edit);
    mUnicodeView = (UnicodeView) view.findViewById(R.id.unicode_view);
    mEditButton = (ImageButton) view.findViewById(R.id.edit_button);
    mUnicodeEdit.setVisibility(View.INVISIBLE);
    inEditMode = false;
    mEditButton.setOnClickListener(this);
    return view;
  }

  @Override public void onClick(View view) {
    if(view.getId()==R.id.edit_button){
      InputMethodManager imm = (InputMethodManager)mContext.getSystemService(
          Context.INPUT_METHOD_SERVICE);

      if(!inEditMode){
        mUnicodeEdit.setVisibility(View.VISIBLE);
        mUnicodeEdit.invalidate();
        mUnicodeView.setVisibility(View.INVISIBLE);
        mEditButton.setImageResource(R.drawable.ic_save_white_24dp);
        imm.showSoftInput(mUnicodeEdit, 0);
        inEditMode = true;
      }
      else{
        mUnicodeView.setVisibility(View.VISIBLE);
        mUnicodeEdit.setVisibility(View.INVISIBLE);
        mEditButton.setImageResource(R.drawable.ic_mode_edit_white_24dp);
        ClipboardManager clipboard = (ClipboardManager) mContext.getSystemService(
            Context.CLIPBOARD_SERVICE);
        clipboard.setText(mUnicodeEdit.getText());
        mUnicodeView.setText(clipboard.getText());
        imm.hideSoftInputFromWindow(mUnicodeEdit.getWindowToken(), 0);
        inEditMode = false;
      }
    }
  }
}
