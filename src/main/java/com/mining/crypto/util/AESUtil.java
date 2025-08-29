package com.mining.crypto.util;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import java.nio.charset.StandardCharsets;

public class AESUtil {

    public static String decrypt(String cipherText, String key) {
        return new SymmetricCrypto(SymmetricAlgorithm.AES, HexUtil.decodeHex(key)).decryptStr(cipherText, StandardCharsets.UTF_8);
    }
}