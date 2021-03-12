package com.amap.api.col.stln3;

/* compiled from: SerializerFeature */
public enum be {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue;
    
    public static final be[] x = new be[0];
    public final int w = (1 << ordinal());

    private be() {
    }

    public static int a(be[] beVarArr) {
        if (beVarArr == null) {
            return 0;
        }
        int i = 0;
        for (be beVar : beVarArr) {
            i |= beVar.w;
        }
        return i;
    }
}
