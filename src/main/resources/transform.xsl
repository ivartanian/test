<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xsl:for-each select="*/language">
            <name><xsl:value-of select="name"/></name>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>