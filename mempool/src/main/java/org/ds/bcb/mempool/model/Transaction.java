package org.ds.bcb.mempool.model;

import lombok.Data;

import java.time.Instant;

@Data
public class Transaction {
    private Instant timestamp;
}
