<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <xsl:template match="/">
        <html>
            <head />
            <body title="Base de Questões (E-valuation)">
                <span style="color:black; font-family:Verdana; font-size:18; font-weight:bold; ">Base de questões</span>
                <p>
                    <xsl:for-each select="Avaliacao">
                        <xsl:for-each select="identificacao">
                            <xsl:for-each select="titulo">
                                <span style="color:maroon; font-family:Verdana; font-size:14; font-weight:bold; ">
                                    <xsl:apply-templates />
                                </span>
                            </xsl:for-each>
                            <br />
                            <xsl:for-each select="copyright">
                                <span style="color:black; font-family:Arial; font-size:12; font-style:italic; ">Copyright (c) </span>
                                <span style="color:black; font-family:Arial; font-size:12; font-style:italic; ">2003</span>
                                <span style="font-family:Arial; font-size:12; font-style:italic; ">&#160;</span>
                                <span style="color:black; font-family:Arial; font-size:12; font-style:italic; ">
                                    <xsl:apply-templates />
                                </span>
                            </xsl:for-each>
                            <br />
                            <span style="font-family:Arial; font-size:12; ">fabio@inf.ufg.br</span>
                            <br />
                            <span style="color:black; font-family:arial; font-size:10; font-weight:bold; ">TODOS OS DIREITOS RESERVADOS.</span>
                        </xsl:for-each>
                    </xsl:for-each>
                    <xsl:for-each select="Avaliacao">
                        <br />
                        <br />
                        <span style="color:black; font-family:Verdana; font-weight:bold; ">Questões</span>
                        <br />
                        <br />
                        <xsl:for-each select="questao">
                            <hr color="black" size="1" />
                            <table border="0" width="100%">
                                <tbody>
                                    <tr>
                                        <td align="right" valign="baseline" width="22">
                                            <xsl:for-each select="@id">
                                                <span style="color:black; font-family:verdana; font-size:12; font-weight:bold; position:relative; ">
                                                    <xsl:value-of select="." />
                                                </span>
                                            </xsl:for-each>
                                        </td>
                                        <td colspan="6">
                                            <xsl:for-each select="introducao">
                                                <xsl:apply-templates />
                                            </xsl:for-each>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="22">
                                            <span style="font-family:Arial; font-size:10; ">resposta:</span>
                                        </td>
                                        <td colspan="6">
                                            <xsl:for-each select="resposta">
                                                <xsl:for-each select="@valor">
                                                    <span style="font-family:Verdana; font-size:12; font-weight:bold; ">
                                                        <xsl:value-of select="." />
                                                    </span>
                                                </xsl:for-each>
                                            </xsl:for-each>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="center" width="27">
                                            <span style="font-family:Arial; font-size:10; ">tipo:</span>
                                        </td>
                                        <td align="left" width="148">
                                            <xsl:for-each select="@tipo">
                                                <span style="font-family:Arial; font-size:10; ">
                                                    <xsl:value-of select="." />
                                                </span>
                                            </xsl:for-each>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="center" width="32">
                                            <span style="font-family:Arial; font-size:10; ">nível:</span>
                                        </td>
                                        <td align="left" width="127">
                                            <xsl:for-each select="@qi">
                                                <span style="font-family:Arial; font-size:10; ">
                                                    <xsl:value-of select="." />
                                                </span>
                                            </xsl:for-each>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="left" width="52">
                                            <span style="font-family:Arial; font-size:10; ">obs.:</span>
                                        </td>
                                        <td colspan="6">
                                            <xsl:for-each select="resposta">
                                                <xsl:apply-templates />
                                            </xsl:for-each>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="left" width="32">
                                            <span style="font-family:Arial; font-size:10; ">objetivo:</span>
                                        </td>
                                        <td>
                                            <xsl:for-each select="@objetivo">
                                                <xsl:value-of select="." />
                                            </xsl:for-each>
                                        </td>
                                        <td colspan="5" />
                                    </tr>
                                </tbody>
                            </table>
                        </xsl:for-each>
                        <hr color="black" size="1" />
                        <br />
                    </xsl:for-each>
                    <br />
                    <span style="font-family:Albany; font-size:10; ">Data: 21/07/2003</span>
                </p>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="bd">
        <span style="font-weight:bold; ">
            <xsl:apply-templates />
        </span>
    </xsl:template>
    <xsl:template match="it">
        <span style="font-style:italic; ">
            <xsl:apply-templates />
        </span>
    </xsl:template>
    <xsl:template match="java">
        <pre>
            <span style="font-family:Courier; font-size:12; ">
                <xsl:apply-templates />
            </span>
        </pre>
    </xsl:template>
    <xsl:template match="stmt">
        <span style="font-family:Courier; font-size:12; ">
            <xsl:apply-templates />
        </span>
    </xsl:template>
</xsl:stylesheet>
