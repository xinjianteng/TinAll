package tin.browser.model.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import tin.browser.R;

/**
 * Created by Administrator on 2018/3/8.
 */

public class IndexNewsFrg extends Fragment{

    private static final String ARG_SECTION_NUMBER = "section_number";

    public IndexNewsFrg() {
    }

    public static IndexNewsFrg newInstance(int sectionNumber) {
        IndexNewsFrg fragment = new IndexNewsFrg();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.index_search_fragment, container, false);
        getArguments().getInt(ARG_SECTION_NUMBER);
        ImageView imageView= (ImageView) rootView.findViewById(R.id.img);
        x.image().bind(imageView,"");


        return rootView;
    }

}
