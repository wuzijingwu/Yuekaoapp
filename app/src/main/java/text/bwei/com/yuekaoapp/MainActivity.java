package text.bwei.com.yuekaoapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import text.bwei.com.yuekaoapp.utils.DownloadUtil;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = SecondActivity.class.getSimpleName();
    private ProgressBar mProgressBar;
    private Button start;
    private Button pause;
    private TextView total;

    private ProgressBar mProgressBar1;
    private Button start1;
    private Button pause1;
    private TextView total1;

    private ProgressBar mProgressBar2;
    private Button start2;
    private Button pause2;
    private TextView total2;


    private int max;
    private DownloadUtil mDownloadUtil1;
    private DownloadUtil mDownloadUtil2;
    private DownloadUtil mDownloadUtil;
    private Button jinru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jinru = (Button) findViewById(R.id.jinru);

        total = (TextView) findViewById(R.id.textView);
        start = (Button) findViewById(R.id.start);
        pause = (Button) findViewById(R.id.delete);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);


        total1 = (TextView) findViewById(R.id.textView1);
        start1 = (Button) findViewById(R.id.start1);
        pause1 = (Button) findViewById(R.id.delete1);
        mProgressBar1 = (ProgressBar) findViewById(R.id.progressBar1);


        total2 = (TextView) findViewById(R.id.textView2);
        start2 = (Button) findViewById(R.id.start2);
        pause2 = (Button) findViewById(R.id.delete2);
        mProgressBar2 = (ProgressBar) findViewById(R.id.progressBar2);

        String urlString = "http://mirror.aarnet.edu.au/pub/TED-talks/911Mothers_2010W-480p.mp4";
        String localPath = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/aaaaaaaaa";
        mDownloadUtil = new DownloadUtil(4, localPath, "adc.mp4", urlString,
                this);
        mDownloadUtil1 = new DownloadUtil(4, localPath, "adb.mp4", urlString,
                this);
        mDownloadUtil2 = new DownloadUtil(4, localPath, "add.mp4", urlString,
                this);
        mDownloadUtil.setOnDownloadListener(new DownloadUtil.OnDownloadListener() {

            @Override
            public void downloadStart(int fileSize) {
                // TODO Auto-generated method stub
                Log.w(TAG, "fileSize::" + fileSize);
                Toast.makeText(MainActivity.this, "开始下载", Toast.LENGTH_SHORT).show();
                max = fileSize;
                mProgressBar.setMax(fileSize);
            }

            @Override
            public void downloadProgress(int downloadedSize) {
                // TODO Auto-generated method stub
                Log.w(TAG, "Compelete::" + downloadedSize);
                mProgressBar.setProgress(downloadedSize);
                total.setText((int) downloadedSize * 100 / max + "%");
            }

            @Override
            public void downloadEnd() {
                // TODO Auto-generated method stub
                Log.w(TAG, "ENd");
                Toast.makeText(MainActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
            }
        });


        mDownloadUtil1.setOnDownloadListener(new DownloadUtil.OnDownloadListener() {

            @Override
            public void downloadStart(int fileSize) {
                // TODO Auto-generated method stub
                Log.w(TAG, "fileSize::" + fileSize);
                Toast.makeText(MainActivity.this, "开始下载", Toast.LENGTH_SHORT).show();
                max = fileSize;
                mProgressBar1.setMax(fileSize);
            }

            @Override
            public void downloadProgress(int downloadedSize) {
                // TODO Auto-generated method stub
                Log.w(TAG, "Compelete::" + downloadedSize);
                mProgressBar1.setProgress(downloadedSize);
                total1.setText((int) downloadedSize * 100 / max + "%");
            }

            @Override
            public void downloadEnd() {
                // TODO Auto-generated method stub
                Log.w(TAG, "ENd");
                Toast.makeText(MainActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
            }
        });

        mDownloadUtil2.setOnDownloadListener(new DownloadUtil.OnDownloadListener() {

            @Override
            public void downloadStart(int fileSize) {
                // TODO Auto-generated method stub
                Log.w(TAG, "fileSize::" + fileSize);
                Toast.makeText(MainActivity.this, "开始下载", Toast.LENGTH_SHORT).show();
                max = fileSize;
                mProgressBar2.setMax(fileSize);
            }

            @Override
            public void downloadProgress(int downloadedSize) {
                // TODO Auto-generated method stub
                Log.w(TAG, "Compelete::" + downloadedSize);
                mProgressBar2.setProgress(downloadedSize);
                total2.setText((int) downloadedSize * 100 / max + "%");
            }

            @Override
            public void downloadEnd() {
                // TODO Auto-generated method stub
                Log.w(TAG, "ENd");
                Toast.makeText(MainActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
            }
        });


        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                mDownloadUtil.start();

            }
        });

        start1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                mDownloadUtil1.start();

            }
        });

        start2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                mDownloadUtil2.start();

            }
        });


        pause.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                mDownloadUtil.pause();
                Toast.makeText(MainActivity.this, "下载已暂停", Toast.LENGTH_SHORT).show();
            }
        });

        pause1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                mDownloadUtil1.pause();
                Toast.makeText(MainActivity.this, "下载已暂停", Toast.LENGTH_SHORT).show();
            }
        });

        pause2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                mDownloadUtil2.pause();
                Toast.makeText(MainActivity.this, "下载已暂停", Toast.LENGTH_SHORT).show();
            }
        });


        jinru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });


    }
}
