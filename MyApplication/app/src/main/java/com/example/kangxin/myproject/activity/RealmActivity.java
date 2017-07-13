package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.bean.Dog;
import com.example.kangxin.myproject.bean.User;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * realm使用  http://www.cnblogs.com/RaphetS/p/5996265.html
 */
public class RealmActivity extends Activity {
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);
        ButterKnife.bind(this);

        realm = Realm.getDefaultInstance();

    }
    @OnClick({R.id.activity_realm_textview1,R.id.activity_realm_textview2,R.id.activity_realm_textview3,R.id.activity_realm_textview4,R.id.activity_realm_textview5,R.id.activity_realm_textview6,R.id.activity_realm_textview7,R.id.activity_realm_textview8,
    R.id.realm_relativelayout})
    void myClick(View view){

        switch (view.getId()){
            case R.id.activity_realm_textview1:
                realm.beginTransaction();
                User user = realm.createObject(User.class,"001");
                user.setName("lhp");
                user.setEmail("17778115595@163.com");
                realm.commitTransaction();
                break;
            case R.id.activity_realm_textview2:
                User user1=new User();
                user1.setName("lhp1");
                user1.setEmail("767583696@qq.com");
                user1.setId("002");
                realm.beginTransaction();
                realm.copyFromRealm(user1);
                realm.commitTransaction();
                break;
            case R.id.activity_realm_textview3:
                final User user2=new User();
                user2.setName("lhp2");
                user2.setEmail("1935258842@qq.com");
                user2.setId("003");
                realm.executeTransaction(new Realm.Transaction(){
                    @Override
                    public void execute(Realm realm) {
                        realm.copyFromRealm(user2);
                    }
                });
                break;
            case R.id.activity_realm_textview4:
                final RealmResults<Dog> dogs=realm.where(Dog.class).findAll();
                realm.executeTransaction(new Realm.Transaction(){
                    @Override
                    public void execute(Realm realm) {
                        Dog dog=dogs.get(5);
                        dog.deleteFromRealm();
                        //删除第一个数据
                        dogs.deleteFirstFromRealm();
                        //删除最后一个数据
                        dogs.deleteLastFromRealm();
                        //删除位置为1的数据
                        dogs.deleteFromRealm(1);
                        //删除所有数据
                        dogs.deleteAllFromRealm();
                    }
                });
                break;
            case R.id.activity_realm_textview5:
                Dog dog=realm.where(Dog.class).equalTo("id",12212).findFirst();
                realm.beginTransaction();
                dog.setName("newName");
                realm.commitTransaction();
                break;
            case R.id.activity_realm_textview6:
                queryAllDog();
                break;
            case R.id.activity_realm_textview7:
                queryAllDog(12);
                break;
            case R.id.activity_realm_textview8:

                break;
            case R.id.realm_relativelayout:
                Toast.makeText(RealmActivity.this,"点击",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private Dog queryAllDog(int i) {
        Dog dog=realm.where(Dog.class).equalTo("id",i).findFirst();
        return dog;
    }

    private List<Dog> queryAllDog() {
        Toast.makeText(RealmActivity.this,"||===",Toast.LENGTH_SHORT).show();
        RealmResults<Dog> dogs=realm.where(Dog.class).findAll();
        Toast.makeText(RealmActivity.this,dogs.size()+"===",Toast.LENGTH_SHORT).show();
        return realm.copyFromRealm(dogs);
    }
}
