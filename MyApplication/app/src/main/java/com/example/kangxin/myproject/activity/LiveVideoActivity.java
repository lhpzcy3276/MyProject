package com.example.kangxin.myproject.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.service.TCPServerService;
import com.example.kangxin.myproject.utils.LogUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.agora.rtc.Constants;
import io.agora.rtc.RtcEngine;
import io.agora.rtc.video.VideoCanvas;

public class LiveVideoActivity extends BaseActivity implements View.OnClickListener {
    final int MESSAGE_SOCKET_CONNECTED = 1;
    final int MESSAGE_RECEIVE_NEW_MSG = 2;
    Socket mClientSocket;
    PrintWriter mPrintWriter;

    private Button mSendButton;
    private TextView mMessageTextView;
    private EditText mMessageEditText;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MESSAGE_RECEIVE_NEW_MSG:
                    mMessageTextView.setText(mMessageTextView.getText().toString()+(String) msg.obj);
                    break;
                case MESSAGE_SOCKET_CONNECTED:
                    mSendButton.setEnabled(true);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_video);
        mMessageTextView = (TextView) findViewById(R.id.msg_container);
        mSendButton = (Button) findViewById(R.id.send);
        mSendButton.setOnClickListener(this);
        mMessageEditText = (EditText) findViewById(R.id.msg);

        Intent service=new Intent(this, TCPServerService.class);
        startService(service);


        new Thread(){
            @Override
            public void run() {
                super.run();
                connectTCPServer();
            }
        }.start();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mClientSocket!=null){
            try {
                mClientSocket.shutdownInput();
                mClientSocket.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }



    @Override
    public void onClick(View v) {
        System.out.println("打印数据------");
        new Thread(){
            @Override
            public void run() {
                super.run();
                String msg=mMessageEditText.getText().toString();
                if (!TextUtils.isEmpty(msg)&&mPrintWriter!=null){
                    mPrintWriter.println(msg);

                    mMessageEditText.post(new Runnable() {
                        @Override
                        public void run() {
                            mMessageEditText.setText("");
                        }
                    });
                    String time = formatDateTime(System.currentTimeMillis());
                    final String showedMsg = "self " + time + ":" + msg + "\n";

                    mMessageTextView.post(new Runnable() {
                        @Override
                        public void run() {
                            mMessageTextView.setText(mMessageTextView.getText() + showedMsg);
                        }
                    });
                }
            }
        }.start();
    }


    private void connectTCPServer() {
        Socket socket=null;
        while (socket==null){
            try {
                socket=new Socket("localhost",8688);
                mClientSocket=socket;
                mPrintWriter=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                mHandler.sendEmptyMessage(MESSAGE_SOCKET_CONNECTED);
                System.out.println("connect server success");
            } catch (IOException e) {
                SystemClock.sleep(1000);
                System.out.println("connect tcp server failed, retry...");
                e.printStackTrace();
            }

        }
            try {
            //接受服务器端的消息
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (!LiveVideoActivity.this.isFinishing()){
                String msg=br.readLine();
                System.out.println("receive:"+msg);
                if (msg!=null){
                    String time=formatDateTime(System.currentTimeMillis());
                    final String showedMsg = "server " + time + ":" + msg
                            + "\n";
                    mHandler.obtainMessage(MESSAGE_RECEIVE_NEW_MSG, showedMsg)
                            .sendToTarget();
                }
            }
                System.out.println("quit...");
                mPrintWriter.close();
                br.close();
                socket.close();
            }catch (Exception e){

            }


    }


    @SuppressLint("SimpleDateFormat")
    private String formatDateTime(long time) {
        return new SimpleDateFormat("(HH:mm:ss)").format(new Date(time));
    }
}
