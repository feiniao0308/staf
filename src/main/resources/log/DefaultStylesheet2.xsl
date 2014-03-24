<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:staf="http://logging.apache.org/log4j/2.0/events">
	<xsl:template match="/staf:Events">
		<html>
			<head>
				<title>STAF Log</title>
				<link type="text/css" href="../src/main/resources/log/screen.css"
					rel="stylesheet" />
			</head>
			<body>
				<div class="container">
					<h1>STAF Log - Execution Report</h1>
					<p>Welcome to the Staflog. This page displays the test case
						execution results.</p>
					<table border="0" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th class="span-4">Test Case Name</th>
								<th class="span-4">Execution Time</th>
								<th class="span-2">Pass Count</th>
								<th class="span-2">Fail Count</th>
								<th class="span-2">Pass Percentage</th>
							</tr>
						</thead>

						<!-- <xsl:for-each select="StafLogRoot/testcase"> <tr> <td> <xsl:value-of 
							select="name" /> </td> <td> <xsl:value-of select="time" /> </td> <td> <xsl:value-of 
							select="passcount" /> </td> <td> <xsl:value-of select="failcount" /> </td> 
							<td>90%</td> </tr> </xsl:for-each> -->
					</table>
					<br />
					<br />
					<br />

					<table border="0" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th class="span-2">Type</th>
								<th class="span-10">Message</th>
							</tr>
						</thead>

						<xsl:for-each select="staf:Event">
							<tr>
								<td>
									<xsl:value-of select="@level" />
								</td>
								<td>
									<xsl:value-of select="staf:Message" />
								</td>
								
							</tr>
						</xsl:for-each>
					</table>
				</div>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>