package com.reformluach.callbacks;

public interface RecyclerViewCallBack {
    void CallBackRecyclerView(Object... args);

    void positionSelected(int positionSelected);

    void positionUnselected(int positionUnselected);

    void positionScrolledSelected(int positionSelected);

    void positionScrolledUnSelected(int positionUnselected);
}