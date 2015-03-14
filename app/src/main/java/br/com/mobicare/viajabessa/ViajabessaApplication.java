package br.com.mobicare.viajabessa;

import android.app.Application;

import br.com.mobicare.viajabessa.utils.TaskManager;

public class ViajabessaApplication extends Application {
    private TaskManager mTaskManager = new TaskManager();

    @Override
    public void onTerminate() {
        super.onTerminate();
        mTaskManager.cancelAllTasks();
    }

    public TaskManager getTaskManager() {
        return mTaskManager;
    }

}
