package br.com.mobicare.viajabessa.utils;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar as AsyncTasks do Android.
 */
public class TaskManager {
    private List<AsyncTask<?,?,?>> mTasks = new ArrayList<AsyncTask<?, ?, ?>>();

    public void register(AsyncTask<?,?,?> asyncTask) {
        mTasks.add(asyncTask);
    }

    public void unregister(AsyncTask<?,?,?> asyncTask) {
        mTasks.remove(asyncTask);
    }

    public void cancelAllTasks() {
        for(AsyncTask<?,?,?> task: this.mTasks) {
            task.cancel(true);
        }
    }
}
