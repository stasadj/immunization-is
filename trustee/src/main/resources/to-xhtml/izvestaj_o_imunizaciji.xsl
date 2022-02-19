<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:izve="http://www.ftn.uns.ac.rs/izvestaj-o-imunizaciji/"
                version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <style type="text/css">
                    body {
                        font-family: sans-serif;
                    }
                    #naslov {
                        font-size=24px;
                        font-weight:bold;
                        text-align:center;
                        margin-top: 10vh;
                    }
                    p {
                        margin-left: 35vw;
                    }
                    ul li {
                        margin-left: 35vw;
                    }
                    table {
                        border: 1px solid black;
                        text-align:center;
                        font-family:serif;
                        width: 30%;
                        margin-left: 35vw;
                    }
                    th, td {
                        border: 1px solid black;
                        text-align: center;
                        padding: 5px;
                    }
                    th {
                        border: 1px solid black;
                        font-family: sans-serif;
                        font-weight="bold";
                    }
                    tr {
                        border: 1px solid black;
                    }
                    #potpis {
                        border-top: 1px solid black;
                        width: 10%;
                        margin: 0px 0px 0px 54%;
                        padding: 15px;
                        text-align: center;
                    }
                </style>
            </head>
            <body>
                <h1 id = "naslov">Izveštaj o imunizaciji</h1>
                <p style = "padding-top:10px">Izvestaj se odnosi na period od
                    <b><xsl:value-of select="//izve:period_od"/></b> do
                    <b><xsl:value-of select="//izve:period_do"/></b>.
                </p>
                <p style = "padding-top:20px;">U napomenutom vremenskom intervalu je:
                    <ul list-style-type = "circle">
                        <li>Podneto <b><xsl:value-of select="//izve:broj_dokumenata_o_interesovanju"/></b> dokumenata o interesovanju za imunizaciju;
                        </li>
                        <li>Primljeno <b><xsl:value-of select="//izve:broj_zahteva_za_digitalni_sertifikat"/></b>
                            zahteva za digitalni zeleni sertifikat, od kojih je <b><xsl:value-of select="//izve:broj_izdatih_digitalnih_sertifikata"/></b>
                            izdato.
                        </li>
                    </ul>
                </p>
                <p style = "padding-top:10px">
                    Dato je <b><xsl:value-of select="//izve:raspodela_datih_vakcina_po_rednom_broju_doze/@ukupno_dato"/></b>
                    doza vakcine protiv COVID-19 virusa u sledecoj kolicini:
                </p>
                <table style = "border-spacing: 0; border-collapse: collapse;">
                    <tr>
                        <th>Redni broj doze</th>
                        <th>Broj datih doza</th>
                    </tr>
                    <xsl:for-each select="//izve:doza">
                        <tr>
                            <td><b><xsl:value-of select="izve:redni_broj"/></b></td>
                            <td><xsl:value-of select="izve:broj_datih_doza"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
                <p style = "padding-top:43px;">
                    Raspodela po proizvodjacima je:
                    <ul list-style-type = "circle">
                        <xsl:for-each select="//izve:proizvodjac">
                            <li>
                                <b><xsl:value-of select="concat(izve:naziv, ': ')"/></b>
                                <xsl:value-of select="izve:broj_datih_doza"/> doza
                            </li>
                        </xsl:for-each>
                    </ul>
                </p>
                <p style = "padding-top:100px;">
                    Datum izdavanja:
                    <u><xsl:value-of select="//izve:datum_izdavanja"/></u>
                    godine.
                </p>
                <p id="potpis">Potpis</p>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>