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
public class EducationView extends LinearLayout {
    private Context context;
    public static int sciEdScore;
    public static int mathEdScore;

    @Bind(R.id.increase_science)
    Button increaseScience;

    @Bind(R.id.increase_math)
    Button increaseMath;


    public EducationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        ButterKnife.bind(this);

        EventBus.getDefault().register(this);
    }

    @OnClick(R.id.increase_science)
    public void changeScience(){
        //time passes when being taught.
        //Utils.addTime();
        // sometimes you learns betters then others.
        int increase= ((int)(Math.random()*5)+1);
        sciEdScore += increase;
        Toast.makeText(context, "You got smarterer by " + increase, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.increase_math)
    public void changeMath(){
        //time passes when being taught.
        //Utils.addTime();
        // sometimes you learns betters then others.
        int increase= ((int)(Math.random()*5)+1);
        sciEdScore += increase;
        Toast.makeText(context, "You got smarterer by " + increase, Toast.LENGTH_SHORT).show();
    }
}
