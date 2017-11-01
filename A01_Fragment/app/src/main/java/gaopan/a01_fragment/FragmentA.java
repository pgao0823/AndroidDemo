package gaopan.a01_fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by gaopan on 2017/10/31.
 */

public class FragmentA extends Fragment {

    private static String ARG_PARAM = "param_key";
    private String mParam;
    private Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        mParam = getArguments().getString(ARG_PARAM);
    }
//    Fragment有很多可以复写的方法，其中最常用的就是onCreateView()，该方法返回Fragment的UI布局，需要注意的是inflate()的第三个参数是false，
//    因为在Fragment内部实现中，会把该布局添加到container中，如果设为true，那么就会重复做两次添加，则会抛如下异常：
//    Caused by: java.lang.IllegalStateException: The specified child already has a parent. You must call removeView() on the child's parent first.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mfragment = inflater.inflate(R.layout.fragment, container, false);
        TextView text = mfragment.findViewById(R.id.tv1);
        text.setText(mParam);
        return mfragment;
    }
//    如果在创建Fragment时要传入参数，必须要通过setArguments(Bundle bundle)方式添加，而不建议通过为Fragment添加带参数的构造函数，
//    因为通过setArguments()方式添加，在由于内存紧张导致Fragment被系统杀掉并恢复（re-instantiate）时能保留这些数据。官方建议如下：
//    It is strongly recommended that subclasses do not have other constructors with parameters, since these constructors will not be called when the fragment is re-instantiated.
//    我们可以在Fragment的onAttach()中通过getArguments()获得传进来的参数，并在之后使用这些参数。如果要获取Activity对象，不建议调用getActivity()，
//    而是在onAttach()中将Context对象强转为Activity对象。
    public static FragmentA newInstance(String str){
        FragmentA fragmentA = new FragmentA();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM,str);
        fragmentA.setArguments(bundle);
        return fragmentA;
    }
}
