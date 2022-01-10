package com.hitesh.genie;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insert(thoughtsModel model);

    @Update
    void update(thoughtsModel model);

    @Delete
    void delete(thoughtsModel model);

    @Query("DELETE FROM Thoughts")
    void deleteAllThoughts();

    @Query("SELECT * FROM Thoughts ORDER BY title ASC")
    LiveData<List<thoughtsModel>> getAllThoughts();
}
