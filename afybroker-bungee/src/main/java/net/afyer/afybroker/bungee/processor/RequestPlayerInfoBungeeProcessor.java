package net.afyer.afybroker.bungee.processor;

import com.alipay.remoting.BizContext;
import com.alipay.remoting.rpc.protocol.SyncUserProcessor;
import net.afyer.afybroker.core.BrokerPlayerInformation;
import net.afyer.afybroker.core.message.RequestPlayerInfoMessage;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.net.InetSocketAddress;
import java.util.*;

public class RequestPlayerInfoBungeeProcessor extends SyncUserProcessor<RequestPlayerInfoMessage> {
    @Override
    public Object handleRequest(BizContext bizCtx, RequestPlayerInfoMessage request) {
        List<BrokerPlayerInformation> list = new ArrayList<>();
        for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
            InetSocketAddress socketAddress = (InetSocketAddress) player.getSocketAddress();
            String ip = socketAddress.getAddress().getHostAddress();
            list.add(new BrokerPlayerInformation(player.getUniqueId(), player.getName(), ip));
        }
        return list;
    }

    @Override
    public String interest() {
        return RequestPlayerInfoMessage.class.getName();
    }
}
