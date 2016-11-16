package PeopleGatchi.PeopleGatchi.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import PeopleGatchi.PeopleGatchi.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by eaglebrosi on 11/16/16.
 */

public class JobView extends LinearLayout {
    private Context context;
    public double bankBalance;
// Now this won't continue working. This isn't how we are doing it.
    int hour;

    @Bind(R.id.labor_butt)
    Button labor;

    @Bind(R.id.engineer_butt)
    Button engineer;

    @Bind(R.id.science_butt)
    Button science;

    public JobView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);

        EventBus.getDefault().register(this);
    }

    @OnClick(R.id.labor_butt)
    public void workLabor() {
        //time passes while working
        hour += 2;
        // manual labor gets a set pay between 15 and 5 dollars an hour.
        int payment = ((int) Math.random() * 20) + 10;
    }

    @OnClick(R.id.engineer_butt)
    public void workMath() {
        //time passes while working
        hour += 2;
        // manual labor gets a set pay between 15 and 5 dollars an hour.
        int payment = ((int) Math.random() * EducationView.mathEdScore) + EducationView.mathEdScore/2;
    }

    @OnClick(R.id.science_butt)
    public void workScience() {
        //time passes while working
        hour += 2;
        // manual labor gets a set pay between 15 and 5 dollars an hour.
        int payment = ((int) Math.random() * EducationView.sciEdScore) + EducationView.sciEdScore/2;
        Toast.makeText(context, "You were paid "+ payment + " for 2 hours of work.", Toast.LENGTH_SHORT).show();
    }
}