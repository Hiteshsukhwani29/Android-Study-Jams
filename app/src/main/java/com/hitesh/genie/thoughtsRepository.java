package com.hitesh.genie;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class thoughtsRepository {

    private Dao dao;
    private LiveData<List<thoughtsModel>> allThoughts;

    public thoughtsRepository(Application application) {
        thoughtsDatabase database = thoughtsDatabase.getInstance(application);
        dao = database.Dao();
        allThoughts = dao.getAllThoughts();
    }

    public void insert(thoughtsModel model) {
        new InsertThoughtAsyncTask(dao).execute(model);
    }

    public void update(thoughtsModel model) {
        new UpdateThoughtAsyncTask(dao).execute(model);
    }

    public void delete(thoughtsModel model) {
        new DeleteThoughtAsyncTask(dao).execute(model);
    }

    public void deleteAllThoughts() {
        new DeleteAllThoughtsAsyncTask(dao).execute();
    }

    public LiveData<List<thoughtsModel>> getAllThoughts() {
        return allThoughts;
    }

    private static class InsertThoughtAsyncTask extends AsyncTask<thoughtsModel, Void, Void> {
        private Dao dao;

        private InsertThoughtAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(thoughtsModel... model) {
            dao.insert(model[0]);
            return null;
        }
    }

    private static class UpdateThoughtAsyncTask extends AsyncTask<thoughtsModel, Void, Void> {
        private Dao dao;

        private UpdateThoughtAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(thoughtsModel... models) {
            dao.update(models[0]);
            return null;
        }
    }

    private static class DeleteThoughtAsyncTask extends AsyncTask<thoughtsModel, Void, Void> {
        private Dao dao;

        private DeleteThoughtAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(thoughtsModel... models) {
            dao.delete(models[0]);
            return null;
        }
    }

    private static class DeleteAllThoughtsAsyncTask extends AsyncTask<Void, Void, Void> {
        private Dao dao;
        private DeleteAllThoughtsAsyncTask(Dao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllThoughts();
            return null;
        }
    }

}
