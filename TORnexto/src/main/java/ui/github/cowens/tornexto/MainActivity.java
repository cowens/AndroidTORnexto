package ui.github.cowens.tornexto;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.webkit.*;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        WebView wv = (WebView) findViewById(R.id.wv);

        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setBuiltInZoomControls(true);
        ws.setDisplayZoomControls(false);

        final ProgressBar pb = (ProgressBar) findViewById(R.id.pb);
        wv.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                // Activities and WebViews measure progress with different scales.
                // The progress meter will automatically disappear when we reach 100%
                pb.setProgress(progress);
                if (progress == 100) {
                    pb.setVisibility(View.GONE);
                }
            }
        });
        wv.setWebViewClient(new WebViewClient());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onClickNext(MenuItem m) {

        ProgressBar pb = (ProgressBar) findViewById(R.id.pb);
        pb.setProgress(0);
        pb.setVisibility(View.VISIBLE);
        WebView wv = (WebView) findViewById(R.id.wv);
        wv.loadUrl("http://tornexto.appspot.com/next?folder=comics");
    }
    
}
