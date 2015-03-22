package android.jonaswestman.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.jonaswestman.workout.MainActivity;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "WorkoutDB";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_WORKOUT_TABLE = "CREATE TABLE workout ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, " +
                "sets INTEGER, " +
                "reps INTEGER, " +
                "week INTEGER, " +
                "day String)";

        db.execSQL(CREATE_WORKOUT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS workout");

        this.onCreate(db);
    }

    public void addWorkout(Workout workout) {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title", workout.getTitle());
        values.put("sets", workout.getSets());
        values.put("reps", workout.getSets());
        values.put("week", workout.getWeek());
        values.put("day", workout.getDay());

        db.insert("workout", null, values);

        db.close();

        Log.d("addWorkout", workout.toString());
    }

    public List<Workout> getWorkoutByDayAndWeek(String day) {
        List<Workout> workouts = new LinkedList<>();

        String query = "SELECT * FROM workout WHERE day=? AND week=?";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, new String[] { day, Integer.toString(MainActivity.WEEKOFYEAR) });
        Workout workout;
        if(cursor.moveToFirst()) {
            do{
                workout = new Workout();
                workout.setId(Integer.parseInt(cursor.getString(0)));
                workout.setTitle(cursor.getString(1));
                workout.setSets(Integer.parseInt(cursor.getString(2)));
                workout.setReps(Integer.parseInt(cursor.getString(3)));
                workout.setWeek(Integer.parseInt(cursor.getString(4)));
                workout.setDay(cursor.getString(5));


                workouts.add(workout);
            } while (cursor.moveToNext());
        }
        Log.d("Workoutsbydayandweek", workouts.toString());
        return workouts;
    }

    public List<Workout> getAllWorkouts() {
        List<Workout> workouts = new LinkedList<>();

        String query = "SELECT * FROM workout";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Workout workout;
        if (cursor.moveToFirst()) {
            do {
                workout = new Workout();
                workout.setId(Integer.parseInt(cursor.getString(0)));
                workout.setTitle(cursor.getString(1));
                workout.setSets(Integer.parseInt(cursor.getString(2)));
                workout.setReps(Integer.parseInt(cursor.getString(3)));
                workout.setWeek(Integer.parseInt(cursor.getString(4)));
                workout.setDay(cursor.getString(5));

                workouts.add(workout);
            } while (cursor.moveToNext());
        }
        Log.d("getAllBooks()", workouts.toString());
        return workouts;
    }

    public void deleteWorkout(Workout workout) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete("workout",
                "id = ?",
                new String[]{String.valueOf(workout.getId())});

        db.close();


    }


}
