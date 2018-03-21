package readbook.rxdemo.activity;


import android.app.Activity;
import android.os.Bundle;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import readbook.rxdemo.R;

/**
 * 
 * @author Mr.Z
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		Observable.create(new ObservableOnSubscribe<Integer>() {
			@Override
			public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
			}
		}).subscribe(new Observer<Integer>() {
			@Override
			public void onSubscribe(@NonNull Disposable d) {

			}

			@Override
			public void onNext(@NonNull Integer integer) {

			}

			@Override
			public void onError(@NonNull Throwable e) {

			}

			@Override
			public void onComplete() {

			}
		});

	}

}
