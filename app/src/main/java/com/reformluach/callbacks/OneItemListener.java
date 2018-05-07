package com.reformluach.callbacks;

public interface OneItemListener {
    void selectItemAt(int position);

    void unSelectItemAt(int position);

    void selectItemAtScroll(int position);

    void unSelectItemAtScroll(int position);
}