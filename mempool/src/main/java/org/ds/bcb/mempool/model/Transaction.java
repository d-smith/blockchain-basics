package org.ds.bcb.mempool.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
public class Transaction implements Serializable {
    private String source;
    private String destination;
    private BigDecimal amount;
    private BigDecimal fee;
    private Long nonce;
}
