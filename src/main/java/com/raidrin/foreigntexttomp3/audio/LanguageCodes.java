package com.raidrin.foreigntexttomp3.audio;

public enum LanguageCodes {
    Spanish("es-US"),
    French("fr-FR"),
    Korean("ko-KR"),
    Japanese("ja-JP");

    private final String code;

    LanguageCodes(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
