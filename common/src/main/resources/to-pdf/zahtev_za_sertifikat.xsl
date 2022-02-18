<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:zaht="http://www.ftn.uns.ac.rs/zahtev-za-sertifikat/"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                        master-name="zahtev"
                        page-height="29.7cm"
                        page-width="21cm"
                        margin-top="1.3cm"
                        margin-bottom="2cm"
                        margin-left="3cm"
                        margin-right="3cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="zahtev">

                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="sans-serif" font-size="15px" margin-top="60px" font-weight="bold"
                              text-align="center">Z A H T E V
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="13px" padding="2px" font-weight="bold"
                              text-align="center">
                        za izdavanje digitalnog zelenog sertifikata
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="12px" padding="5px" margin-top="25px">
                        U skladu sa odredbom Republike Srbije o izdavanju digitalnog zelenog
                        sertifikata kao potvrde o izvrsenoj vakcinaciji protiv COVID-19, rezultatima testiranja na
                        zaraznu bolest SARS-CoV-2
                        ili oporavku od bolesti COVID-19, podnosim zahtev za izdavanje digitalnog zelenog sertifikata.
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="12px" padding="5px" margin-top="20px">
                        Podnosilac zahteva:
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="12px" padding="5px" margin-top="10px">
                        Ime i prezime:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="concat(' ', //zaht:ime_prezime)"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="12px" padding="5px">
                        Datum rodjenja:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="concat(' ', //zaht:datum_rodjenja)"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="12px" padding="5px">
                        Pol:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="concat(' ', //zaht:pol)"/>
                        </fo:inline>
                    </fo:block>
                    <xsl:choose>
                        <xsl:when test="string-length(//zaht:jmbg/text()) = 13">
                            <fo:block font-family="sans-serif" font-size="12px" padding="5px">
                                Jedinstveni maticni broj gradjanina:
                                <fo:inline font-weight="bold">
                                    <xsl:value-of select="concat(' ', //zaht:jmbg)"/>
                                </fo:inline>
                            </fo:block>
                        </xsl:when>
                        <xsl:otherwise>
                            <fo:block font-family="sans-serif" font-size="12px" padding="5px">
                                Broj pasosa:
                                <fo:inline font-weight="bold">
                                    <xsl:value-of select="concat(' ', //zaht:broj_pasosa)"/>
                                </fo:inline>
                            </fo:block>
                        </xsl:otherwise>
                    </xsl:choose>
                    <fo:block font-family="sans-serif" font-size="12px" padding="5px" margin-top="10px">
                        Razlog za podnosenje zahteva:
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="12px" padding="5px">
                        <xsl:value-of select="//zaht:razlog_za_podnosenje_zahteva"/>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="8px" padding="5px" text-align="center">
                        (navesti sto precizniji razlog za podnosenje zahteva za izdavanje digitalnog pasosa)
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="13px" padding="5px" margin-top="35px">
                        U
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="concat(' ', //zaht:mesto_izdavanja)"/>,
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="12px" padding="5px" margin-top="10px">
                        Datum:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="concat(' ', //zaht:datum_izdavanja)"/>
                        </fo:inline>
                    </fo:block>
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