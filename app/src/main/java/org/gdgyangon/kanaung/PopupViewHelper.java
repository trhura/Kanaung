package org.gdgyangon.kanaung;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.PopupWindow;

/**
 * Created by yemyatthu on 4/8/15.
 */
public class PopupViewHelper implements View.OnClickListener {
  Context mContext;
  UnicodeEdit mUnicodeEdit;
  UnicodeView mUnicodeView;
  ImageButton mEditButton;
  ImageButton mFullScreenButton;
  PopupWindow mPopupWindow;
  View mChathead;
  WindowManager.LayoutParams mLayoutParams;
  boolean inEditMode;
  boolean inFullScreen;

  public PopupViewHelper(Context context) {
    mContext = context;
  }

  public View getPopUpView() {
    View view = View.inflate(mContext, R.layout.popup_view, null);
    mUnicodeEdit = (UnicodeEdit) view.findViewById(R.id.unicode_edit);
    mUnicodeView = (UnicodeView) view.findViewById(R.id.unicode_view);
    mEditButton = (ImageButton) view.findViewById(R.id.edit_button);
    mFullScreenButton = (ImageButton) view.findViewById(R.id.full_screen_button);
    mUnicodeEdit.setVisibility(View.INVISIBLE);
    inEditMode = false;
    mEditButton.setOnClickListener(this);

    mFullScreenButton.setOnClickListener(this);
    return view;
  }

  @Override public void onClick(View view) {
    if (view.getId() == R.id.edit_button) {
      InputMethodManager imm =
          (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);

      if (!inEditMode) {
        mUnicodeEdit.setVisibility(View.VISIBLE);
        mUnicodeEdit.invalidate();
        mUnicodeView.setVisibility(View.GONE);
        mEditButton.setImageResource(R.drawable.ic_save_white_24dp);
        imm.showSoftInput(mUnicodeEdit,0);
        inEditMode = true;
      } else {
        mUnicodeView.setVisibility(View.VISIBLE);
        mUnicodeEdit.setVisibility(View.GONE);
        mEditButton.setImageResource(R.drawable.ic_mode_edit_white_24dp);
        ClipboardManager clipboard =
            (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setText(mUnicodeEdit.getText());
        mUnicodeView.setText(clipboard.getText());
        imm.hideSoftInputFromWindow(mUnicodeEdit.getWindowToken(), 0);
        inEditMode = false;
      }
    } else if (view.getId() == R.id.full_screen_button) {
      if (inFullScreen) {
        mFullScreenButton.setImageResource(R.drawable.ic_fullscreen_white_24dp);
        if (mPopupWindow != null) {
          onClickNormalScreen(mPopupWindow);
        }
        inFullScreen = false;
      } else {
        mFullScreenButton.setImageResource(R.drawable.ic_fullscreen_exit_white_24dp);
        if (mPopupWindow != null) {
          onClickFullScreen(mPopupWindow);
        }
        inFullScreen = true;
      }
    }
  }

  public void setPopUpWindow(PopupWindow popUpWindow) {
    mPopupWindow = popUpWindow;
  }

  void onClickFullScreen(PopupWindow popupWindow) {
    WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
    Display display = windowManager.getDefaultDisplay();
    int width = display.getWidth();
    int height = display.getHeight();
    popupWindow.update(width,height);
    popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
    if(mChathead!=null){
      mLayoutParams.x = 0;
      mLayoutParams.y= 0;
      windowManager.updateViewLayout(mChathead,mLayoutParams);
    }
  }

  void onClickNormalScreen(PopupWindow popupWindow) {
    WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
    Display display = windowManager.getDefaultDisplay();
    int width = display.getWidth() - 40;
    int height = display.getHeight() / 2;
    popupWindow.update(width,height);
    if(mChathead!=null){
      mLayoutParams.x = 10;
      mLayoutParams.y= 100;
    windowManager.updateViewLayout(mChathead,mLayoutParams);}
  }
  public void setChatHead(View chatHead,WindowManager.LayoutParams params){
    mChathead = chatHead;
    mLayoutParams = params;
  }
}
