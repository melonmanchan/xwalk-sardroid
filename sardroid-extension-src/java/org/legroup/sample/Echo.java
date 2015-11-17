package org.legroup.sample;

import org.xwalk.app.runtime.extension.XWalkExtensionClient;
import org.xwalk.app.runtime.extension.XWalkExtensionContextClient;
import com.google.gson.Gson;

public class Echo extends XWalkExtensionClient {
    private Gson gson = new Gson();

    public Echo(String name, String jsApiContent, XWalkExtensionContextClient xwalkContext) {
        super(name, jsApiContent, xwalkContext);
    }

    private String echo(String requestJson) {
        Message request = gson.fromJson(requestJson, Message.class);
        String reply = "You said: " + request.content;
        Message response = new Message(request.id, reply);
        return gson.toJson(response);
    }

    @Override
    public void onMessage(int instanceId, String requestJson) {
        postMessage(instanceId, echo(requestJson));
    }

    @Override
    public String onSyncMessage(int instanceId, String requestJson) {
        return echo(requestJson);
    }
}
