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

    @Override
    protected void onFinishInflate() {
        // This OnFinishInflate is mostly just the spinner function.
        super.onFinishInflate();
        ButterKnife.bind(this);

        ArrayList<String> categories = new ArrayList<>();
        categories.add("cis female");
        categories.add("cis male");
        categories.add("non-conforming");

        ArrayAdapter<String> adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item,
                categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        chooseGender.setAdapter(adapter);
        String gender = chooseGender.getSelectedItem().toString();
        StatusControls.setGender(gender);
    }

    @OnClick(R.id.submit_button)
    public void createCharacter() {
        //drops the keyboard off the screen when the user hits the button.
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(pickName.getWindowToken(), 0);

        // gets the value from the text field and sets it.
       String pokeName = pickName.getText().toString();

        StatusControls.setName(pokeName);
        StatusControls.resetGame();

        // The submit button also takes you to the home screen.
        Flow flow = PeopleGatchiApplication.getMainFlow();
        History newHistory = History.single(new HomeStage());
        flow.setHistory(newHistory, Flow.Direction.REPLACE);
    }
}