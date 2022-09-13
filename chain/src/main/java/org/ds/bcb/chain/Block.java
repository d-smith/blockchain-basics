package org.ds.bcb.chain;

import lombok.Data;

import java.time.Instant;

@Data
public class Block {
    private Instant timestamp;
    private Integer nonce;
    private String previousHash;
    private String hash;
    private String data;

    public Block(String data, String previousHash, Instant timestamp) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.hash = hashBlock();
    }

    private String hashBlock() {
        // calculate a nonce such that the hash starts with two zeros
        nonce = 0;
        // todo calculate nonce to obtain the desired hash properties
        return "";
    }


}
