package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.icu.text.SymbolTable;
import android.os.SystemClock;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.kangxin.myproject.App;
import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.bean.Dog;
import com.example.kangxin.myproject.bean.User;
import com.example.kangxin.myproject.utils.ThreadPoolUtils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmChangeListener;
import io.realm.RealmModel;
import io.realm.RealmResults;

/**
 * realm使用  http://www.cnblogs.com/RaphetS/p/5996265.html
 */
public class RealmActivity extends Activity {
     Realm realm8=Realm.getDefaultInstance();
    int id=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);
        ButterKnife.bind(this);


    }
    @OnClick({R.id.activity_realm_textview1,R.id.activity_realm_textview2,R.id.activity_realm_textview3,R.id.activity_realm_textview4,R.id.activity_realm_textview5,R.id.activity_realm_textview6,R.id.activity_realm_textview7,R.id.activity_realm_textview8,
    R.id.realm_relativelayout})
    void myClick(View view){

        switch (view.getId()){
            case R.id.activity_realm_textview1:
                RealmAsyncTask task=realm8.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        User user1=new User();
                        user1.setName("lhp1");
                        user1.setEmail("767583696@qq.com");
                        user1.setId(id+"");
                        realm.copyToRealmOrUpdate(user1);
                        id++;
                    }
                },new Realm.Transaction.OnSuccess(){
                    @Override
                    public void onSuccess() {
                        Log.d("realm数据库1","添加数据成功");
                    }
                },new Realm.Transaction.OnError(){
                    @Override
                    public void onError(Throwable error) {
                        Log.d("realm数据库1","添加数据失败");
                    }
                });
                break;
            case R.id.activity_realm_textview2:
               RealmAsyncTask deleteTask=realm8.executeTransactionAsync(new Realm.Transaction() {
                   @Override
                   public void execute(Realm realm) {
                       int num=id-1;
                       User user = realm.where(User.class).equalTo("id", 1+"").findFirst();
                       user.deleteFromRealm();

                   }
               }, new Realm.Transaction.OnSuccess() {
                   @Override
                   public void onSuccess() {
                       id--;
                       Log.d("realm数据库2","删除数据成功");
                   }
               }, new Realm.Transaction.OnError() {
                   @Override
                   public void onError(Throwable error) {
                       Log.d("realm数据库2","删除数据失败"+error.getMessage());
                   }
               });
                break;
            case R.id.activity_realm_textview3:
                RealmAsyncTask task3=realm8.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        RealmResults<User> all = realm8.where(User.class).findAll();
                        all.deleteAllFromRealm();
                    }
                },new Realm.Transaction.OnSuccess(){
                    @Override
                    public void onSuccess() {
                        Log.d("realm数据库3","删除全部数据成功");
                    }
                },new Realm.Transaction.OnError(){
                    @Override
                    public void onError(Throwable error) {
                        Log.d("realm数据库3",error.getMessage()+"删除全部数据失败"+error.getMessage());
                    }
                });
                break;
            case R.id.activity_realm_textview4:
                RealmAsyncTask updateTask=realm8.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        int num=id-1;
                        User user = realm8.where(User.class).equalTo("id", num+"").findFirst();
                        user.setName("update"+num);

                    }
                },new Realm.Transaction.OnSuccess(){
                    @Override
                    public void onSuccess() {
                        Log.d("realm数据库4","删除全部数据成功");
                    }
                },new Realm.Transaction.OnError(){
                    @Override
                    public void onError(Throwable error) {
                        Log.d("realm数据库4",error.getMessage()+"删除全部数据失败"+error.getMessage());
                    }
                });
                break;
            case R.id.activity_realm_textview5:
                int num=id-1;
                 final User user = realm8.where(User.class).equalTo("id", num+"").findFirstAsync();
                user.addChangeListener(new RealmChangeListener<RealmModel>() {
                    @Override
                    public void onChange(RealmModel element) {
                        Log.d("realm数据库5",user.toString()+"");
                    }
                });

                break;
            case R.id.activity_realm_textview6:
                RealmResults<User> allAsync = realm8.where(User.class).findAllAsync();
                allAsync.addChangeListener(new RealmChangeListener<RealmResults<User>>() {
                    @Override
                    public void onChange(RealmResults<User> element) {
                        element=element.sort("id");
                        List<User> users = realm8.copyFromRealm(element);
                        for (int i=0;i<users.size();i++){
                            Log.d("realm数据库6",users.get(i).toString());
                        }
                    }
                });
                break;
            case R.id.activity_realm_textview7:
                int num1=id-1;
                final User resultUser = realm8.where(User.class).equalTo("id", num1+"").findFirstAsync();
                resultUser.addChangeListener(new RealmChangeListener<RealmModel>() {
                    @Override
                    public void onChange(RealmModel element) {
                        Log.d("realm数据库5",resultUser.toString()+"");

                    }
                });
                break;
            case R.id.activity_realm_textview8:
                RealmAsyncTask task1=realm8.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        RealmResults<User> users=realm8.where(User.class).findAll();
                        users.deleteAllFromRealm();
                    }
                }, new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(App.getInstance(),"删除数据成功",Toast.LENGTH_SHORT).show();
                    }
                }, new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {
                        Log.d("删除数据失败",error.getMessage());
                    }
                });
                break;
            case R.id.realm_relativelayout:
                Toast.makeText(RealmActivity.this,"点击",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private Dog queryAllDog(int i) {
        Realm realm=Realm.getDefaultInstance();
        Dog dog=realm.where(Dog.class).equalTo("id",i).findFirst();
        return dog;
    }

}
