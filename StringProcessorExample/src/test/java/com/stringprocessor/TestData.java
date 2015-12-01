package com.stringprocessor;

/**
 * Test Data
 */
public class TestData {
    public static final String TEST_CLEAN_TEXT = "abc 한글 123";
    public static final String TEST_BASE64_ENCODED_TEXT = "YWJjIO2VnOq4gCAxMjM=";

    public static final byte[] TEST_AES_KEY = "mysecret".getBytes();
    public static final String TEST_AES_ENCRYPTED_AND_BASE64_ENCODED_TEXT = "cKIzfR04N0taLGN8U+3ARA==";

    public static final byte TEST_XOR_KEY = (byte) 'a';
    public static final String TEST_XORED_AND_BASE64_ENCODED_TEXT = "AAMCQYz0/YvZ4UFQU1I=";
}
