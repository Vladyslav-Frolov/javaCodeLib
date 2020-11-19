<?xml version="1.0" encoding="UTF-8"?>
<!--ссылка на "http://www.w3.org/1999/XSL/Transform" является обязательной, иначе не обработает-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <!--Атрибут match используется для связи шаблона с элементом XML или со всем документом XML.
    Значением атрибута является любое выражение XPath. Например match="/" определяет весь документ.-->
    <xsl:template match="/">
        <html>
            <body>
                <h2>My CD Collection</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th style="text-align:left">Title</th>
                        <th style="text-align:left">Artist</th>
                        <th style="text-align:left">Company</th>
                    </tr>
                    <xsl:for-each select="catalog/cd"> <!--прохождение фор-ич + путь для DOM дерева в файле, где будет подключен обработчик-->
                        <tr>
                            <td><xsl:value-of select="title"/></td><!--велью ов ищет совпадение с title и подставляет его в таблицу-->
                            <td><xsl:value-of select="artist"/></td>
                            <td><xsl:value-of select="company"/></td>

                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

