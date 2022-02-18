<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:zaht="http://www.ftn.uns.ac.rs/zahtev-za-sertifikat/"
                version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>Zahtev za zeleni sertifikat</title>
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
                <h1 style="margin-top: 10vh;">Z A H T E V</h1>
                <h2 style="text-align: center;">za izdavanje digitalnog zelenog sertifikata</h2>
                <p class="indent-paragraph">
                    U skladu sa odredbom Republike Srbije o izdavanju digitalnog zelenog
                    sertifikata kao potvrde o izvrsenoj vakcinaciji protiv COVID-19, rezultatima testiranja na zaraznu
                    bolest SARS-CoV-2
                    ili oporavku od bolesti COVID-19, podnosim zahtev za izdavanje digitalnog zelenog sertifikata.
                </p>
                <p class="indent-paragraph">Podnosilac zahteva:</p>
                <p class="indent-paragraph">Ime i prezime:
                    <b>
                        <xsl:value-of select="concat(' ', //zaht:ime_prezime)"/>
                    </b>
                </p>
                <p class="indent-paragraph">Datum rodjenja:
                    <b>
                        <xsl:value-of select="concat(' ', //zaht:datum_rodjenja)"/>
                    </b>
                </p>
                <p class="indent-paragraph">Pol:
                    <b>
                        <xsl:value-of select="concat(' ', //zaht:pol)"/>
                    </b>
                </p>
                <xsl:choose>
                    <xsl:when test="string-length(//zaht:jmbg/text()) = 13">
                        <p class="indent-paragraph">Jedinstveni maticni broj gradjanina:
                            <b>
                                <xsl:value-of select="concat(' ', //zaht:jmbg)"/>
                            </b>
                        </p>
                    </xsl:when>
                    <xsl:otherwise>
                        <p class="indent-paragraph">Broj pasosa:
                            <b>
                                <xsl:value-of select="concat(' ', //zaht:broj_pasosa)"/>
                            </b>
                        </p>
                    </xsl:otherwise>
                </xsl:choose>
                <p class="indent-paragraph">Razlog za podnosenje zahteva:</p>
                <p class="indent-paragraph">
                    <xsl:value-of select="//zaht:razlog_za_podnosenje_zahteva"/>
                </p>
                <p style="text-align: center; font-size: 1em;">(navesti sto precizniji razlog za podnosenje zahteva za
                    izdavanje digitalnog pasosa)
                </p>
                <p class="indent-paragraph">U
                    <b><xsl:value-of select="concat(' ', //zaht:mesto_izdavanja)"/>,
                    </b>
                </p>
                <p class="indent-paragraph">Datum:
                    <b>
                        <xsl:value-of select="concat(' ', //zaht:datum_izdavanja)"/>
                    </b>
                </p>
                <p class="indent-potpis">Potpis</p>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>