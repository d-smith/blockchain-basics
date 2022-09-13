package org.ds.bcb.chain;

import lombok.Data;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;

@Data
public class Block {
    private Instant timestamp;
    private Integer nonce;
    private String previousHash;
    private String hash;
    private String data;

    public Block(String data, String previousHash, Instant timestamp) throws Exception {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.nonce = 0;
        this.hash = computeBlockHash();
    }

    public String mineBlock() throws Exception {
        int prefixLength = 3;
        String prefixString = new String(new char[prefixLength]).replace('\0', '0');
        while (!hash.substring(0, prefixLength)
                .equals(prefixString)) {
            nonce++;
            hash = computeBlockHash();
        }
        return hash;
    }

    private String computeBlockHash() throws Exception {
        String message = data + previousHash + timestamp.toString() + Integer.toString(nonce);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] theHash = digest.digest(
                message.getBytes(StandardCharsets.UTF_8));

        StringBuffer buffer = new StringBuffer();
        for (byte b : theHash) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }




}
