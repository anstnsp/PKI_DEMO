package com.aton.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;



@Getter
@RequiredArgsConstructor
public enum Gender implements UCPIDEnumType {
    UNKNOWN(-1),
    /**
     * 여성: 0
     */
    FEMALE(0),
    /**
     * 남성: 1
     */
    MALE(1);

   
    final private int code;

    public static Gender fromInt(final int code) {
        switch (code) {
            case 0: return FEMALE;
            case 1: return MALE;
            default: return UNKNOWN;
        }
    }
}
