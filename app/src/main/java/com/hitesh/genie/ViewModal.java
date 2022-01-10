package com.hitesh.genie;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModal extends AndroidViewModel {

    private thoughtsRepository repository;

    private LiveData<List<thoughtsModel>> allThoughts;

    public ViewModal(@NonNull Application application) {
        super(application);
        repository = new thoughtsRepository(application);
        allThoughts = repository.getAllThoughts();
    }

    public void insert(thoughtsModel model) {
        repository.insert(model);
    }

    public void update(thoughtsModel model) {
        repository.update(model);
    }

    public void delete(thoughtsModel model) {
        repository.delete(model);
    }

    public void deleteAllThoughts() {
        repository.deleteAllThoughts();
    }

    public LiveData<List<thoughtsModel>> getAllCourses() {
        return allThoughts;
    }
}