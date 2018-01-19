package text.bwei.com.yuekaoapp.presenter;


import text.bwei.com.yuekaoapp.bean.DetailsBean;
import text.bwei.com.yuekaoapp.model.Idetailsmodel;
import text.bwei.com.yuekaoapp.model.OnselectDetails;
import text.bwei.com.yuekaoapp.model.model;
import text.bwei.com.yuekaoapp.view.Idetailsview;


public class presenterDetails {
    Idetailsview idetailsview;
    Idetailsmodel idetailsmodel;

    public presenterDetails(Idetailsview idetailsview) {
        this.idetailsview = idetailsview;
        idetailsmodel = new model();
    }


    public void Destory(){
        if (idetailsview != null) {
            idetailsview = null;
        }

    }






    public void getOkDetails(String url, int pid) {
        idetailsmodel.RequestDetails(url, pid, new OnselectDetails() {
            @Override
            public void dataDetailsSuccess(DetailsBean.DataBean list) {
                idetailsview.shouDetails(list);
            }
        });

    }


}