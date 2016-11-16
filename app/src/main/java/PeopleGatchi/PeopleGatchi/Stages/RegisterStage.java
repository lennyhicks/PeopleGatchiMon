package PeopleGatchi.PeopleGatchi.Stages;

import android.app.Application;

import com.davidstemmer.screenplay.stage.Stage;

import PeopleGatchi.PeopleGatchi.Riggers.SlideRigger;
import PeopleGatchi.PeopleGatchi.PeopleGatchiApplication;
import PeopleGatchi.PeopleGatchi.R;

/**
 * Created by lennyhicks on 10/31/16.
 */
public class RegisterStage extends IndexedStage{
    public final SlideRigger rigger;

    public RegisterStage(Application context){
        super(RegisterStage.class.getName());
        this.rigger = new SlideRigger(context);
    }

    public RegisterStage(){
        this(PeopleGatchiApplication.getInstance());
    }

    @Override
    public int getLayoutId() {
        return R.layout.register_view;
    }

    @Override
    public Stage.Rigger getRigger() {
        return rigger;
    }
}
