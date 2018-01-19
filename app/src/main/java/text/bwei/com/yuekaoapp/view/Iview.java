package text.bwei.com.yuekaoapp.view;


import text.bwei.com.yuekaoapp.bean.MessageBean;





public interface Iview {
    void onSuccess(Object o);
    void onFailed(Exception e);

    void delSuccess(MessageBean listMessageBean);
}