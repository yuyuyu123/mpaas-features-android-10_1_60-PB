package com.aliyun.mpaas.demo.android60.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alipay.mobile.framework.service.common.RpcService;
import com.aliyun.mpaas.demo.android60.launcher.request.PathMpaasMgsHttpPostQuerystrPostReq;
import com.mpaas.framework.adapter.api.MPFramework;

public class MainActivity extends Activity {

    private TextView tvLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.aliyun.mpaas.demo.android60.launcher.R.layout.main);
        tvLog = findViewById(R.id.tvLog);
    }

    public void button1Clicked(View view)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                RpcService rpcService = MPFramework.getExternalService(RpcService.class.getName());
                Demo_BackendServerClient client = rpcService.getRpcProxy(Demo_BackendServerClient.class);
                PathMpaasMgsHttpPostQuerystrPostReq req = new PathMpaasMgsHttpPostQuerystrPostReq();
                req.querystring1 = "123";
                String result = client.pathMpaasMgsHttpPostQuerystrPost(req);
                Util.log(MainActivity.this,tvLog,result);
            }
        }).start();
    }
}
