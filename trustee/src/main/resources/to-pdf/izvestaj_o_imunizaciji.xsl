<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:izve="http://www.ftn.uns.ac.rs/izvestaj-o-imunizaciji/"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="izvestaj-page">
                    <fo:region-body margin="0.75in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="izvestaj-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block text-align="center" font-family="sans-serif" font-size="24px" font-weight="bold" padding="10px">
                        Izvestaj o imunizaciji
                    </fo:block>
                    <fo:block font-size="13px" padding="10px">
                        <fo:inline>Izvestaj se odnosi na period od
                            <fo:inline font-weight="bold">
                                <xsl:value-of select="//izve:period_od"/>.
                            </fo:inline>do
                            <fo:inline font-weight="bold">
                                <xsl:value-of select="//izve:period_do"/>.
                            </fo:inline>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-size="13px" padding="20px">
                        <fo:inline>
                            U napomenutom vremenskom intervalu je:
                        </fo:inline>
                        <fo:list-block>
                            <fo:list-item>
                                <fo:list-item-label end-indent="label-end()">
                                    <fo:block>
                                        <fo:inline/>
                                    </fo:block>
                                </fo:list-item-label>
                                <fo:list-item-body start-indent="body-start()">
                                    <fo:block>
                                        <fo:inline>
                                            - Podneto
                                            <fo:inline font-weight="bold">
                                                <xsl:value-of select="//izve:broj_dokumenata_o_interesovanju"/>
                                            </fo:inline>
                                            dokumenata o interesovanju za imunizaciju;
                                        </fo:inline>
                                    </fo:block>
                                </fo:list-item-body>
                            </fo:list-item>
                            <fo:list-item>
                                <fo:list-item-label end-indent="label-end()">
                                    <fo:block>
                                        <fo:inline/>
                                    </fo:block>
                                </fo:list-item-label>
                                <fo:list-item-body start-indent="body-start()">
                                    <fo:block>
                                        <fo:inline>
                                            - Primljeno
                                            <fo:inline font-weight="bold">
                                                <xsl:value-of select="//izve:broj_zahteva_za_digitalni_sertifikat"/>
                                            </fo:inline>
                                            zahteva za digitalni zeleni sertifikat, od kojih je
                                            <fo:inline font-weight="bold">
                                                <xsl:value-of select="//izve:broj_izdatih_digitalnih_sertifikata"/>
                                            </fo:inline>
                                            izdato.
                                        </fo:inline>
                                    </fo:block>
                                </fo:list-item-body>
                            </fo:list-item>
                        </fo:list-block>
                    </fo:block>
                    <fo:block font-size="13px" padding="10px">
                        <fo:inline>
                            Dato je
                            <fo:inline font-weight="bold">
                                <xsl:value-of select="//izve:raspodela_datih_vakcina_po_rednom_broju_doze/@ukupno_dato"/>
                            </fo:inline>
                            doza vakcine protiv COVID-19 virusa u sledecoj kolicini:
                        </fo:inline>
                    </fo:block>
                    <fo:table text-align="center" font-family="serif" border="1px solid black">
                        <fo:table-column column-width="50%"/>
                        <fo:table-column column-width="50%"/>
                        <fo:table-body>
                            <fo:table-row border="1px solid black">
                                <fo:table-cell font-family="sans-serif" padding="10px" font-weight="bold" border="1px solid black">
                                    <fo:block>Redni broj doze</fo:block>
                                </fo:table-cell>
                                <fo:table-cell font-family="sans-serif" padding="10px" font-weight="bold" border="1px solid black">
                                    <fo:block>Broj datih doza</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <xsl:for-each select="//izve:doza">
                                <fo:table-row border="1px solid black">
                                    <fo:table-cell padding="10px" border="1px solid black">
                                        <fo:block font-weight="bold">
                                            <xsl:value-of select="//izve:redni_broj"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="10px" border="1px solid black">
                                        <fo:block>
                                            <xsl:value-of select="//izve:broj_datih_doza"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>
                    <fo:block font-size="13px" padding="43px">
                        <fo:inline>
                            Raspodela po proizvodjacima je:
                        </fo:inline>
                        <fo:list-block>
                            <xsl:for-each select="//izve:proizvodjac">
                                <fo:list-item>
                                    <fo:list-item-label end-indent="label-end()">
                                        <fo:block>
                                            <fo:inline/>
                                        </fo:block>
                                    </fo:list-item-label>
                                    <fo:list-item-body start-indent="body-start()">
                                        <fo:block>
                                            <fo:inline>
                                                <fo:inline font-family="Arial" font-weight="bold">
                                                    - <xsl:value-of select="//izve:naziv"/> -
                                                    <xsl:value-of select="//izve:broj_datih_doza"/>
                                                </fo:inline>
                                                doza;
                                            </fo:inline>
                                        </fo:block>
                                    </fo:list-item-body>
                                </fo:list-item>
                            </xsl:for-each>
                        </fo:list-block>
                    </fo:block>
                    <fo:block-container>
                        <fo:block font-size="13px">
                            <fo:inline>
                                Datum izdavanja:
                                <fo:inline text-decoration="underline">
                                    <xsl:value-of select="//izve:datum_izdavanja"/>
                                </fo:inline>
                                godine
                            </fo:inline>
                        </fo:block>
                        <fo:block-container width="40%" left="60%" top="0in" position="absolute">
                            <fo:block text-align = "center">
                                <fo:leader leader-pattern="rule" leader-length.minimum="2.5in" leader-length.optimum="2in" leader-length.maximum="3in"/>
                                <fo:block>Potpis</fo:block>
                            </fo:block>
                        </fo:block-container>
                    </fo:block-container>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>