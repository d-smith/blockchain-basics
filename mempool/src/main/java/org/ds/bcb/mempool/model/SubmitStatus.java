package org.ds.bcb.mempool.model;

import lombok.Data;

import java.time.Instant;

@Data
public class SubmitStatus {
    private Instant received;
}
