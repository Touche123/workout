package android.jonaswestman.workout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import android.jonaswestman.helper.SQLiteHelper;
import android.jonaswestman.helper.Workout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "android.jonaswestman.workout.MESSAGE";
    public static int WEEKOFYEAR;
    SQLiteHelper db = new SQLiteHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Workout");
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        WEEKOFYEAR = calendar.get(Calendar.WEEK_OF_YEAR);
        TextView textView = (TextView)findViewById(R.id.text_week);
        textView.setText(Integer.toString(WEEKOFYEAR));

        Log.d("Date", Integer.toString(WEEKOFYEAR));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void addWorkout(View view) {

        Log.d("DB", "Adding workout");
    }

    public void removeWorkout(View view) {
        List<Workout> workouts = db.getAllWorkouts();
        db.deleteWorkout(workouts.remove(workouts.size() - 1));
        Log.d("DB", "Removing workout");
    }

    public void buttonPress(View view)
    {
        Intent intent = new Intent(this, WorkoutActivity.class);
        String message;

        switch(view.getId()) {

            case R.id.button_monday:
                message = "Monday";
                intent.putExtra(EXTRA_MESSAGE, message);
                break;

            case R.id.button_tuesday:
                message = "Tuesday";
                intent.putExtra(EXTRA_MESSAGE, message);
                break;

            case R.id.button_wednesday:
                message = "Wednesday";
                intent.putExtra(EXTRA_MESSAGE, message);
                break;

            case R.id.button_thursday:
                message = "Thursday";
                intent.putExtra(EXTRA_MESSAGE, message);
                break;

            case R.id.button_friday:
                message = "Friday";
                intent.putExtra(EXTRA_MESSAGE, message);
                break;
        }

        startActivity(intent);
    }
}
