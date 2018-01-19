package text.bwei.com.yuekaoapp.model;

import java.util.List;

import io.reactivex.Flowable;
import text.bwei.com.yuekaoapp.bean.DatasBean;
import text.bwei.com.yuekaoapp.bean.MessageBean;
import text.bwei.com.yuekaoapp.presenter.NewsPresenter;
import text.bwei.com.yuekaoapp.utils.RetrofitUtils;


public class NewsModel implements IModel {
    private NewsPresenter presenter;

    public NewsModel(NewsPresenter presenter) {
        this.presenter = (NewsPresenter) presenter;

    }

    @Override
    public void getData(String uid, String pid) {
        Flowable<MessageBean<List<DatasBean>>> flowable = RetrofitUtils.getInstance().getApiService().getDatas(uid);
        presenter.getNews(flowable);

    }
}