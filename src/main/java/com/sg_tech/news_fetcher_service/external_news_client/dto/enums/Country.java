package com.sg_tech.news_fetcher_service.external_news_client.dto.enums;

import org.springframework.stereotype.Component;

/**
 * Enum representing possible countries for filtering news sources / headlines.
 * Default is ALL (all countries).
 */

public enum Country {
    ae("ae"),
    ar("ar"),
    at("at"),
    au("au"),
    be("be"),
    bg("bg"),
    br("br"),
    ca("ca"),
    ch("ch"),
    cn("cn"),
    co("co"),
    cu("cu"),
    cz("cz"),
    de("de"),
    eg("eg"),
    fr("fr"),
    gb("gb"),
    gr("gr"),
    hk("hk"),
    hu("hu"),
    id("id"),
    ie("ie"),
    il("il"),
    in("in"),
    it("it"),
    jp("jp"),
    kr("kr"),
    lt("lt"),
    lv("lv"),
    ma("ma"),
    mx("mx"),
    my("my"),
    ng("ng"),
    nl("nl"),
    no("no"),
    nz("nz"),
    ph("ph"),
    pl("pl"),
    pt("pt"),
    ro("ro"),
    rs("rs"),
    ru("ru"),
    sa("sa"),
    se("se"),
    sg("sg"),
    si("si"),
    sk("sk"),
    th("th"),
    tr("tr"),
    tw("tw"),
    ua("ua"),
    us("us"),
    ve("ve"),
    za("za");

    private final String code;

    Country(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}