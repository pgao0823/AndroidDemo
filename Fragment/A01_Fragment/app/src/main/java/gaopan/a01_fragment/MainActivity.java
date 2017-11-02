package gaopan.a01_fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sentArgA(View v){
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frag, FragmentA.newInstance("AAA"),"fa")
                .addToBackStack(FragmentA.class.getSimpleName())
                .commit();
    }
    public void sentArgB(View v){
        getSupportFragmentManager()
                .beginTransaction()
//                .add(R.id.frag, FragmentA.newInstance("BBB"),"fb")
                .replace(R.id.frag,FragmentA.newInstance("BBB"),"fb")
                .addToBackStack(FragmentA.class.getSimpleName())
                .commit();
    }
    public void popBack(View v){
        getFragmentManager()
                .popBackStack(FragmentA.class.getSimpleName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}
