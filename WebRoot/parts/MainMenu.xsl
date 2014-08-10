<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template name="mainmenu">
		<xsl:param name="selectedValue"/>
		<ul class="meuncss">
			<li id="right1" onMouseOver="turnit(1);" onMouseOut="outturnit(1);">
				<xsl:if test="$selectedValue = 1">
					<xsl:attribute name="class">one</xsl:attribute>
				</xsl:if>
				<xsl:if test="$selectedValue != 1">
					<xsl:attribute name="class">two</xsl:attribute>
				</xsl:if>
				<span>
					<a href="#" title=""><xsl:value-of select="$resource/data/MainMenu/Home" /><!-- 首页 --></a>
				</span>
			</li>
			<li id="right2" onMouseOver="turnit(2);" onMouseOut="outturnit(2);">
				<xsl:if test="$selectedValue = 2">
					<xsl:attribute name="class">one</xsl:attribute>
				</xsl:if>
				<xsl:if test="$selectedValue != 2">
					<xsl:attribute name="class">two</xsl:attribute>
				</xsl:if>
				<span>
					<a href="#" title=""><xsl:value-of select="$resource/data/MainMenu/Language" /><!-- 语言 --></a>
				</span>
			</li>
			<li id="right3" onMouseOver="turnit(3);" onMouseOut="outturnit(3);">
				<xsl:if test="$selectedValue = 3">
					<xsl:attribute name="class">one</xsl:attribute>
				</xsl:if>
				<xsl:if test="$selectedValue != 3">
					<xsl:attribute name="class">two</xsl:attribute>
				</xsl:if>
				<span>
					<a href="#" title=""><xsl:value-of select="$resource/data/MainMenu/Music" /><!-- 音乐 --></a>
				</span>
			</li>
			<li id="right4" onMouseOver="turnit(4);" onMouseOut="outturnit(4);">
				<xsl:if test="$selectedValue = 4">
					<xsl:attribute name="class">one</xsl:attribute>
				</xsl:if>
				<xsl:if test="$selectedValue != 4">
					<xsl:attribute name="class">two</xsl:attribute>
				</xsl:if>
				<span>
					<a href="#" title=""><xsl:value-of select="$resource/data/MainMenu/Group" /><!-- 小组 --></a>
				</span>
			</li>
			<li id="right5" onMouseOver="turnit(5);" onMouseOut="outturnit(5);">
				<xsl:if test="$selectedValue = 5">
					<xsl:attribute name="class">one</xsl:attribute>
				</xsl:if>
				<xsl:if test="$selectedValue != 5">
					<xsl:attribute name="class">two</xsl:attribute>
				</xsl:if>
				<span>
					<a href="#" title=""><xsl:value-of select="$resource/data/MainMenu/Tag" /><!-- 标签 --></a>
				</span>
			</li>
			<li id="right6" onMouseOver="turnit(6);" onMouseOut="outturnit(6);">
				<xsl:if test="$selectedValue = 6">
					<xsl:attribute name="class">one</xsl:attribute>
				</xsl:if>
				<xsl:if test="$selectedValue != 6">
					<xsl:attribute name="class">two</xsl:attribute>
				</xsl:if>
				<span>
					<a href="#" title=""><xsl:value-of select="$resource/data/MainMenu/Forum" /><!-- 论坛 --></a>
				</span>
			</li>
			<li id="right7" onMouseOver="turnit(7);" onMouseOut="outturnit(7);">
				<xsl:if test="$selectedValue = 7">
					<xsl:attribute name="class">one</xsl:attribute>
				</xsl:if>
				<xsl:if test="$selectedValue != 7">
					<xsl:attribute name="class">two</xsl:attribute>
				</xsl:if>
				<span>
					<a href="#" title=""><xsl:value-of select="$resource/data/MainMenu/Help" /><!-- 帮助 --></a>
				</span>
			</li>
			<li id="right8" onMouseOver="turnit(8);" onMouseOut="outturnit(8);">
				<xsl:if test="$selectedValue = 8">
					<xsl:attribute name="class">one</xsl:attribute>
				</xsl:if>
				<xsl:if test="$selectedValue != 8">
					<xsl:attribute name="class">two</xsl:attribute>
				</xsl:if>
				<span>
					<a href="#" title=""><xsl:value-of select="$resource/data/MainMenu/Favorate" /><!-- 收藏 --></a>
				</span>
			</li>			
		</ul>
	</xsl:template>
</xsl:stylesheet>
