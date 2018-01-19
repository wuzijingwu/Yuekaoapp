package text.bwei.com.yuekaoapp.api;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import text.bwei.com.yuekaoapp.bean.DatasBean;
import text.bwei.com.yuekaoapp.bean.MessageBean;




public interface ApiService {
    //    http://120.27.23.105/product/deleteCart?uid=72&pid=1
    @GET("product/getCarts")
    Flowable<MessageBean<List<DatasBean>>> getDatas(@Query("uid") String uid);
    @GET("product/deleteCart")
    Flowable<MessageBean> deleteData(@Query("uid") String uid, @Query("pid") String pid);
}