package org.ds.bcb.mempool.controller;

import lombok.extern.log4j.Log4j2;
import org.ds.bcb.mempool.model.SubmitStatus;
import org.ds.bcb.mempool.model.Transaction;
import org.ds.bcb.mempool.p2pnetwork.NetworkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@Log4j2
@RestController
@RequestMapping("/transaction/v1/submit")
public class MempoolController {

    @Autowired
    private NetworkingService networkingService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public SubmitStatus submitTxn(@RequestBody final Transaction txn) throws Exception {
        log.info("submit txn called - {}", txn);

        networkingService.broadcastTxn(txn);

        var submitStatus = new SubmitStatus();
        submitStatus.setReceived(Instant.now());
        return submitStatus;
    }

}
