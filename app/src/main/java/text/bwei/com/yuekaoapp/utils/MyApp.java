package text.bwei.com.yuekaoapp.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import text.bwei.com.yuekaoapp.gen.DaoMaster;
import text.bwei.com.yuekaoapp.gen.DaoSession;
import text.bwei.com.yuekaoapp.gen.UserDao;



public class MyApp extends Application {
    public static UserDao userDao;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "lenvess.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();
    }
}