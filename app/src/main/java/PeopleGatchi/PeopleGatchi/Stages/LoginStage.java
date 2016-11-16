package PeopleGatchi.PeopleGatchi.Stages;

import android.app.Application;

import com.davidstemmer.screenplay.stage.Stage;

import PeopleGatchi.PeopleGatchi.PeopleGatchiApplication;
import PeopleGatchi.PeopleGatchi.R;
import PeopleGatchi.PeopleGatchi.Riggers.SlideRigger;

/**
 * Created by lennyhicks on 10/31/16.
 */
public class LoginStage  extends IndexedStage{
    public final SlideRigger rigger;

    public LoginStage(Application context){
        super(LoginStage.class.getName());
        this.rigger = new SlideRigger(context);
    }

    public LoginStage(){
        this(PeopleGatchiApplication.getInstance());
    }

    @Override
    public int getLayoutId() {
        return R.layout.login_view;
    }

    @Override
    public Stage.Rigger getRigger() {
        return rigger;
    }
}