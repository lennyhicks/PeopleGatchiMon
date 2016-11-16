package PeopleGatchi.PeopleGatchi.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import org.greenrobot.eventbus.EventBus;

import PeopleGatchi.PeopleGatchi.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by eaglebrosi on 11/16/16.
 */

public class CreateView extends LinearLayout {
    private Context context;

    @Bind(R.id.spinner)
    Spinner gender;

    @Bind(R.id.pick_name)
    EditText pickName;

    @Bind(R.id.submit_button)
    Button submit;

    public CreateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);

        EventBus.getDefault().register(this);
    }

    @OnClick(R.id.submit_button)
    public void submitGender() {
        //dropa the keyboard off the screen when the user hits the button.
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(pickName.getWindowToken(), 0);

        // gets the value from each text field.
        String name = pickName.getText().toString();


    }
}
