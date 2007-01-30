<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
   <xsl:template match="/">
      <html>
         <head>
<script language="javascript">
                
<![CDATA[
                var state = 'hidden';

                function showhide2(argumento) {
                    alert('funcionou');
                }
                
                function showhide(layer_ref) {
                    if (state == 'visible') {
                        state = 'hidden';
                    } else {
                        state = 'visible';
                    }
                    if (document.all) { //IS IE 4 or 5 (or 6 beta)
                        eval( "document.all." + layer_ref + ".style.visibility = state");
                    }
                    if (document.layers) { //IS NETSCAPE 4 or below
                        document.layers[layer_ref].visibility = state;
                    }
                    if (document.getElementById && !document.all) {
                        maxwell_smart = document.getElementById(layer_ref);
                        maxwell_smart.style.visibility = state;
                    }
                }]]>

            
</script>
         </head>

         <body title="Base de Questões (E-valuation)">
            <p>
               <xsl:for-each select="Avaliacao">
                  <br />

                  <br />

                  <span style="color:black; font-family:Verdana; font-weight:bold; ">Questões sobre Java</span>

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
                              <xsl:for-each select="resposta">
                                 <xsl:variable name="Abstract" select="normalize-space(.)" />

                                 <xsl:variable name="my_id">
                                    <xsl:value-of select="generate-id()" />
                                 </xsl:variable>

                                 <td width="22">
                                    <span style="font-family:Arial; font-size:10; ">
                                       <a>
                                       <xsl:attribute name="href">javascript:showhide('<xsl:value-of select="$my_id" />');
                                       </xsl:attribute>
                                       RESPOSTA</a>
                                    </span>
                                 </td>

                                 <td colspan="6">
                                    <div style="visibility:hidden;">
                                       <xsl:attribute name="id">
                                          <xsl:value-of select="$my_id" />
                                       </xsl:attribute>

                                       <p>
                                          <xsl:for-each select="@valor">
                                             <span style="font-family:Verdana; font-size:12; font-weight:bold; ">
                                                <xsl:value-of select="." />
                                             </span>
                                          </xsl:for-each>

                                          <br>
                                          </br>

                                          <xsl:apply-templates />
                                       </p>
                                    </div>
                                 </td>
                              </xsl:for-each>
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

                           <tr>
                              <td align="left" width="32">
                                 <span style="font-family:Arial; font-size:10; ">qi:</span>
                              </td>

                              <td>
                                 <xsl:for-each select="@qi">
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

