package com.PeopleGatchi.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.R;
import com.PeopleGatchi.Stages.HomeStage;

import java.util.ArrayList;
import java.util.List;

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
        super.onFinishInflate();
        ButterKnife.bind(this);

        //spinner element
        gender = (Spinner) findViewById(spinner);

        //spinner click listener
//        gender.setOnItemSelectedListener(context);

        //configures what are options are.
        List<String> categories = new ArrayList<>();
        categories.add("cis female");
        categories.add("cis male");
        categories.add("non-confirming");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_item, categories);

        gender.setAdapter(dataAdapter);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position){
        String item = parent.getItemAtPosition(position).toString();

        Toast.makeText(context, "Selected: " + item, Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> arg0){}


    @OnClick(R.id.submit_button)
    public void submitGender() {
        //dropa the keyboard off the screen when the user hits the button.
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(pickName.getWindowToken(), 0);

        // gets the value from the text field and sets it.
       // setPetName = pickName.getText().toString();

       // Toast.makeText(context, "You named you baby "+ getPetName, Toast.LENGTH_SHORT).show();

        // The submit button also takes you to the home screen.
        Flow flow = PeopleGatchiApplication.getMainFlow();
        History newHistory = flow.getHistory().buildUpon()
                .push(new HomeStage())
                .build();
        flow.setHistory(newHistory, Flow.Direction.FORWARD);
    }
}