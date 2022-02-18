<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:inte="http://www.ftn.uns.ac.rs/interesovanje/"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                        master-name="interesovanje"
                        page-height="29.7cm"
                        page-width="21cm"
                        margin-top="2.5cm"
                        margin-bottom="2cm"
                        margin-left="2cm"
                        margin-right="2cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="interesovanje">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="sans-serif" font-size="15px" font-weight="bold" padding="20px"
                              text-align="center">
                        Iskazivanje interesovanja za vakcinisanje protiv COVID-19
                    </fo:block>
                    <xsl:if test="//inte:drzavljanstvo/text() = 'srpsko'">
                        <fo:block font-size="13px" padding="10px">
                            Drzavljanstvo:
                            <fo:inline font-weight="bold">Drzavljanin Republike Srbije</fo:inline>
                        </fo:block>
                    </xsl:if>
                    <xsl:if test="//inte:drzavljanstvo/text() = 'strano sa boravkom'">
                        <fo:block font-size="13px" padding="10px">
                            Drzavljanstvo:
                            <fo:inline font-weight="bold">Strani drzavljanin sa boravkom u RS</fo:inline>
                        </fo:block>
                    </xsl:if>
                    <xsl:if test="//inte:drzavljanstvo/text() = 'strano bez boravka'">
                        <fo:block font-size="13px" padding="10px">
                            Drzavljanstvo:
                            <fo:inline font-weight="bold">Strani drzavljanin bez boravka u RS</fo:inline>
                        </fo:block>
                    </xsl:if>
                    <xsl:choose>
                        <xsl:when test="string-length(//inte:jmbg/text()) = 13">
                            <fo:block font-family="sans-serif" font-size="13px" padding="10px">
                                JMBG:
                                <fo:inline font-weight="bold">
                                    <xsl:value-of select="concat(' ', //inte:jmbg)"/>
                                </fo:inline>
                            </fo:block>
                        </xsl:when>
                        <xsl:otherwise>
                            <fo:block font-family="sans-serif" font-size="13px" padding="10px">
                                Broj pasosa:
                                <fo:inline font-weight="bold">
                                    <xsl:value-of select="concat(' ', //inte:jmbg)"/>
                                </fo:inline>
                            </fo:block>
                        </xsl:otherwise>
                    </xsl:choose>
                    <fo:block font-size="13px" padding="10px">
                        Ime:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="//inte:puno_ime"/>
                        </fo:inline>
                    </fo:block>

                    <fo:block font-size="13px" padding="10px">
                        Adresa elektronske poste:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="//inte:email_adresa"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-size="13px" padding="10px">
                        Broj mobilnog telefona (navesti broj u formatu 06X... bez razmaka i crtica):
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="//inte:mobilni_telefon"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-size="13px" padding="10px">
                        Broj fiksnog telefona (navesti broj u formatu (DDD) DDD-DDD):
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="//inte:fiksni_telefon"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-size="13px" padding="10px">
                        Lokacija:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="//inte:zeljena_opstina_vakcinacije"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="13px" padding="20px">
                        Iskazujem interesovanje da primim iskljucivo vakcinu sledecih proizvodjaca za koji Agencija
                        za lekove i medicinska sredstva potvrdi bezbednost, efikasnost i kvalitet i izda dozvolu za
                        upotrebu leka:
                    </fo:block>
                    <xsl:for-each select="//inte:odabir_vakcina/inte:opcija">
                        <fo:block font-size="13px" text-indent="40px" padding="2px" margin="0">
                            <fo:inline font-weight="bold">
                                <xsl:value-of select="text()"/>
                            </fo:inline>
                        </fo:block>
                    </xsl:for-each>
                    <fo:block font-family="sans-serif" font-size="13px" padding="20px">
                        Da li ste dobrovoljni davalac krvi:
                    </fo:block>
                    <xsl:choose>
                        <xsl:when test="//inte:dobrovoljni_davalac_krvi = true()">
                            <fo:block font-size="13px" text-indent="40px" padding="2px" margin="0">
                                <fo:inline font-weight="bold">Da</fo:inline>
                            </fo:block>
                        </xsl:when>
                        <xsl:otherwise>
                            <fo:block font-size="13px" text-indent="40px" padding="2px" margin="0">
                                <fo:inline font-weight="bold">Ne</fo:inline>
                            </fo:block>
                        </xsl:otherwise>
                    </xsl:choose>
                    <fo:block-container>
                        <fo:block-container width="40%" left="60%" top="0in" position="absolute">
                            <fo:block font-family="sans-serif" font-size="12px" text-align="center"
                                      linefeed-treatment="preserve" margin="0" border-top="1px solid black">
                                Potpis
                            </fo:block>
                        </fo:block-container>
                    </fo:block-container>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>