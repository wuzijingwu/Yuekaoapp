package text.bwei.com.yuekaoapp.api;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import text.bwei.com.yuekaoapp.bean.DetailsBean;



public interface ApiServers {
    //    product/getProductDetail?pid=1
    @POST
    Observable<DetailsBean> getdataDetails(@Url String url, @QueryMap Map<String, Integer> map);
}