package com.infoedge.android.arandomizer;

import android.os.AsyncTask;

import com.infoedge.jrandomizer.Generator;
import com.infoedge.jrandomizer.Generator.OnDataGenerationListener;

import java.util.List;

/**
 * Created by gagandeep on 2/8/16.
 */

public final class DroidGenerator<TARGET> {

    private Generator<TARGET> mGenerator;

    public DroidGenerator(Class<TARGET> target) {
        mGenerator = new Generator<>(target);
    }

    public TARGET generate() {
        return generate(1).get(0);
    }

    public List<TARGET> generate(int records) {
        return mGenerator.generate(records);
    }

    public void generateAsync(OnDataGenerationListener<TARGET> listener) {
        generateAsync(1, listener);
    }

    public void generateAsync(int numberOfRecords,OnDataGenerationListener<TARGET> listener) {
        new DataGenerationTask(listener, numberOfRecords).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private class DataGenerationTask extends AsyncTask<Void, Void, List<TARGET>> {

        private OnDataGenerationListener<TARGET> mListener;
        private int records;

        public DataGenerationTask(OnDataGenerationListener<TARGET> mListener, int records) {
            this.mListener = mListener;
            this.records = records;
        }


        @Override
        protected List<TARGET> doInBackground(Void... voids) {
            return generate(records);
        }

        @Override
        protected void onPostExecute(List<TARGET> targets) {
            if (mListener != null) {
                mListener.onDataGenerated(targets);
            }
        }
    }

}
