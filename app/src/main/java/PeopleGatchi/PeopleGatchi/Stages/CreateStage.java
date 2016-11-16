package PeopleGatchi.PeopleGatchi.Stages;

/**
 * Created by sheamaynard on 11/16/16.
 */

public class CreateStage extends IndexedStage {

    protected CreateStage(String id) {
        super(id);
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public Rigger getRigger() {
        return null;
    }
}
