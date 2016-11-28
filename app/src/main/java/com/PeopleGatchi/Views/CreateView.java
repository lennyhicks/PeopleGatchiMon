package com.PeopleGatchi.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.R;
import com.PeopleGatchi.Stages.HomeStage;
import com.PeopleGatchi.Utils.StatusControls;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import flow.Flow;
import flow.History;

import static com.PeopleGatchi.R.id.spinner;

/**
 * Created by eaglebrosi on 11/16/16.
 */

public class CreateView extends LinearLayout {

    private Context context;
    private Spinner gender;

    @Bind(spinner)
    Spinner chooseGender;

    @Bind(R.id.pick_name)
    EditText pickName;

    @Bind(R.id.submit_button)
    Button submit;


    public CreateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    /*
    Displays where the user can set their name and sets up the spinner to allow the user to select
    their gender
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);

        ArrayList<String> categories = new ArrayList<>();
        categories.add(getContext().getString(R.string.female));
        categories.add(getContext().getString(R.string.male));
        categories.add(getContext().getString(R.string.non_conforming));

        ArrayAdapter<String> adapter = new ArrayAdapter(context,
                android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        chooseGender.setAdapter(adapter);
    }

    /*
    Sets the users name and gender and changes the view to the home view
     */
    @OnClick(R.id.submit_button)
    public void createCharacter() {
        //drops the keyboard off the screen when the user hits the button.
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(pickName.getWindowToken(), 0);

        // gets the value from the text field and sets it.
        String pokeName = pickName.getText().toString();
        StatusControls.setName(pokeName);
        String gender = chooseGender.getSelectedItem().toString();
        StatusControls.setGender(gender);
        StatusControls.resetLevels();

        // The submit button also takes you to the home screen.
        Flow flow = PeopleGatchiApplication.getMainFlow();
        History newHistory = History.single(new HomeStage());
        flow.setHistory(newHistory, Flow.Direction.REPLACE);
    }
}