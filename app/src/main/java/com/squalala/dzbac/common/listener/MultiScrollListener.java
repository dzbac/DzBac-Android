package com.squalala.dzbac.common.listener;

import android.widget.AbsListView;

import com.melnykov.fab.FloatingActionButton.FabOnScrollListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikola on 9/12/14. 
 */
public class MultiScrollListener implements AbsListView.OnScrollListener {

    private List<AbsListView.OnScrollListener> mListeners = new ArrayList<AbsListView.OnScrollListener>();

    public void addScrollListener(AbsListView.OnScrollListener listener) {
        mListeners.add(listener);
    }

    public FabOnScrollListener getFabOnScrollListener() {
        return (FabOnScrollListener) mListeners.get(1);
    }

    public void removeListener(AbsListView.OnScrollListener listener){
        mListeners.remove(listener);
    }
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        for(AbsListView.OnScrollListener listener: mListeners){
            listener.onScrollStateChanged(view,scrollState);
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        for(AbsListView.OnScrollListener listener: mListeners){
            listener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
    }
} 
