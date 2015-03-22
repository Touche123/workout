package android.jonaswestman.workout;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

import android.jonaswestman.helper.SQLiteHelper;
import android.jonaswestman.helper.Workout;


public class WorkoutActivity extends ActionBarActivity {
    SQLiteHelper db = new SQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Workout");
        setContentView(R.layout.activity_workout);
        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView day;
        TextView exercise1;
        List<Workout> workouts;
        switch(message)
        {

            case "Monday":
                day = (TextView)findViewById(R.id.day);
                workouts = db.getWorkoutByDayAndWeek("Monday");
                day.setText("Monday");

                exercise1 = (TextView)findViewById(R.id.exercise1);
                exercise1.setText("");
                if(workouts.size() > 0) {
                    for(Workout workout : workouts) {
                        exercise1.append(workout.getTitle());
                        exercise1.append("\n");
                        exercise1.append("Sets: " + workout.getSets() + "\n");
                        exercise1.append("Reps: " + workout.getReps() + "\n\n");
                    }

                }
            break;

            case "Tuesday":
                day = (TextView)findViewById(R.id.day);
                workouts = db.getWorkoutByDayAndWeek("Tuesday");
                day.setText("Tuesday");

                exercise1 = (TextView)findViewById(R.id.exercise1);
                exercise1.setText("");
                for(Workout workout : workouts) {
                    exercise1.append(workout.getTitle());
                    exercise1.append("\n");
                    exercise1.append("Sets: " + workout.getSets() + "\n");
                    exercise1.append("Reps: " + workout.getReps() + "\n\n");
                }
                break;

            case "Wednesday":
                day = (TextView)findViewById(R.id.day);
                workouts = db.getWorkoutByDayAndWeek("Wednesday");
                day.setText("Wednesday");

                exercise1 = (TextView)findViewById(R.id.exercise1);
                exercise1.setText("");
                for(Workout workout : workouts) {
                    exercise1.append(workout.getTitle());
                    exercise1.append("\n");
                    exercise1.append("Sets: " + workout.getSets() + "\n");
                    exercise1.append("Reps: " + workout.getReps() + "\n\n");
                }
                break;

            case "Thursday":
                day = (TextView)findViewById(R.id.day);
                workouts = db.getWorkoutByDayAndWeek("Thursday");
                day.setText("Thursday");

                exercise1 = (TextView)findViewById(R.id.exercise1);
                exercise1.setText("");
                for(Workout workout : workouts) {
                    exercise1.append(workout.getTitle());
                    exercise1.append("\n");
                    exercise1.append("Sets: " + workout.getSets() + "\n");
                    exercise1.append("Reps: " + workout.getReps() + "\n\n");
                }
                break;

            case "Friday":
                day = (TextView)findViewById(R.id.day);
                workouts = db.getWorkoutByDayAndWeek("Friday");
                day.setText("Friday");

                exercise1 = (TextView)findViewById(R.id.exercise1);
                exercise1.setText("");
                for(Workout workout : workouts) {
                    exercise1.append(workout.getTitle());
                    exercise1.append("\n");
                    exercise1.append("Sets: " + workout.getSets() + "\n");
                    exercise1.append("Reps: " + workout.getReps() + "\n\n");
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_workout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
