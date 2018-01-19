package text.bwei.com.yuekaoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import text.bwei.com.yuekaoapp.api.Apidetails;
import text.bwei.com.yuekaoapp.bean.DetailsBean;
import text.bwei.com.yuekaoapp.presenter.presenterDetails;
import text.bwei.com.yuekaoapp.view.Idetailsview;


public class ThreeActivity extends AppCompatActivity implements Idetailsview {

    @BindView(R.id.detail_banner)
    XBanner detail_banner;
    @BindView(R.id.details_title)
    TextView details_title;
    @BindView(R.id.details_text)
    TextView details_text;
    @BindView(R.id.details_price)
    TextView details_price;
    @BindView(R.id.buy_now)
    Button buy_now;
    @BindView(R.id.add_cart)
    Button add_cart;
    private text.bwei.com.yuekaoapp.presenter.presenterDetails presenterDetails;

    //    private int pid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
//        EventBus.getDefault().register(this);
        //应该获取pid
        presenterDetails = new presenterDetails(this);
        presenterDetails.getOkDetails(Apidetails.DETAILSURL, 5);
        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThreeActivity.this, FourActivity.class);
                startActivity(intent);
            }
        });

        add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ThreeActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });


    }


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenterDetails != null) {
            presenterDetails.Destory();
        }
    }

    @Override
    public void shouDetails(DetailsBean.DataBean list) {


        final List<String> img_list = new ArrayList<>();
        String images = list.getImages();
        String[] split = images.split("\\|");
        for (int i = 0; i < split.length; i++) {
            img_list.add(split[i]);
        }
        detail_banner.setData(img_list, null);
        detail_banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(ThreeActivity.this).load(img_list.get(position)).into((ImageView) view);
            }
        });


        details_title.setText(list.getTitle());
        details_text.setText(list.getSubhead());
        details_price.setText(list.getPrice());


    }
}