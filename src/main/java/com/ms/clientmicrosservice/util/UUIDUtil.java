package com.ms.clientmicrosservice.util;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

public class UUIDUtil {

    public static UUID fromBase64(String base64) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        ByteBuffer byteBuffer = ByteBuffer.wrap(decodedBytes);
        long mostSigBits = byteBuffer.getLong();
        long leastSigBits = byteBuffer.getLong();
        return new UUID(mostSigBits, leastSigBits);
    }
}