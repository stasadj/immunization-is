<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ns3="http://www.ftn.uns.ac.rs/interesovanje/"
                version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>Interesovanje</title>
                <style type="text/css">
                    body {
                    margin: 0;
                    font-family: Arial, sans-serif;
                    overflow-x: hidden;
                    }
                    h1 {
                    text-align: center;
                    padding: 20px;
                    font-weight: bold;
                    }
                    .indent-paragraph {
                    margin-left: 10vw;
                    font-size: 1.5em;
                    }
                    .indent-vaccine {
                    margin: 2px 0px 0px 20vw;
                    margin-left: 20vw;
                    font-size: 1.3em;
                    padding: 0px;
                    }
                    .indent-potpis {
                    border-top: 1px solid black;
                    width: 25%;
                    margin: 10px 0px 10vh 60%;
                    padding: 15px;
                    text-align: center;
                    }
                </style>
            </head>
            <body>
                <h1 style="margin-top: 10vh;">Iskazivanje interesovanja za vakcinisanje protiv COVID-19</h1>
                <xsl:if test="//ns3:drzavljanstvo/text() = 'srpsko'">
                    <p class="indent-paragraph">Drzavljanstvo:
                        <b>Drzavljanin Republike Srbije</b>
                    </p>
                </xsl:if>
                <xsl:if test="//ns3:drzavljanstvo/text() = 'strano sa boravkom'">
                    <p class="indent-paragraph">Drzavljanstvo:
                        <b>Strani drzavljanin sa boravkom u RS</b>
                    </p>
                </xsl:if>
                <xsl:if test="//ns3:drzavljanstvo/text() = 'strano bez boravka'">
                    <p class="indent-paragraph">Drzavljanstvo:
                        <b>Strani drzavljanin bez boravka u RS</b>
                    </p>
                </xsl:if>
                <xsl:choose>
                    <xsl:when test="string-length(//ns3:jmbg/text()) = 13">
                        <p class="indent-paragraph">JMBG:
                            <b>
                                <xsl:value-of select="concat(' ', //ns3:jmbg)"/>
                            </b>
                        </p>
                    </xsl:when>
                    <xsl:otherwise>
                        <p class="indent-paragraph">Broj pasosa:
                            <b>
                                <xsl:value-of select="concat(' ', //ns3:jmbg)"/>
                            </b>
                        </p>
                    </xsl:otherwise>
                </xsl:choose>
                <p class="indent-paragraph">Puno ime:
                    <b>
                        <xsl:value-of select="//ns3:puno_ime"/>
                    </b>
                </p>
                <p class="indent-paragraph">Adresa elektronske poste:
                    <b>
                        <xsl:value-of select="//ns3:email_adresa"/>
                    </b>
                </p>
                <p class="indent-paragraph">Broj mobilnog telefona (navesti broj u formatu 06X... bez razmaka i crtica):
                    <b>
                        <xsl:value-of select="//ns3:mobilni_telefon"/>
                    </b>
                </p>
                <p class="indent-paragraph">Broj fiksnog telefona (navesti broj u formatu (DDD) DDD-DDD):
                    <b>
                        <xsl:value-of select="//ns3:fiksni_telefon"/>
                    </b>
                </p>
                <p class="indent-paragraph">Lokacija:
                    <b>
                        <xsl:value-of select="//ns3:zeljena_opstina_vakcinacije"/>
                    </b>
                </p>
                <p class="indent-paragraph" style="margin-right: 10vw;">
                    Iskazujem interesovanje da primim iskljucivo vakcinu sledecih proizvodjaca za koji Agencija
                    za lekove i medicinska sredstva potvrdi bezbednost, efikasnost i kvalitet i izda dozvolu za upotrebu
                    leka:
                </p>
                <xsl:for-each select="//ns3:odabir_vakcina/ns3:opcija">
                    <p class="indent-vaccine">
                        <b>
                            <xsl:value-of select="text()"/>
                        </b>
                    </p>
                </xsl:for-each>
                <p class="indent-paragraph">Da li ste dobrovoljni davalac krvi:</p>
                <xsl:choose>
                    <xsl:when test="//ns3:dobrovoljni_davalac_krvi = true()">
                        <p class="indent-vaccine">
                            <b>Da</b>
                        </p>
                    </xsl:when>
                    <xsl:otherwise>
                        <p class="indent-vaccine">
                            <b>Ne</b>
                        </p>
                    </xsl:otherwise>
                </xsl:choose>
                <p class="indent-potpis">Potpis</p>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>