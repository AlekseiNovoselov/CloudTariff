package com.example.aleksei.cloudtariff;

import android.widget.CompoundButton;

import java.io.Serializable;

class PageInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    final int image;
    final int title;
    final int message;
    final int checkboxTitle;
    final boolean checkBoxState;
    final transient CompoundButton.OnCheckedChangeListener checkListener;

    public PageInfo(int image, final int title, final int message) {
        this(image, title, message, 0, false, null);
    }

    public PageInfo(int image, final int title, final int message, final int checkboxTitle, final boolean checkBoxState,
                    final CompoundButton.OnCheckedChangeListener checkListener) {
        this.image = image;
        this.title = title;
        this.message = message;
        this.checkboxTitle = checkboxTitle;
        this.checkBoxState = checkBoxState;
        this.checkListener = checkListener;
    }
}
