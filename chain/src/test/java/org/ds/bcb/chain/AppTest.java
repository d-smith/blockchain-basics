package org.ds.bcb.chain;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
public class AppTest
{
    @Test
    public void testBlockCreate() throws Exception {
        Block block = new Block("some data","", Instant.now());
        log.info("block is {}", block);
        assertNotNull(block.getHash());
        assertFalse("".equals(block.getHash()));
    }

    @Test
    public void testMineBlock() throws Exception {
        Block block = new Block("some data","", Instant.now());
        var initialHash = block.getHash();
        log.info("block is {}", block);

        var hash = block.mineBlock();
        log.info("mined block is {}", block);
        assertFalse(block.getHash().equals(initialHash));
        assertTrue(block.getNonce() > 0);
    }
}
