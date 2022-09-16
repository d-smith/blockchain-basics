package org.ds.bcb.mempool.p2pnetwork;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.ds.bcb.mempool.model.Transaction;
import org.jgroups.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class NetworkingService implements Receiver {
    private JChannel jChannel;

    public static final String CLUSTER_NAME="bcbpool";

    @Autowired
    public NetworkingService() throws Exception {
        log.info("service is alive");
        jChannel = new JChannel("src/main/resources/udp.xml");
        jChannel.setReceiver(this);
        jChannel.connect(CLUSTER_NAME);
    }

    @Override
    public void viewAccepted(View view) {
        log.info("view received - {}", view);
    }

    @Override
    public void receive(Message msg) {
        log.info("message received - {}", msg);
        Transaction t = (Transaction) msg.getObject();
        log.info("received transaction object");
    }

    public void broadcastTxn(Transaction txn) throws Exception {
        var message = new ObjectMessage(null,txn);
        jChannel.send(message);
    }
}
