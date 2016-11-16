package PeopleGatchi.PeopleGatchi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.davidstemmer.flow.plugin.screenplay.ScreenplayDispatcher;

import PeopleGatchi.PeopleGatchi.Models.TestPost;
import PeopleGatchi.PeopleGatchi.Network.RestClient;
import PeopleGatchi.PeopleGatchi.Network.UserStore;
import PeopleGatchi.PeopleGatchi.Stages.LoginStage;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import flow.Flow;
import flow.History;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private Flow flow;
    private ScreenplayDispatcher dispatcher;

    @Bind(R.id.container)
    RelativeLayout container;

    @Bind(R.id.food_bar)
    ProgressBar foodBar;

    @Bind(R.id.drink_bar)
    ProgressBar drinkBar;

    @Bind(R.id.sleep_bar)
    ProgressBar sleepBar;

    @Bind(R.id.imageView)
    ImageView imageView;

    @Bind(R.id.hygiene_bar)
    ProgressBar hygieneBar;

    @Bind(R.id.pee_bar)
    ProgressBar peeBar;

    @Bind(R.id.poop_bar)
    ProgressBar poopBar;

    @Bind(R.id.bank_amount)
    TextView bankAmount;

    @Bind(R.id.image_button2)
    ImageButton imageButton2;

    @Bind(R.id.clock)
    TextView clock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        flow = PeopleGatchiApplication.getMainFlow();
        dispatcher = new ScreenplayDispatcher(this, container);
        dispatcher.setUp(flow);

        //testCalls();

        if(UserStore.getInstance().getToken() == null || UserStore.getInstance().getTokenExpiration() == null){
            History newHistory = History.single(new LoginStage());
            flow.setHistory(newHistory, Flow.Direction.REPLACE);
        }
    }

    @Override
    public void onBackPressed(){
        if (!flow.goBack()){
            flow.removeDispatcher(dispatcher);
            flow.setHistory(History.single(new PeopleGatchiApplication()), Flow.Direction.BACKWARD);
            super.onBackPressed();
        }

    }

    private void testCalls(){
        RestClient restClient = new RestClient();
        restClient.getApiService().getPost(1).enqueue(new Callback<TestPost>() {
            @Override
            public void onResponse(Call<TestPost> call, Response<TestPost> response) {
                Log.i(TAG, "Getpost - Title: " + response.body().getTitle() + "\n Body: " + response.body().getBody());
            }

            @Override
            public void onFailure(Call<TestPost> call, Throwable t) {
                Log.i(TAG, "GetPost Failed");
            }
        });

        TestPost testPost = new TestPost(1, "Test post Title", "Test post Body");
        restClient.getApiService().postPost(testPost).enqueue(new Callback<TestPost>() {
            @Override
            public void onResponse(Call<TestPost> call, Response<TestPost> response) {
                Log.i(TAG, "post Post - Body: " + response.body().getBody());
            }

            @Override
            public void onFailure(Call<TestPost> call, Throwable t) {
                Log.i(TAG, "post Post Failed");
            }
        });

        restClient.getApiService().getAllPost().enqueue(new Callback<TestPost[]>() {
            @Override
            public void onResponse(Call<TestPost[]> call, Response<TestPost[]> response) {
                Log.i(TAG, "Post: " + response.body().length
                );
            }

            @Override
            public void onFailure(Call<TestPost[]> call, Throwable t) {
                Log.i(TAG, "FAILUREEEE");
            }
        });
    }

    @OnClick(R.id.food_bar)
    public void feedPet(){

    }

    @OnClick(R.id.drink_bar)
    public void waterPet(){

    }

    @OnClick(R.id.sleep_bar)
    public void restPet(){

    }

    @OnClick(R.id.image_view)
    public void happinessView(){

    }

    @OnClick(R.id.hygiene_bar)
    public void cleanPet(){

    }

    @OnClick(R.id.pee_bar)
    public void drainPet(){

    }

    @OnClick(R.id.poop_bar)
    public void pottyPet(){

    }

    @OnClick(R.id.bank_amount)
    public void bankTotal(){

    }

    @OnClick(R.id.image_button2)
    public void increaseTime(){

    }

    @OnClick(R.id.clock)
    public void clock(){

    }
}
