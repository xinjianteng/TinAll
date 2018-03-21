package tin.browser.model.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tin.browser.R;

/**
 * Created by Administrator on 2018/3/8.
 */
public class IndexSerarchFrg extends Fragment{

    private static final String SELECT_TAB = "select_tab";

    public IndexSerarchFrg() {
    }

    public static IndexSerarchFrg newInstance(int sectionNumber) {
        IndexSerarchFrg fragment = new IndexSerarchFrg();
        Bundle args = new Bundle();
        args.putInt(SELECT_TAB, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getArguments().getInt(SELECT_TAB);
        View rootView = inflater.inflate(R.layout.index_search_fragment, container, false);
        return rootView;
    }




}
