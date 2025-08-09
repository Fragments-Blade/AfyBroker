package net.afyer.afybroker.velocity.processor;

import com.alipay.remoting.BizContext;
import com.alipay.remoting.rpc.protocol.SyncUserProcessor;
import com.velocitypowered.api.proxy.Player;
import lombok.AllArgsConstructor;
import net.afyer.afybroker.core.BrokerPlayerInformation;
import net.afyer.afybroker.core.message.RequestPlayerInfoMessage;
import net.afyer.afybroker.velocity.AfyBroker;

import java.util.*;

@AllArgsConstructor
public class RequestPlayerInfoVelocityProcessor extends SyncUserProcessor<RequestPlayerInfoMessage> {

    private final AfyBroker plugin;

    @Override
    public Object handleRequest(BizContext bizCtx, RequestPlayerInfoMessage request) throws Exception {
        List<BrokerPlayerInformation> list = new ArrayList<>();
        for (Player player : plugin.getServer().getAllPlayers()) {
            list.add(new BrokerPlayerInformation(player.getUniqueId(), player.getUsername(), player.getRemoteAddress().getAddress().getHostAddress()));
        }
        return list;
    }

    @Override
    public String interest() {
        return RequestPlayerInfoMessage.class.getName();
    }
}
