package text.bwei.com.yuekaoapp.model;


import io.reactivex.Flowable;
import text.bwei.com.yuekaoapp.bean.MessageBean;
import text.bwei.com.yuekaoapp.presenter.DelPresenter;
import text.bwei.com.yuekaoapp.utils.RetrofitUtils;

public class DelModel implements IModel {
    private DelPresenter presenter;

    public DelModel(DelPresenter presenter){
        this.presenter =  presenter;

    }
    @Override
    public void getData(String uid,String pid) {

        Flowable<MessageBean> delFlowable = RetrofitUtils.getInstance().getApiService().deleteData(uid,pid);
        presenter.delData(delFlowable);
    }
}