package org.ds.bcb.hashing;


import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class App
{
    public static void main( String[] args ) throws Exception {
        var message = "Hello World!";
        System.out.println( "Hello World!" );

        sha256(message);
        keccak256(message);
    }

    private static void sha256(String message) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(
                message.getBytes(StandardCharsets.UTF_8));
        String sha256hex = new String(Hex.encode(hash));

        System.out.println(sha256hex);
    }

    private static void keccak256(String message) throws Exception {
        Keccak.Digest256 digest256 = new Keccak.Digest256();
        byte[] hashbytes = digest256.digest(
                message.getBytes(StandardCharsets.UTF_8));
        String sha3Hex = new String(Hex.encode(hashbytes));
        System.out.println(sha3Hex);
    }
}
