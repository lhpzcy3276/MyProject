package com.example.kangxin.myproject.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.kangxin.myproject.utils.LogUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Created by kangxin on 2018/1/12.
 */

public class TCPServerService extends Service {
    private boolean mIsServiceDestoryed = false;
    private String[] mDefinedMessages = new String[] { "你 好 啊， 哈 哈", "请 问 你 叫 什 么 名 字 呀？", "今 天 北 京 天 气 不 错 啊， shy", "你 知 道 吗？ 我 可 是 可 以 和 多 个 人 同 时 聊 天 的 哦", "给 你 讲 个 笑 话 吧： 据据 说 爱 笑 的 人 运 气 不 会 太 差， 不 知 道 真 假。" };

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new TCPServer()).start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        mIsServiceDestoryed=true;
        super.onDestroy();

    }

    class TCPServer implements Runnable{

        @Override
        public void run() {
            ServerSocket serverSocket=null;
            try {
                //监听本地8688断口
                serverSocket=new ServerSocket(8688);
                System.out.println("-----"+serverSocket.isClosed());

            }catch (Exception e){
                System.err.println(" establish tcp server failed, port: 8688");
                e.printStackTrace();
                return;
            }
            while (!mIsServiceDestoryed){
                try {
                    //接受客户端请求
                    final Socket client=serverSocket.accept();
                    System.out.println("accept");

                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            try {
                                responseClient(client);
                            }catch (Exception e){
                                e.printStackTrace();
                            }

                        }
                    }.start();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    private void responseClient(Socket client) throws Exception {
        //用于接受客户端消息
        BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
        //用于向客户端发送消息
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())),true);

        out.println("欢迎来到聊天室");
        while (!mIsServiceDestoryed){
            String str=in.readLine();
            System.out.println(" msg from client:" + str);
            if (str==null){
                //客户端断开连接
                break;
            }
            int i=new Random().nextInt(mDefinedMessages.length);
            String msg=mDefinedMessages[i];
            out.println(msg);
            System.out.println(" send :" + msg);

        }
        System.out.println(" client quit.");

        //关闭流
        out.close();
        in.close();
        client.close();

    }
}
