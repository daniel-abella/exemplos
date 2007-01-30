<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <xsl:template match="/">
        <html>
            <head />
            <body title="Base de Questões (E-valuation">
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
                                <span style="color:black; font-family:Arial; font-size:12; font-style:italic; ">Copyright (c) 2003</span>
                                <span style="font-family:Arial; font-size:12; font-style:italic; ">&#160;</span>
                                <span style="color:black; font-family:Arial; font-size:12; font-style:italic; ">
                                    <xsl:apply-templates />
                                </span>
                            </xsl:for-each>
                            <br />
                            <span style="color:black; font-family:arial; font-size:10; font-weight:bold; ">TODOS OS DIREITOS RESERVADOS.</span>
                        </xsl:for-each>
                    </xsl:for-each>
                    <xsl:for-each select="Avaliacao">
                        <br />
                        <br />
                        <span style="color:black; font-family:Verdana; font-weight:bold; ">Histórico de alterações</span>
                        <br />
                        <br />
                        <p>
                            <xsl:for-each select="historico">
                                <xsl:for-each select="evento">
                                    <xsl:if test="position()=1">
                                        <table border="1">
                                            <thead>
                                                <tr>
                                                    <td align="center">
                                                        <span style="font-family:Arial; font-size:12; ">data</span>
                                                    </td>
                                                    <td align="center">
                                                        <span style="font-family:Arial; font-size:12; ">página</span>
                                                    </td>
                                                    <td align="center">
                                                        <span style="font-family:Arial; font-size:12; ">comentário</span>
                                                    </td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <xsl:for-each select="../evento">
                                                    <tr>
                                                        <td>
                                                            <xsl:for-each select="@data">
                                                                <xsl:value-of select="." />
                                                            </xsl:for-each>
                                                        </td>
                                                        <td>
                                                            <xsl:for-each select="pagina">
                                                                <xsl:apply-templates />
                                                            </xsl:for-each>
                                                        </td>
                                                        <td>
                                                            <xsl:for-each select="comentario">
                                                                <xsl:apply-templates />
                                                            </xsl:for-each>
                                                        </td>
                                                    </tr>
                                                </xsl:for-each>
                                            </tbody>
                                        </table>
                                    </xsl:if>
                                </xsl:for-each>
                            </xsl:for-each>
                        </p>
                        <span style="color:black; font-family:Verdana; font-weight:bold; ">Questões</span>
                        <br />
                        <br />
                        <xsl:for-each select="questao">
                            <xsl:if test="position()=1">
                                <table border="1">
                                    <thead>
                                        <tr>
                                            <td style="background-color:black; " align="center">
                                                <span style="color:white; font-family:Arial; font-size:12; font-weight:bold; ">id</span>
                                            </td>
                                            <td style="background-color:red; " align="center">
                                                <span style="color:white; font-family:Arial; font-size:12; font-weight:bold; ">qi</span>
                                            </td>
                                            <td style="background-color:blue; " align="center">
                                                <span style="color:white; font-family:Arial; font-size:12; font-weight:bold; ">tipo</span>
                                            </td>
                                            <td style="background-color:blue; " align="center">
                                                <span style="color:white; font-family:Arial; font-size:12; font-weight:bold; ">questão</span>
                                            </td>
                                            <td style="background-color:blue; " align="center">
                                                <span style="color:white; font-family:Arial; font-size:12; font-weight:bold; ">resposta</span>
                                            </td>
                                            <td style="background-color:blue; " align="center">
                                                <span style="color:white; font-family:Arial; font-size:12; font-weight:bold; ">observação</span>
                                            </td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <xsl:for-each select="../questao">
                                            <tr>
                                                <td>
                                                    <xsl:for-each select="@id">
                                                        <span style="font-family:verdana; font-size:12; ">
                                                            <xsl:value-of select="." />
                                                        </span>
                                                    </xsl:for-each>
                                                </td>
                                                <td>
                                                    <xsl:for-each select="@qi">
                                                        <span style="font-family:Verdana; font-size:12; ">
                                                            <xsl:value-of select="." />
                                                        </span>
                                                    </xsl:for-each>
                                                </td>
                                                <td>
                                                    <xsl:for-each select="@tipo">
                                                        <span style="font-family:Verdana; font-size:12; ">
                                                            <xsl:value-of select="." />
                                                        </span>
                                                    </xsl:for-each>
                                                </td>
                                                <td>
                                                    <xsl:for-each select="introducao">
                                                        <span style="font-family:Verdana; font-size:12; font-style:italic; ">
                                                            <xsl:apply-templates />
                                                        </span>
                                                    </xsl:for-each>
                                                </td>
                                                <td>
                                                    <xsl:for-each select="resposta">
                                                        <xsl:for-each select="@valor">
                                                            <span style="font-weight:bold; ">
                                                                <xsl:value-of select="." />
                                                            </span>
                                                        </xsl:for-each>
                                                    </xsl:for-each>
                                                </td>
                                                <td>
                                                    <xsl:for-each select="resposta">
                                                        <xsl:apply-templates />
                                                    </xsl:for-each>
                                                    <br />
                                                </td>
                                            </tr>
                                        </xsl:for-each>
                                    </tbody>
                                </table>
                            </xsl:if>
                        </xsl:for-each>
                    </xsl:for-each>
                </p>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
