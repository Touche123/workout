package android.jonaswestman.workout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.audiofx.BassBoost;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import android.jonaswestman.helper.SQLiteHelper;
import android.jonaswestman.helper.Workout;

import org.w3c.dom.Text;

import java.util.List;


public class SettingsActivity extends ActionBarActivity {
    SQLiteHelper db = new SQLiteHelper(this);
    TextView databaseEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        databaseEntries = (TextView)findViewById(R.id.text_numofentries);
        databaseEntries.setText("Number of entries in database: " + db.getAllWorkouts().size());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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

    public void settingsSend(View view)
    {
        TextView day = (TextView)findViewById(R.id.settings_day);
        TextView title = (TextView)findViewById(R.id.settings_title);
        TextView reps = (TextView)findViewById(R.id.settings_reps);
        TextView sets = (TextView)findViewById(R.id.settings_sets);
        TextView week = (TextView)findViewById(R.id.settings_week);

        db.addWorkout(new Workout(title.getText().toString(),
                                    Integer.parseInt(reps.getText().toString()),
                                    Integer.parseInt(sets.getText().toString()),
                                    Integer.parseInt(week.getText().toString()),
                                    day.getText().toString()));

        new AlertDialog.Builder(this)
                .setTitle("Confirm")
                .setMessage("Workout added")
                .setNeutralButton("Ok", null)
                .show();
    }

    public void removeWorkout(View view) {
        List<Workout> workouts = db.getAllWorkouts();
        db.deleteWorkout(workouts.remove(workouts.size() - 1));

        databaseEntries.setText("Number of entries in database: " + db.getAllWorkouts().size());
    }
}
